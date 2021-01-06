
import java.util.ArrayList;

public class Basket1 implements Basket {

	public Basket1() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	public int count() {
		return this.items.size();
	}

	@Override
	public int countItem(Item i) {
		int countItem = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			if (this.items.get(j) == i) {
				countItem += 1;
			}
		}
		return countItem;
	}

	@Override
	public int totalCost() {
		int price = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			price += this.items.get(j).priceInCents;
		}
		return price;
	}

	@Override
	public void addToBasket(Item i) {
		this.items.add(i);
	}

	@Override
	public boolean removeFromBasket(Item i) {
		return this.items.remove(i);
	}

	@Override
	public boolean removeAllFromBasket(Item i) {
		boolean removed = false;
		while (this.items.contains(i)) {
			removed = true;
			this.items.remove(i);
		}
		return removed;
	}
	
	@Override
	public void empty() {
		this.items.clear();
	}

}
