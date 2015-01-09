package collections.lists;

/**
 * 
 * @author ctcrrmcidlk
 * @param <T>
 */
public class OrderedArrayList<T extends Comparable> extends ArrayListClass<T> {
    // constructors
    public OrderedArrayList() {
        super();
    }
    
    public OrderedArrayList(int maxSize) {
        super(maxSize);
    }
    
    // public methods    
    public void insert(T item) {
        // need to insert at correct position to make sure the list remains sorted and we don't have to sort after
        // every insert
        
        for (int i = 0; i < this.length; ++i) {
            Comparable<T> elem = (Comparable<T>)this.list[i];

            if (elem.compareTo(item) >= 0) {
                super.insertAt(item, i); // When inserting, just use the base class (no need to reinvent the... insert)
                return;
            }
        }

        super.insertEnd(item);
    }
    
    public void removeDuplicates() {
        if (this.length < 2) return; // can't have duplicates if there's less than two items
        
        T compareValue = this.list[length - 1];
        
        for (int i = length - 2; i > -1; --i) {
            if (this.isItemAtEqual(i, compareValue)) {
                this.removeAt(i);
            }
            else {
                compareValue = this.list[i];
            }
        }
    }
    
    // Overrides (This is where things get interesting)
    
    @Override
    public void remove(T item) {
        int location = seqSearch(item); // use this seqSearch since it's better performance for average case
        
        if (location > -1) {
            super.removeAt(location);
        }
    }
    
    
    @Override
    public int seqSearch(T searchItem) {
        int location = -1;
        
        for (int i = 0; i < this.length; ++i) {
            Comparable<T> temp = (Comparable<T>)this.list[i];
            int compareResult = temp.compareTo(searchItem);
            
            if (compareResult == 0) {   // find a match? return the location.
                location = i;
                break;
            }
            else if (compareResult > 0) { // list[i] > searchItem? return -1
                break;
            }
        }
        
        return location;
    }
}
