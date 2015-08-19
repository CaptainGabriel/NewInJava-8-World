package Patterns.Iterator_Pattern;

/**
 * Created by Pedro Gabriel on 11/06/2015.
 */
public class PancakeHouseMenuIterator implements IMenuIterator {

    private String[] items;
    private int actualPosition;

    public PancakeHouseMenuIterator(String... items) {
        this.items = items;
        actualPosition = 0;
    }

    @Override
    public String next() {
        String menuItem = items[actualPosition];
        actualPosition++;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        return (!(actualPosition >= items.length || items[actualPosition] == null));
    }
}
