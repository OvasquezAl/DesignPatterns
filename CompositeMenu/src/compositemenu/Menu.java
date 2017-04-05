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

import java.util.ArrayList;
import java.util.Iterator;


public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;
    

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        this.costoTotal=0;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        this.numElementos+=menuComponent.numElementos;
        this.costoTotal+=menuComponent.costoTotal;
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public int getNumElementos(){
        return numElementos;
    }
    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("Numero de elementos: "+numElementos);
        System.out.println("----------------");
        System.out.println("Costo total: "+costoTotal
        );

        Iterator it = menuComponents.iterator();
        while(it.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)it.next();
            menuComponent.print();      // will be called recursively!
        }
    }
    //tarea imprimir el costo total de los items y usar el remove
}
