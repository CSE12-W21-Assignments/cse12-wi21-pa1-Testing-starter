
public class Basket2 implements Basket {

	private Item[] items;
	
	public Basket2() {
		this.items = new Item[1000];
	}
	
	@Override
	public int count() {
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] != null)  { count += 1; }
		}
		return count;
	}

	@Override
	public int countItem(Item item) {
		if(item == null) { return 0; }
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  { count += 1; }
		}
		return count;
	}

	@Override
	public int totalCost() {
		int total = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] != null) {
			  total += this.items[i].priceInCents;
			}
		}
		return total;
	}

	@Override
	public void addToBasket(Item t) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == null)  {
				this.items[i] = t;
				return;
			}
		}
	}

	@Override
	public boolean removeFromBasket(Item item) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAllFromBasket(Item item) {
		boolean found = false;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				found = true;
			}
		}
		return found;
	}
	@Override
	public void empty() {
		for(int i = 0; i < this.items.length; i += 1) {
			this.items[i] = null;
		}
	}
}
