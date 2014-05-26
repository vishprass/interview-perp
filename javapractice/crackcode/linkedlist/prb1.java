import java.util.Hashtable;
class Node{
	Node prev;
	Node next;
	Comparable item;
}
class singlelinkedlist{
	private Node first;
	private Node last;
	int N;
	public boolean isEmpty(){ return first == null;}
	public void insertlast(Comparable item){
		Node lastnew = new Node();
		lastnew.item = item;
		lastnew.next = null;
		if(isEmpty()){first = lastnew;}
		else{last.next = lastnew;}
		last = lastnew;
		N++;
	}
	public void insertfirst(Comparable item){
                Node firstnew = new Node();
                firstnew.item = item;
                if(isEmpty()){last = first;}
		else{firstnew.next = first;}
                first = firstnew;
                N++;
        }
	public void push(Comparable item){
                Node firstnew = new Node();
                firstnew.item = item;
                if(isEmpty()){last = first;}
                else{firstnew.next = first;}
                first = firstnew;
                N++;
        }

	public void delete(){
		Comparable item = "";
		if(!isEmpty()){
			item = first.item;
			first = first.next;
			N--;
		}
		System.out.println(item + " Removed from queue");
	}
	public void pop(){
                Comparable item = "";
                if(!isEmpty()){
                        item = first.item;
                        first = first.next;
                        N--;
                }
                System.out.println(item + " Removed from stack");
        }
	public Comparable displayfromn(int n){
		Node test = first;
		Node test1 = first;
		if(isEmpty()){return -1;}
		if(n > N) {return -1;}
		for(int i=0; i<n;i++)
			test = test.next;
		while(test.next != null){
			test = test.next;
			test1 = test1.next;
		}
		return test1.item;
	}
	public void removerepeated(){
		Node previous = first;
		Node current = previous.next;
		while(current!= null){
			Node running = first;
			while(current != running){
				if(current.item == running.item){
					previous.next = current.next;
					current = current.next;
					N--;
					break;
				}
				running = running.next;
			}
			if(running == current){
				previous = current;
				current = current.next;
			}
		}
	
	} 
	public void sort(){
                Node previous = first;
                Node current = previous.next;
                while(current!= null){
                        Node running = first;
                        System.out.println(current.item + "--" + running.item);
			while(current != running){
                                if(current.item.compareTo(running.item) <  0){
					Node temp = running;
					running = current;
					current = temp;
					running.next = current;
					//running.next = current;
					//current.next = temp;
					display();
					//previous.next = current.next;
                                        current = current.next;
                                        //N--;
                                        //break;
                                }
                                running = running.next;
                        }
                        if(running == current){
                                previous = current;
                                current = current.next;
                        }
                }

        }
	public void deleterepeated(){
		Comparable item;
		Hashtable table = new Hashtable();
		Node temp = first;
                Node previous = new Node();
		Node current = new Node();
		current = first;
		previous = null;
		int count=0;
                if(!isEmpty()){
                        //System.out.println("Content of queue are");
                        while(count < N){
                                item = current.item;
                                if(table.containsKey(item)){
			        	previous.next = current.next;
					N--;
					current = current.next;
				}
				else{
					table.put(item,true);
					previous = current;
					current = current.next;
					count++;
				}	
                        }
                }
		
	}
	public void display(){
		Node temp = first;
		Comparable item;
		int count=0;
		if(!isEmpty()){
			System.out.println("Content of queue are");
			while(count < N){
				item = temp.item;
				temp = temp.next;
				System.out.println(""+item);
				count++;
			}
		}
	}
	public Node getnode(){
		return first;
	}	
	public void add(Node n1,Node n2){
		Comparable item;
		int temp=0;
		int carry =0;
		while(n1!=null){
			temp = carry+Integer.parseInt(n1.item.toString())+Integer.parseInt(n2.item.toString());
			item = temp%10;
			carry = temp/10;
			insertlast(item);
			n1 = n1.next;
			n2 = n2.next;
		}
	}
}
public class prb1{
	public static void main(String args[]){
		/**
		singlelinkedlist sll = new singlelinkedlist();
		sll.insertlast(34);
		sll.insertlast(24);
		sll.insertlast(12);
		sll.insertlast(12);
		sll.insertlast(89);
		sll.insertlast(12);
		sll.insertlast(98);
		sll.display();
		Comparable s = sll.displayfromn(3);
                System.out.println("---"+s);

		singlelinkedlist sll1 = new singlelinkedlist();
                sll1.insertlast(3);
                sll1.insertlast(2);
                sll1.insertlast(1);
                sll1.insertlast(1);
                sll1.insertlast(8);
                sll1.insertlast(1);
                sll1.insertlast(9);

		Node n1 = new Node();
		n1 = sll1.getnode();
		
		singlelinkedlist sll2 = new singlelinkedlist();
                sll2.insertlast(7);
                sll2.insertlast(2);
                sll2.insertlast(1);
                sll2.insertlast(1);
                sll2.insertlast(8);
                sll2.insertlast(1);
                sll2.insertlast(9);
		Node n2 = new Node();
                n2 = sll2.getnode();
		
		singlelinkedlist sll3 = new singlelinkedlist();
		sll3.add(n1,n2);
		System.out.println("sum of 2 list is");
		sll3.display();
		*/
		singlelinkedlist stack = new singlelinkedlist();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		

	}
}
