package university.gui.domain;

import java.security.InvalidKeyException;
import java.util.Collection;
import java.util.Set;
//map
public interface Map<Key, Value> {
	 // Basic operations
    Value put(Key k, Value v) throws InvalidKeyException;
    Value get(Key k) throws InvalidKeyException;
    Value remove(Key k) throws InvalidKeyException;
    boolean containsKey(Key k);
    boolean containsValue(Value v);
    int size();
    boolean isEmpty();

    // Bulk operations
    void putAll(Map<? extends Key, ? extends Value> m);
    void clear();

    // Collection Views
    public Set<Key> keySet(); //public Iterable<K> keys()
    public Collection<Value> values(); //public Iterable<V> values();
    public Set<Map.Entry<Key,Value>> entrySet();

    // Interface for entrySet elements
    public interface Entry<Key,Value> {
    	
        Key getKey();
        Value getValue();
        Value setValue(Value v);
    }
}
