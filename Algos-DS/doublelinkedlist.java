import java.util.Iterator;
public class doublelinkedlist<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;

	private class Node{
		Node next;
		Node prev;
		Item item;
	}
	
	public boolean isEmpty() {return first == null;}
	public int Size(){return N;}
	public void enqueue(Item item){
		Node oldnode = last;
		Node last = new Node();
		last.item = item;
		last.next=null;
		if(isEmpty()){first = last;}
		else{
			 oldnode.next=last;
			 last.prev=oldnode;
		}
		N++;
		System.out.println(item + " Added to queue");
	}
	public void display(){
                System.out.println("Contents of queue are");
                Node newfirst = new Node();
                newfirst = first;
                int count = 0;
                while(count < Size()){
                        Item item= newfirst.item;
                        newfirst = newfirst.next;
                        System.out.println(item);
                        count++;
                }
        }
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node Current = first;
		public boolean hasNext(){
			return Current != null;
		}
		public boolean hasPrev(){
			return N>1;
		}
		public Item next(){
			Item item = Current.item;
			Current = Current.next;
			return item;
		}
		public void remove() { }
		public Item prev(){
			//Item item = Current.item;
			Current = Current.prev;
			Item item = Current.item;
			return item;
		}
	}
	public static void main(String args[]){
		doublelinkedlist<Character> q = new doublelinkedlist<Character>();
		q.enqueue('A');
		q.enqueue('X');
		q.enqueue('B');
		q.enqueue('Y');
		q.enqueue('C');
		q.enqueue('Z');
		q.display();
	}
}
