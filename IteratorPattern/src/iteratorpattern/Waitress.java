package iteratorpattern;
public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	
 
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		
	}
 
	public void printMenu() {
		Iterador pancakeIterador = pancakeHouseMenu.createIterator();
		Iterador dinerIterador = dinerMenu.createIterator();
		

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterador);
		System.out.println("\nLUNCH");
		printMenu(dinerIterador);
		System.out.println("\nDINNER");
		
	}
 
	private void printMenu(Iterador iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
 
	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n---------------");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		printVegetarianMenu(dinerMenu.createIterator());
		
	}
 
	public boolean isItemVegetarian(String name) {
		Iterador pancakeIterador = pancakeHouseMenu.createIterator();
		if (isVegetarian(name, pancakeIterador)) {
			return true;
		}
		Iterador dinerIterador = dinerMenu.createIterator();
		if (isVegetarian(name, dinerIterador)) {
			return true;
		}
		
		return false;
	}


	private void printVegetarianMenu(Iterador iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName() + ", ");
				System.out.print(menuItem.getPrice() + " -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}

	private boolean isVegetarian(String name, Iterador iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}
