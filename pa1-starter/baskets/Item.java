
public class Item {
	String name;
	int priceInCents;
	public Item(String name, int priceInCents) {
		this.name = name;
		this.priceInCents = priceInCents;
	}
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Item)) { return false; }
		Item i = (Item)other;
		return i.name.equals(this.name) && i.priceInCents == this.priceInCents;
	}
}
