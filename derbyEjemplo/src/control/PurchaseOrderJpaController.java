/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Customer;
import modelo.Product;
import modelo.PurchaseOrder;

/**
 *
 * @author omar
 */
public class PurchaseOrderJpaController implements Serializable {

    public PurchaseOrderJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PurchaseOrder purchaseOrder) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customerId = purchaseOrder.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                purchaseOrder.setCustomerId(customerId);
            }
            Product productId = purchaseOrder.getProductId();
            if (productId != null) {
                productId = em.getReference(productId.getClass(), productId.getProductId());
                purchaseOrder.setProductId(productId);
            }
            em.persist(purchaseOrder);
            if (customerId != null) {
                customerId.getPurchaseOrderList().add(purchaseOrder);
                customerId = em.merge(customerId);
            }
            if (productId != null) {
                productId.getPurchaseOrderList().add(purchaseOrder);
                productId = em.merge(productId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPurchaseOrder(purchaseOrder.getOrderNum()) != null) {
                throw new PreexistingEntityException("PurchaseOrder " + purchaseOrder + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PurchaseOrder purchaseOrder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PurchaseOrder persistentPurchaseOrder = em.find(PurchaseOrder.class, purchaseOrder.getOrderNum());
            Customer customerIdOld = persistentPurchaseOrder.getCustomerId();
            Customer customerIdNew = purchaseOrder.getCustomerId();
            Product productIdOld = persistentPurchaseOrder.getProductId();
            Product productIdNew = purchaseOrder.getProductId();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                purchaseOrder.setCustomerId(customerIdNew);
            }
            if (productIdNew != null) {
                productIdNew = em.getReference(productIdNew.getClass(), productIdNew.getProductId());
                purchaseOrder.setProductId(productIdNew);
            }
            purchaseOrder = em.merge(purchaseOrder);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getPurchaseOrderList().remove(purchaseOrder);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getPurchaseOrderList().add(purchaseOrder);
                customerIdNew = em.merge(customerIdNew);
            }
            if (productIdOld != null && !productIdOld.equals(productIdNew)) {
                productIdOld.getPurchaseOrderList().remove(purchaseOrder);
                productIdOld = em.merge(productIdOld);
            }
            if (productIdNew != null && !productIdNew.equals(productIdOld)) {
                productIdNew.getPurchaseOrderList().add(purchaseOrder);
                productIdNew = em.merge(productIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = purchaseOrder.getOrderNum();
                if (findPurchaseOrder(id) == null) {
                    throw new NonexistentEntityException("The purchaseOrder with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PurchaseOrder purchaseOrder;
            try {
                purchaseOrder = em.getReference(PurchaseOrder.class, id);
                purchaseOrder.getOrderNum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The purchaseOrder with id " + id + " no longer exists.", enfe);
            }
            Customer customerId = purchaseOrder.getCustomerId();
            if (customerId != null) {
                customerId.getPurchaseOrderList().remove(purchaseOrder);
                customerId = em.merge(customerId);
            }
            Product productId = purchaseOrder.getProductId();
            if (productId != null) {
                productId.getPurchaseOrderList().remove(purchaseOrder);
                productId = em.merge(productId);
            }
            em.remove(purchaseOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PurchaseOrder> findPurchaseOrderEntities() {
        return findPurchaseOrderEntities(true, -1, -1);
    }

    public List<PurchaseOrder> findPurchaseOrderEntities(int maxResults, int firstResult) {
        return findPurchaseOrderEntities(false, maxResults, firstResult);
    }

    private List<PurchaseOrder> findPurchaseOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PurchaseOrder.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PurchaseOrder findPurchaseOrder(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PurchaseOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getPurchaseOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PurchaseOrder> rt = cq.from(PurchaseOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
