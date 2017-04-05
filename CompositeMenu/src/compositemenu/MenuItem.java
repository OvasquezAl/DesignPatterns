/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositemenu;

/**
 *
 * @author omar
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;
    double numeroItems;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price,
                    double numeroItems)
            
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
        this.numeroItems=numeroItems;
        this.numElementos=1;
        this.costoTotal=numeroItems*price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public double getNumeroItems() {
        return numeroItems;
    }

    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
        System.out.println("A pagar -- " + getPrice()*getNumeroItems());
    }
}
