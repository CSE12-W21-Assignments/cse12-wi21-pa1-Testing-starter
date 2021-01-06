
public class Basket0 implements Basket {

	@Override
	public int count() {
		return 0;
	}

	@Override
	public int countItem(Item i) {
		return 0;
	}

	@Override
	public int totalCost() {
		return 0;
	}

	@Override
	public void addToBasket(Item t) {
	}

	@Override
	public boolean removeFromBasket(Item i) {
		return false;
	}

	@Override
	public boolean removeAllFromBasket(Item i) {
		return false;
	}
	
	@Override
	public void empty() {
		return;
	}

}
