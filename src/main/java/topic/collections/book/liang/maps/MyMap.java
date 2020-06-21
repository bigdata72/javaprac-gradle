package topic.collections.book.liang.maps;

import java.util.Set;

public interface MyMap<K,V> {

	int size();
	void clear();
	boolean isEmpty();
	V put(K key, V value);
	V get(K key);
	boolean containsKey(K key);
	boolean containsValue(V value);
	Set<Entry<K,V>> entrySet();
	Set<K> keySet();
	Set<V> values();
	void remove(K key);
	
	public static class Entry<K,V>{
		K key;
		V value;
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		K getKey(){
			return this.key;
		}
		
		V getValue(){
			return this.value;
		}
	}
	
}
