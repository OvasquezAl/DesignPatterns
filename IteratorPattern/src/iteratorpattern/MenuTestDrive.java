/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorpattern;

/**
 *
 * @author omar
 */
public class MenuTestDrive {
    public static void main(String[] args){
        PancakeHouseMenu p=new PancakeHouseMenu();
        DinerMenu d=new DinerMenu();
        Mesera w=new Mesera(p, d);
        w.printMenu();
        
    }
}
