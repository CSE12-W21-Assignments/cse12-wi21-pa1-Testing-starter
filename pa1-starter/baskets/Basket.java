
public interface Basket {
	/*
	 * @return the total count of all items, counting duplicates, in the basket.
	 */
	int count();

	/*
	 * @param i The item to count
	 * 
	 * @return The number of the provided Item that are in the basket
	 */
	int countItem(Item i);

	/*
	 * @return the total cost in cents of all items in the basket, counting duplicates
	 */
	int totalCost();

	/*
	 * @param i The item to add
	 */
	void addToBasket(Item t);

	/*
	 * Remove a single copy of an item from the basket
	 * 
	 * @param i The Item to remove
	 * 
	 * @return false if the item was not in the basket, true otherwise
	 */
	boolean removeFromBasket(Item i);

	/*
	 * Remove all copies of an item from the basket
	 * 
	 * @param i The Item to remove
	 * 
	 * @return false if the item was not in the basket, true otherwise
	 */
	boolean removeAllFromBasket(Item i);

	/*
	* Remove all items from the basket
	*/
	void empty();

}
