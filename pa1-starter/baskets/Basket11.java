
import java.util.ArrayList;

public class Basket11 implements Basket {

	public Basket11() {
		this.items = new ArrayList<Item>();
		this.counts = new ArrayList<Integer>();
	}

	ArrayList<Item> items;
	ArrayList<Integer> counts;

	@Override
	public int count() {
		int count = 0;
		for (Integer i : this.counts) {
			count += i;
		}
		return count;
	}

	@Override
	public int countItem(Item i) {
		int index = 0;
		for (Item check : this.items) {
			if (check.equals(i)) {
				return this.counts.get(index);
			}
			index += 1;
		}
		return index;
	}

	@Override
	public int totalCost() {
		int price = 0;
		for (Item i : this.items) {
			price += i.priceInCents;
		}
		return price;
	}

	@Override
	public void addToBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			this.items.add(i);
			this.counts.add(1);
		} else {
			this.counts.set(index, this.counts.get(index) + 1);
		}
	}

	@Override
	public boolean removeFromBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, this.counts.get(index) - 1);
			return true;
		}
	}

	@Override
	public boolean removeAllFromBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, 0);
			return true;
		}
	}
	
	@Override
	public void empty() {
		this.items.clear();
		this.counts.clear();
	}

}
