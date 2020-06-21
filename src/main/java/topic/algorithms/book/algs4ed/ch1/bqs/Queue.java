package topic.algorithms.book.algs4ed.ch1.bqs;

public class Queue<Item> {
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public int size(){
		return N;
	}
	
	public void offer(Item e){
		// todo
		Node oldLast = last;
		last = new Node();
		last.item = e;
		last.next = null;
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}
	
	public Item poll(){
		Item item = null;
		if(!isEmpty()) {
			item = first.item;
			first = first.next;
			N--;
			if(isEmpty()) last = null;
		}
		return item;
	}
	
	public Item peek(){
		return null;
	}
	
	private class Node{
		Item item;
		Node next;
	}
}
