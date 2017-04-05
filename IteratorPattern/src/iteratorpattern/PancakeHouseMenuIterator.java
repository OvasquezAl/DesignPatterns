package iteratorpattern;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterador {
	ArrayList<Object> items;
	int position = 1;
 
	public PancakeHouseMenuIterator(ArrayList items) {
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
		if (position >= items.size() || items.get(position) == null) {
			return false;
		} else {
			return true;
		}
	}
}