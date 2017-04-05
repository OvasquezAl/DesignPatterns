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

public class DinerMenuIterador implements Iterador {
	MenuItem[] items;
	int position = 0;
        private int pi=0;
        private int pf=items.length;
        private int paso=1;
 
	public DinerMenuIterador(MenuItem[] items) {
		this.items = items;
	}
        
        public void iteradorRango(int vi , int vf, MenuItem[] items){
        pi=vi<0||vi>items.length? 0:vi;
        pf=vf>=pi&&vf>items.length? vf:items.length;
        position=pi;
        this.items = items;
        }
        
        public void iteradorRangoPaso(int vi , int vf, int paso, MenuItem[] items){
        pi=vi<0||vi>items.length? 0:vi;
        pf=vf>=pi&&vf>items.length? vf:items.length;
        position=pi;
        this.paso=paso;
        this.items = items;
        }
 
	public Object next() {
		MenuItem menuItem = items[position];
		position = position + paso;
		return menuItem;
	}
 
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}
     /*   
        public void remove(){
        if(position<=0){
            throw new IllegalStateException
                    ("No puedes borrar un item hasta que hayas hecho al menos un siguiente");
        }
        if(items[position-1]!=null){
            for(int i=position-1;i<(items.length-1);i++){
                items[i]=items[i+1];
            }
            items[items.length-1]=null;
        }
        }*/
}

