package Patterns.Iterator_Pattern;

/**
 * Created by Pedro Gabriel on 11/06/2015.
 */
public class PancakeHouseMenu implements IMenu {

    private static final int MAX_TOTAL_ITEMS = 10;

    /**
     * Current number of elements inside our menu list.
     */
    private int numberOfItems;

    /**
     * Our menu list.
     *
     */
    String[] items;

    /**
     * ctor
     */
    public PancakeHouseMenu(){
        items = new String[MAX_TOTAL_ITEMS];
        numberOfItems = 0;
        addItem("Vegetarian Soup");
        addItem("Summer fruit quinoa salad");
        addItem("Summer braised chicken with tomatoes");
        addItem("Summer ham & pea broth");
        addItem("Slow-roast tomato Tatin");
        addItem("Lamb, apricot & shallot tagine");
    }

    @Override
    public IMenuIterator createIterator() {
        return new PancakeHouseMenuIterator(items);
    }

    private boolean addItem(java.lang.String newMenu){
        if (numberOfItems >= MAX_TOTAL_ITEMS)
            return false;
        items[numberOfItems] = newMenu;
        numberOfItems++;
        return true;
    }

}
