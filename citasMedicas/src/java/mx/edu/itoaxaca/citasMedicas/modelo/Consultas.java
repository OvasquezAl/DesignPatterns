/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omar
 */
@Entity
@Table(name = "CONSULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultas.findAll", query = "SELECT c FROM Consultas c")
    , @NamedQuery(name = "Consultas.findByIdconsulta", query = "SELECT c FROM Consultas c WHERE c.idconsulta = :idconsulta")
    , @NamedQuery(name = "Consultas.findByIdpaciente", query = "SELECT c FROM Consultas c WHERE c.idpaciente = :idpaciente")
    , @NamedQuery(name = "Consultas.findByIdcita", query = "SELECT c FROM Consultas c WHERE c.idcita = :idcita")
    , @NamedQuery(name = "Consultas.findByDiagnostico", query = "SELECT c FROM Consultas c WHERE c.diagnostico = :diagnostico")})
public class Consultas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONSULTA")
    private Integer idconsulta;
    @Column(name = "IDPACIENTE")
    private Integer idpaciente;
    @Column(name = "IDCITA")
    private Integer idcita;
    @Size(max = 100)
    @Column(name = "DIAGNOSTICO")
    private String diagnostico;

    public Consultas() {
    }

    public Consultas(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultas)) {
            return false;
        }
        Consultas other = (Consultas) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.itoaxaca.citasMedicas.modelo.Consultas[ idconsulta=" + idconsulta + " ]";
    }
    
}
