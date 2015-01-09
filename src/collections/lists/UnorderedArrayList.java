package collections.lists;

import utilities.Debug;

/**
 *
 * @author ctcrrmcidlk
 * @param <T>
 */
public class UnorderedArrayList<T extends Comparable> extends ArrayListClass<T> {
    
    // constructors
    public UnorderedArrayList() {
        super();
    }
    
    public UnorderedArrayList(int maxSize) {
        super(maxSize);
    }
    
    // public methods
    public void insert(T item) {
        super.insertEnd(item);
    }
    
    // overrides
    @Override
    public void insertAt(T item, int index) {
        super.insertAt(item, index);
    }
    
    @Override
    public void replaceAt(T item, int index) {
        super.replaceAt(item, index);
    }
    
    @Override
    public Object clone() { 
        UnorderedArrayList<T> newObj = new UnorderedArrayList(this.maxSize);
        
        for(T elem: this.list) {
            if (elem != null) {
                newObj.insertEnd(elem);
            }
        }
        
        Debug.println("Cloned ArrayListClass. length: " + newObj.size() + "; maxSize: " + newObj.maxSize());
        return newObj;        
    }
}
