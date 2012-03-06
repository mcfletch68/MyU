package university.gui.domain;

import java.io.Serializable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashTable<Key, Value> implements Map<Key, Value>, Serializable{
	public class HashEntry<Key, Value> implements Entry<Key, Value>{
        //create instance variables k and v for the object HashEntry
		protected Key k;
        protected Value v;
        
        //create the object HashEntry
		public HashEntry(Key k, Value v){
			this.k = k;
			this.v = v;
		}
		public Key getKey() {
			
			return k;
		}
		public Value getValue() {
			
			return v;
		}
		public Value setValue(Value newV) {
			
			Value oldV = v;
			v = newV;
			return oldV;
			
		}
		//check to see if key and value of the given object is equal
		public boolean equals(Object o){
			HashEntry<Key, Value> ent;
			try{
				ent = (HashEntry<Key, Value>)o;
			}
			catch(ClassCastException ex){
				return false;
			}
			return (ent.getKey() == k) && (ent.getValue()== v);
		}
		
	}
	protected Entry<Key, Value> AVAILABLE = new HashEntry<Key, Value>(null, null);
	protected int N = 0;  //number of entries in Hash table
	protected int prime, capacity;  //prime factor and capacity of bucket array
	protected Entry<Key, Value>[] bucket;  //bucket array
	protected long scale, shift;  //the shift and scaling factors
	
	/**Creates a hash table with the given prime factor and capacity.*/
	public HashTable(int p, int cap){
		prime = p;
		capacity = cap;
		/*Creates a new array of Entry objects of capacity size and 
		 * assigns to bucket(after safe casting it as well)*/
		bucket = (Entry<Key, Value>[]) new Entry[capacity]; 
		Random rand = new Random();  //create Random object (a random number generator object)
		scale = rand.nextInt(prime-1) + 1;  //
		shift = rand.nextInt(prime);
	}
	/**Creates a hash table with prime factor 109345121 and given capacity.*/
    public HashTable(int cap){
    	/**This calls the class'(HashTable.java) constuctor.*/
    	this(109345121, cap);
    }
    /**Determines whether a key is valid.*/
    protected void checkKey(Key k){
    	if(k == null) throw new InvalidException("Invalid key: null.");
    }
    /**Hash function applying MAD(Multiply Add and Divide) method to default hash code.*/
    public int hashValue(Key k){
    	return (int)((Math.abs(k.hashCode()*scale + shift) % prime) % capacity);
    }
    /**Returns the number of entries in the hash table*/
    public int size(){
    	return N;
    }
    public boolean isEmpty(){
    	return(N == 0);
    }
    /**Returns a set of keys*/ //replaces keys() 
    public Set<Key> keySet() {
    	Set<Key> keys = new HashSet<Key>();
    	for(int i = 0; i < capacity; i++)
    		if((bucket[i]!=null) && (bucket[i] != AVAILABLE))
    			keys.add(bucket[i].getKey());
		return keys;
	}
    //algorithm to find index of found key
    public int findEntry(Key k) {
    	int avail = -1;
    	checkKey(k);
    	int i = hashValue(k);
    	int j = i;
    	
    	do{
    		Entry<Key, Value> e = bucket[i];
    		//if bucket spot is empty set the index to avail
    		if(e == null){
    			if(avail < 0)
    				avail = i;  //key is not in table
    			break;
    		}
    		if(k.equals(e.getKey())) //if we find our key
    			return i;  //key found
    		if(e == AVAILABLE){
    			if(avail < 0)
    				avail = i;  //this slot is available
    		}
    		i = (i + 1) % capacity;  //keep looking
    	}while(i != j);
    	return -(avail + 1);  //return the first available or empty slot
    }
	public Value put(Key k, Value v) throws InvalidKeyException{
		int i = findEntry(k);  //find the right spot for this entry
		if(i >= 0) //this key has prev value
			return((HashEntry<Key, Value>) bucket[i]).setValue(v);  //set new value
		if(N >= capacity/2){
			rehash();  //rehash to keep the load factor <= 0.5
			i = findEntry(k);  //find again the right spot for this entry
		}
		bucket[-i-1] = new HashEntry<Key, Value>(k, v);  //convert to proper index
		N++;
		return null; //there was no previous value
	}
	/**Doubles the size of the hash table and rehashes all the entries.
	 * @throws  */
	protected void rehash(){
	    capacity = 2*capacity;
	    Entry<Key,Value>[] old = bucket;
	    bucket = (Entry<Key,Value>[]) new Entry[capacity]; // new bucket is twice as big 
	    Random rand = new Random();
	    scale = rand.nextInt(capacity-1) + 1;    	// new hash scaling factor
	    shift = rand.nextInt(capacity); 		// new hash shifting factor
	    for (int i=0; i<old.length; i++) {
	      Entry<Key,Value> e = old[i];
	      if ((e != null) && (e != AVAILABLE)) { // a valid entry
	    	  int j = - 1 - findEntry(e.getKey());
	    	  bucket[j] = e;
	      }
	    }
	}
	/**Returns the value associated with a key*/
	public Value get(Key k) throws InvalidKeyException {
		int i = findEntry(k);  //use search algorithm
		if(i < 0) 
			return null;  //no value for this key; return null
		return bucket[i].getValue();  //return the found value
	}
	public Value remove(Key k) {
		 int i = findEntry(k);  	// find this key first
		 if (i < 0) return null;  	// nothing to remove
		 Value toReturn = bucket[i].getValue();
		 bucket[i] = AVAILABLE; 		// mark this slot as deactivated
		 N--;
		 return toReturn;
	}
	
	@Override
	public boolean containsKey(Object k) {
		
		return false;
	}
	@Override
	public boolean containsValue(Object v) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public Collection<Value> values() {
		 Collection<Value> values = new HashSet<Value>();
		 for (int i=0; i<capacity; i++) 
		   if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) 
			 values.add(bucket[i].getValue());
		 return values;
		
	}
	public Set<Map.Entry<Key, Value>> entrySet() {
		 Set<Entry<Key,Value>> entries = new HashSet<Entry<Key,Value>>();
		 for (int i=0; i<capacity; i++) 
		   if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) 
			 entries.add(bucket[i]);
		 return entries;
	}
}
