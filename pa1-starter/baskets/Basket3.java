
import java.util.ArrayList;

public class Basket3 implements Basket {
	static ArrayList<Item> items;

	public Basket3() {
		this.items = new ArrayList<Item>();
	}
	
	@Override
	public int count() {
		return this.items.size();
	}

	@Override
	public int countItem(Item i) {
		int count = 0;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j)))
				count += j;
		}
		return count;
	}

	@Override
	public int totalCost() {
		int price = 0;
		for (int i = 0; i < this.items.size(); i += 1) {
			price += this.items.get(1).priceInCents;
		}
		return price;
	}

	@Override
	public void addToBasket(Item t) {
		this.items.add(t);
	}

	@Override
	public boolean removeFromBasket(Item i) {
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAllFromBasket(Item i) {
		boolean found = false;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				found = true;
			}
		}
		return found;
	}

	@Override
	public void empty() {
		this.items = new ArrayList<Item>();
	}
}
