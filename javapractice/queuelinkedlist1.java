import java.util.Iterator;
public class queuelinkedlist<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	int N;
	
	private class Node{
		Item item;
		Node next;
	} 
	
	public boolean isEmpty() { return first == null;}
	public int Size(){return N;}	
	public void  enqueue(Item item){
		Node oldnode=last;
		last = new Node();
		last.item=item;
		last.next=null;
		if(isEmpty()) first=last;
		else oldnode.next=last;
		N++;
		System.out.println(item+" Added to stack");
	}
	
	public void  dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last=null;
		N--;
		System.out.println(item+" Removed from stack");
	}
	public void pop(){
		Node oldlast = new Node();	
		Item item = last.item;
		last.next= oldlast;
		if(isEmpty()) last=null;
		N--;
		System.out.println(item+" Removed from stack");
	}
	public void search(Item search){
		Node newfirst = new Node();
                newfirst = first;
                int count = 0;
		int flag = 0;
                while(count < Size()){
                        Item item= newfirst.item;
                        newfirst = newfirst.next;
                        if(item == search){ flag=1; break;}
                        count++;
                }
		if(flag == 1) System.out.println(search + " Found at position "+ count);
		else System.out.println(search + " Not found");
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
	public void delete(Item delitem){
		if(first.item.equals(delitem)){ dequeue(); return;}
		if(last.item.equals(delitem)){pop();return;}
		Node previous = new Node();
		previous = null;
		Node Current = new Node();
		Current = first;
		while(Current != null){
			if(Current.item.equals(delitem)){
				Current = Current.next;
				if(previous == null) previous = Current;
				else previous.next = Current;
				N--;
				break;
			}else{
				previous = Current;
				Current = Current.next;
			}
			
		}
	}
	public Iterator<Item> iterator(){	 
		return new ListIterator(); 
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){ 
			return current != null;
		}
		public void remove() { }
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String args[]){
		queuelinkedlist<Integer> q = new queuelinkedlist<Integer>();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.display();
		q.dequeue();
		q.display();
		q.enqueue(40);
		q.display();
		q.search(40);
		//q.pop();
		//q.pop();
		q.search(40);
		q.enqueue(150);
		q.enqueue(23);
		q.display();
		q.search(40);
		q.delete(23);
		q.enqueue(33);
		q.delete(20);
		q.display();
	}
}
