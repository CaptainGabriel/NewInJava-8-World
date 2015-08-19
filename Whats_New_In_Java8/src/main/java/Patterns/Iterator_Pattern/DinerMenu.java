package Patterns.Iterator_Pattern;

/**
 * Created by Pedro Gabriel on 11/06/2015.
 */
public class DinerMenu implements IMenu {

    private static final int MAX_TOTAL_ITEMS = 10;

    /**
     * Current number of elements inside our menu list.
     */
    private int numberOfItems;

    /**
     * Our menu list.
     */
    java.lang.String[] items;

    /**
     * Ctor.
     * (menus don't make mush sense, I know..)
     */
    public DinerMenu(){
        items = new java.lang.String[MAX_TOTAL_ITEMS];
        numberOfItems = 0;
        addItem("Vegetarian Soup");
        addItem("Strawberry & almond cheesecake sponge");
        addItem("Ricotta dip with crushed tomatoes & bruschetta");
        addItem("Individual summer puddings");
        addItem("Summer beans on toast with prosciutto");
        addItem("Lemon cheesecake with baked plums & blackberries");
    }


    @Override
    public IMenuIterator createIterator() {
        return new DinerMenuIterator(items);
    }


    /**
     * Helper method to used every time we want to add a new menu to the list.
     *
     * @param newMenu New menu to insert into the list
     * @return TRUE if its possible to insert the new menu, FALSE otherwise.
     */
    private boolean addItem(java.lang.String newMenu){
        if (numberOfItems >= MAX_TOTAL_ITEMS)
            return false;
        items[numberOfItems] = newMenu;
        numberOfItems++;
        return true;
    }
}
