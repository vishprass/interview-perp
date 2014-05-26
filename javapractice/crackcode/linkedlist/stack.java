import java.util.*;
import java.util.Hashtable;
class Node{
        Node prev;
        Node next;
        Comparable item;
}
class Stack{
        private Node first;
        private Node last;
        int N;
	int Capacity = 5;
        public boolean isEmpty(){ return first == null;}
	public void push(Comparable item){
                Node firstnew = new Node();
                firstnew.item = item;
                if(isEmpty()){last = first;}
                else{firstnew.next = first;}
                first = firstnew;
                N++;
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
	public Comparable popstack(){
                Comparable item = 0;
                if(!isEmpty()){
                        item = first.item;
                        first = first.next;
                        N--;
                }
               // System.out.println(item + " Removed from stack");
		return item;
        }
	public void sort(){
		Comparable[] stk = new Comparable[N];
		int n=N;
		for(int i=0;i<n;i++){
			Comparable item = popstack();
			stk[i]=item;
			for(int j=0; j<i; j++){
				if(stk[j].compareTo(stk[i]) < 0){
					Comparable temp = stk[j];
					stk[j] = stk[i];
					stk[i] = temp;
				}
			}
		}
		for(int i=0;i<n;i++)
			push(stk[i]);
	}
		
	public void display(){
                Node temp = first;
                Comparable item;
                int count=0;
                if(!isEmpty()){
                        while(count < N){
                                item = temp.item;
                                temp = temp.next;
                                System.out.println(""+item);
                                count++;
                        }
                }
       }
       public boolean isatCapacity(){
		if(N == Capacity) return true;
		else return false;
	}
}

class stackdouble{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public void push(Comparable item){
		Stack last = getlaststack();
		if(last != null && !last.isatCapacity()){
			last.push(item);
		}else{
			Stack newstack = new Stack();
			newstack.push(item);
			stacks.add(newstack);
		}
	}
	public void pop(){
		Stack last = getlaststack();
		last.pop();
		if(last.N == 0){stacks.remove(stacks.size()-1);}
	}
	public Stack getlaststack(){
		if(stacks.size() == 0) return null;
		else return (stacks.get(stacks.size()-1));
	}
	public void display(){
		int arrsize = stacks.size();
		int i=0;
		while(i<arrsize){
			Stack last = stacks.get(i);
			System.out.println("Content of "+(i+1)+" Stack is");
			last.display();
			i++;
		}
	}
}		
class stack{
	public static void main(String args[]){
		/*stackdouble sd = new stackdouble();
		sd.push(1);
		sd.push(2);
		sd.push(3);
		sd.push(4);
		sd.push(5);
		sd.push(6);
		sd.push(7);
		sd.push(8);
		sd.push(9);
		sd.push(10);
		sd.push(11);
		sd.push(12);
		sd.push(13);
		sd.push(14);
		sd.push(15);
		sd.display();
		sd.pop();
		sd.pop();
		sd.pop();
		sd.pop();
		sd.pop();
		sd.push(16);
		sd.display();*/
		Stack s1 = new Stack();
		s1.push(21);
		s1.push(31);
		s1.push(9);
		s1.push(3);
		s1.push(89);
		s1.push(15);
		s1.sort();
		s1.display();
	}
}
