package Patterns.Iterator_Pattern;

/**
 * Created by Pedro Gabriel on 11/06/2015.
 */
public class DinerMenuIterator implements IMenuIterator {

    private String[] items;
    private int actualPosition;

    public DinerMenuIterator(String... items){
        this.items = items;
        actualPosition = 0;
    }


    @Override
    public boolean hasNext() {
        return (!(actualPosition >= items.length || items[actualPosition] == null));
    }

    @Override
    public String next() {
        return items[actualPosition++];
    }
}
