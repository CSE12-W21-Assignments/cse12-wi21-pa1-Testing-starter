
public class Basket4 implements Basket {

	private Item[] items;
	
	public Basket4() {
		this.items = new Item[10];
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
			total += this.items[i].priceInCents;
		}
		return total;
	}

	@Override
	public void addToBasket(Item t) {
		boolean setSomething = false;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == null)  {
				setSomething = true;
				this.items[i] = t;
				return;
			}
		}
		if(!setSomething) {
			Item[] oldItems = this.items;
			this.items = new Item[this.items.length * 2];
			for(int i = 0; i < items.length; i += 1) {
				this.items[i] = oldItems[i];
			}
			this.items[oldItems.length] = t;
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
