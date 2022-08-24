package hashmap;

import java.util.ArrayList;

class MapNode<K,V>{

	K key;
	V value;
	MapNode<K,V> next;

	public MapNode(K key,V value) {
		// TODO Auto-generated method stub
		this.key = key;
		this.value = value;
	}

}


// Implementing HashMap using Closed Hashing(using LL)

public class Map<K,V> {
	ArrayList <MapNode<K,V>> buckets;
	int count;
	int numBuckets;

	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 20; // considering bucket list length as 20
		for(int i=0;i<numBuckets;i++) {
			buckets.add(null);
		}
	}
	
	public double loadFactor() {
		return (1.0 * count) /numBuckets;
	}

	private void reHash() {
		ArrayList<MapNode<K,V>> temp = buckets;
		buckets = new ArrayList<>();
		for(int i=0;i<2*numBuckets;i++) {
			buckets.add(null);
		}
		count = 0;
		numBuckets = numBuckets*2;
		for(int i=0;i<temp.size();i++) {
			MapNode<K,V> head = temp.get(i);
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
		}

	}
	
	private int getBucketIndex(K key) {
		//generating hash code using inbuilt method of Object Class
		int hc = key.hashCode();
		int index = hc % numBuckets;
		return index;
	}

	public void insert (K key,V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		//element is not there ? just update its value
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// element is not there.insert at 0th position of linked list(inserting at front)
		head = buckets.get(bucketIndex);
		MapNode<K,V> newNode = new MapNode<>(key,value);
		newNode.next = head;
		buckets.set(bucketIndex , newNode);
		count++;

		double loadFactor = loadFactor();
		if(loadFactor >= 0.7) {
			reHash();
		}
	}


	

	//size
	public int size() {
		return count;
	}

	// search
	public V getValue(K key) {

		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}


	// remove
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		MapNode<K,V> prev = null;
		while(head != null) {
			if(head.key.equals(key)) {
				// we found the key, then let's remove it

				if(prev == null) { // if first node has the value
					buckets.set(bucketIndex, head.next);
				}else {
					prev.next = head.next;
				}
				count--;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
}
