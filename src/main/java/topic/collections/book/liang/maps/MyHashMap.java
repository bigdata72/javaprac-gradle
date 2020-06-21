package topic.collections.book.liang.maps;

import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K,V> implements MyMap<K,V> {
	
	// default hash table size. must be power of 2
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
	
	// max hash table size
	private static final int MAX_CAPACITY = 1 << 30; // same as 2^30
	
	// current hash table capacity. power of 2
	private int capacity;
	
	// load factor
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	// load factor threshold
	private float loadFactorThresold;
	
	// number of entries in map
	private int size = 0;
	
	// hash table is an array with each cell being a LinkedList of Map.Entry
	private LinkedList<MyMap.Entry<K,V>> [] table;
	
	// constructors
	public MyHashMap(){
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity){
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity, float threshold){
		if (initialCapacity > MAX_CAPACITY){
			this.capacity = MAX_CAPACITY;
		}else{
			this.capacity = trimToPowerOf2(initialCapacity);
		}
		this.loadFactorThresold = threshold;
		table = new LinkedList[capacity];
	}
	
	private int trimToPowerOf2(int initCapacity){
		return 2; // stub
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		size = 0;
		removeEntries();
	}
	
	private void removeEntries(){
		// clear the map entries
		for(int i=0; i < capacity; i++){
			if(table[i] != null)
				table[i].clear();
		}
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public V put(K key, V value) {
		if(get(key) != null){
			// replace old Value and return old Value
			int bucketIndex = hash(key.hashCode());
			LinkedList<Entry<K,V>> bucket = table[bucketIndex];
			for(Entry<K,V> entry : bucket){
				if(entry.getKey().equals(key)){
					V oldValue = entry.getValue();
					entry.value = value; // set new value
					return oldValue;
				}
			}
		}
		// check load factor
		if(size >= capacity * loadFactorThresold){
			if(capacity == MAX_CAPACITY)
				throw new RuntimeException("Max capacity exceeded");
			// rehash() // TODO
		}
		
		int bucketIndex = hash(key.hashCode());
		
		// create a LinkedList for the bucket if not already created
		if(table[bucketIndex] == null){
			table[bucketIndex] = new LinkedList<>();
		}
		
		// add a new entry to the hash table
		table[bucketIndex].add(new MyMap.Entry<>(key, value));
		
		size++; // increase size
		
		return value;
		
	}
	
	@Override
	// return the value that matches the key
	public V get(K key) {
		int bucketIndex = hash(key.hashCode());
		if(table[bucketIndex] != null){
			LinkedList<Entry<K,V>> bucket = table[bucketIndex];
			for(Entry<K,V> entry : bucket){
				if(entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
	
	@Override
	public boolean containsKey(K key) {
		return false;
	}
	
	@Override
	public boolean containsValue(V value) {
		return false;
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}
	
	@Override
	public Set<K> keySet() {
		return null;
	}
	
	@Override
	public Set<V> values() {
		return null;
	}
	
	@Override
	public void remove(K key) {
	
	}
	
	private int hash(int hashCode){
		return supplementalHash(hashCode) & (capacity -1);
	}
	
	private static int supplementalHash(int h){
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}
