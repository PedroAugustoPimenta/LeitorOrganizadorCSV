
package csv;

import java.util.Comparator;


public class Comparador implements Comparator<Item> {

    
    @Override
    public int compare(Item t, Item t1) {
        String a,b;
        a = t.getSite();
        b = t1.getSite();
        
        return a.compareTo(b);
    }
    
}
