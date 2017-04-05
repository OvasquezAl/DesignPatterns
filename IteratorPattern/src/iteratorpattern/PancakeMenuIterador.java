package iteratorpattern;

import java.util.ArrayList;

public class PancakeMenuIterador implements Iterador {
	ArrayList<Object> items;
	private int position = 1;
        private int pi=0;
        private int pf;
        private int paso;
        
        public void iteradorRango(int vi , int vf, ArrayList items){
            pi=vi<0||vi>items.size()? 0:vi;
            pf=vf>=pi&&vf>items.size()? vf:items.size();
            position=pi;
            this.items = items;
        }
        
        public void iteradorRangoPaso(int vi , int vf, int paso, ArrayList items){
            pi=vi<0||vi>items.size()? 0:vi;
            pf=vf>=pi&&vf>items.size()? vf:items.size();
            position=pi;
            this.paso=paso;
            this.items = items;
        }
        
        
	public PancakeMenuIterador(ArrayList items) {
		this.items = items;
	}
 @Override
	public Object next() {
		MenuItem menuItem = (MenuItem)items.get(position);
		position = position + 1;
		return menuItem;
	}
 @Override
	public boolean hasNext() {
            return !items.isEmpty()&&position<pf;
        }
}