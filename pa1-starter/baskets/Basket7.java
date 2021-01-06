
import java.util.ArrayList;
import java.util.Arrays;

public class Basket7 implements Basket {

    public Basket7() {
        this.items = new ArrayList<ArrayList<Item>>();
    }

    ArrayList<ArrayList<Item>> items;

    @Override
    public int count() {
        int count = 0;
        for (int i = 1; i < this.items.size(); i++) {
            count += this.items.get(i).size() * i;
        }
        return count;
    }

    @Override
    public int countItem(Item i) {
        for (int j = 0; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return j;
        }
        return 0;
    }

    @Override
    public int totalCost() {
        int totalCost = 0;
        for (int i = 1; i < this.items.size(); i++) {
            for (Item item : this.items.get(i)) {
                totalCost += item.priceInCents * i;
            }
        }
        return totalCost;
    }

    @Override
    public void addToBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                if (j + 1 == this.items.size()) {
                    ArrayList<Item> temp = new ArrayList<Item>();
                    temp.add(i);
                    this.items.add(temp);
                } else{
                    this.items.get(j + 1).add(i);
                }
                return;
            }
        }
        while(this.items.size() <= 1)
            this.items.add(new ArrayList<Item>());
        this.items.get(1).add(i);
    }

    @Override
    public boolean removeFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                this.items.get(j - 1).add(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAllFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return this.items.get(j).remove(i);
        }
        return false;
    }

    @Override
    public void empty() {
        this.items.clear();
    }
}
