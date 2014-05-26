import java.util.Iterator;
class Link<Item>{
	public Link next;
	public Link prev;
	public Item item;
	public void display(){
		System.out.println(item+ "");
	}
}
class singlelinkedlist<Item>{
	private Link first;
	private Link last;
	private int N;
	public singlelinkedlist(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public void enqueue(Item item){
		Link newlast = new Link();
		newlast.item = item;
		newlast.next = null;
		if(isEmpty()) first = newlast;
		else last.next = newlast;
		last = newlast;
		N++;
		System.out.println(item + " Added to queue");
	}
	public void enqueuefirst(Item item){
		Link newfirst = new Link();
		newfirst.item = item;
		if(isEmpty())last = newfirst;
		else newfirst.next=first; 
		first = newfirst;
		N++;
		System.out.println(item+" Added at first position");
	}
	public void deletebegin(){
		if(!isEmpty()){
			System.out.println(first.item+ " Deleted from queue");
			first = first.next;
			N--;
		}
		else{
			System.out.println("Queue Empty no item to delete");
		}
	}
	public void deleteend(){
		Link Current = new Link();
		Link Previous = new Link();
		Current = first;
		Previous = null;
		int count = 0;
		if(isEmpty()){System.out.println("Queue empty no item to delete"); return;}
		while(count < N){
			if(Current.item.equals(last.item)){ System.out.println(last.item + " Deleted from queue"); break;}
			else{Previous = Current; Current = Current.next; count++;}
		}
		last = Previous;
		if(isEmpty() || last == null){last = null;first = null;}
		N--;
	}
	public void search(Item item){
		Link Current = new Link();
		Current = first;
		int Count = 0;
		int flag = 0;
		while(Count < N){
			if(Current.item.equals(item)) {flag = 1; break;}
			else{
				Current = Current.next;
				Count++;
			}
		}
		if(flag == 1) System.out.println(item + " found at " + Count +" position");
		else System.out.println(item + " not found");
	}	
	public void delete(Item delitem){
		if(first.item.equals(delitem)){ deletebegin(); return;}
                if(last.item.equals(delitem)){deleteend();return;}
		Link Current = new Link();
		Link Previous = new Link();
		Current = first;
		Previous = null;
		int Count = 0;
		while(Count < N){
			if(Current.item.equals(delitem)){
				Previous.next = Current.next;
				N--;
				break;
			}
			else{
				Previous = Current;
				Current = Current.next;
				Count++;
			}
		}
		System.out.println(delitem + " deleted");
	}

		Link Current = new Link();
		Current = first;
		int count=0;
		if(isEmpty()){System.out.println("Queue is Empty");return;}
		System.out.println("Content of Queue is");
		while(count < N){
			System.out.println(Current.item+ "");
			Current = Current.next;
			count++;
		}

	}
}
class doublelinkedlist<Item>{
	private Link first;
	private Link last;
	private int N;
	public doublelinkedlist(){
		first=null;
		last=null;
		N=0;
	}
	public boolean isEmpty(){
                return first == null;
        }

	public void insertfirst(Item item){
		Link firstnode = new Link();
		firstnode.item = item;
		firstnode.prev=null;
		if(isEmpty()){last = firstnode;}
		else {first.prev=firstnode;firstnode.next=first;}
		first = firstnode;
		N++;
		System.out.println(item + " Insereted at first position in double linked list");
	}
	public void insertlast(Item item){
		Link lastnode = new Link();
		lastnode.item = item;
		lastnode.next = null;
		if(isEmpty()){first = lastnode;}
		else{last.next = lastnode; lastnode.prev = last;}
		last = lastnode;
		N++;
		System.out.println(item + " inserted at last position");
	}
	public void insertitem(Item item,Item insitem,int pos){
                if(first.item.equals(item)){insertfirst(insitem); return;}
                if(last.item.equals(item)){insertlast(insitem);return;}
		Link Current = new Link();
                Current = first;
                Link Previous = new Link();
                Previous = null;
                Link insert = new Link();
		int count = 0;
		int flag = 0;
                while(count < N){
                        if(Current.item.equals(item)){
                                if(pos == 1){
					Previous = Current;
					Current = Current.next;
				}
				insert.item = insitem;
				insert.prev = Previous;
				insert.next = Current;
                                Previous.next = insert;
				Current.prev = insert;
                                N++;
                                flag = 1;
				break;
                        }else{
                                Previous = Current;
                                Current = Current.next;
                                count++;
                        }
                }
                if(flag == 0)System.out.println(item+ " Not in list" );
		else System.out.println(insitem+ " inserted after "+ item);
	}

	public void deletefirst(){
		if(!isEmpty()){
			System.out.println(first.item + "deleted from first");
			first = first.next;
			N--;
		}else{
			System.out.println("Nothing to delete");
		}
	}
	public void deletelast(){
		if(!isEmpty()){
			System.out.println(last.item + " deleted from end");
			last = last.prev;
			N--;
		}else{
			System.out.println("Nothing to delete");
		}
	
	}
	public void deleteitem(Item item){
		if(first.item.equals(item)){ deletefirst(); return;}
                if(last.item.equals(item)){deletelast();return;}
		Link Current = new Link();
		Current = first;
		Link Previous = new Link();
		Previous = null;
		int count = 0;
		while(count < N){
			if(Current.item.equals(item)){
				Previous.next = Current.next;
				Current = Current.next;
				Current.prev = Previous;
				N--;
				break;
			}else{
				Previous = Current;
				Current = Current.next;
				count++;
			}
		}
		System.out.println(item + " deleted at "+ count + " position");
	}
		
	public void display(){
		Link Newfirst = new Link();
		Newfirst = first;
		int count = 0;
		System.out.println("Content of double linked list queue is");
		while(count < N){
			System.out.println(Newfirst.item+"");
			Newfirst= Newfirst.next;
			count++;
		}
	
	}
	public void displaybackward(){
		Link backward = new Link();
		backward = last;
		int count =0;
		System.out.println("Content of queue in backwards is");
		while(count < N){
			System.out.println(backward.item+"");
			backward = backward.prev;
			count++;
		}
	}
	public void search(Item item){
		Link Newfirst = new Link();
                Newfirst = first;
                int count = 0;
		int flag = 0;
                while(count < N){
                        if(Newfirst.item.equals(item)){ 
				flag = 1;
				break;
			}else{
				Newfirst= Newfirst.next;
                        	count++;
			}
                }
		if(flag == 0)System.out.println(item +" Not found");
		else System.out.println(item+" Found at "+ count +" postion");

	}
}
public class queuell{
	public static void main(String args[]){
		singlelinkedlist<Integer> sll = new singlelinkedlist<Integer>();
		sll.enqueue(10);
		sll.enqueue(20);
		sll.enqueue(30);
		sll.display();
		sll.enqueuefirst(40);
		sll.enqueuefirst(50);
		sll.search(50);
		sll.deletebegin();
		sll.search(50);
		sll.display();
		sll.search(10);
		sll.deleteend();
		sll.display();
		sll.enqueue(23);
		sll.deletebegin();
		sll.deletebegin();
		sll.deletebegin();
		sll.deleteend();
		sll.enqueue(33);
		sll.deletebegin();
		sll.deleteend();
		sll.enqueue(10);
                sll.enqueue(20);
                sll.enqueue(30);
		sll.delete(20);
		sll.display();
		doublelinkedlist<Integer> dll = new doublelinkedlist<Integer>();
		dll.insertfirst(10);
		dll.insertfirst(20);
		dll.insertfirst(30);
		dll.deletelast();
		dll.insertfirst(10);
		dll.deletefirst();
		dll.insertlast(10);
		dll.display();
		dll.displaybackward();
		dll.search(20);
		dll.search(23);
		dll.deleteitem(20);
		dll.insertlast(40);
		dll.display();
		dll.insertitem(10,50,1);
		dll.display();
		dll.displaybackward();
		dll.insertitem(50,45,0);
		dll.insertitem(30,7,0);
		dll.insertitem(40,9,0);
		dll.display();
		dll.displaybackward();
	}
}
