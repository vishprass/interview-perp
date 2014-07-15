import java.util.*;
class Treenode{
	int item;
	Treenode left;
	Treenode right;
	Treenode parent;
}
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
                //System.out.println(item + " Added to queue");
        }
	public void display(){
                Link Current = new Link();
                Current = first;
                int count=0;
	while(count < 	N){
		System.out.println(Current.item+ "");
		Current = Current.next;
		count++;
	}

}
}


class Treeoperations{
private Treenode Root;
Stack<Integer> stk = new Stack<Integer>();
//ArrayList<Integer> stk = new ArrayList<Integer>();
int localcount=0;
int level = 0;
int j=0;
public void getsiblings(Treenode TempRoot){
	if(TempRoot != null){
		getsiblings(TempRoot.left);
		getsiblings(TempRoot.right);
		stk.push(TempRoot.item);
	}
}
public void depthlevel(){
	Treenode n = new Treenode();
	n = Root;
	ArrayList<LinkedList<Treenode>> result = new ArrayList<LinkedList<Treenode>>();
	LinkedList<Treenode> list = new LinkedList<Treenode>(); 
	list.add(n);
	result.add(list);
	int level =0;
	while(true){
		list = new LinkedList<Treenode>();
		for(int i=0;i<result.get(level).size();i++){
			Treenode n1 = (Treenode) result.get(level).get(i);
			if(n1!=null){
				if(n1.left!=null)list.add(n1.left);
				if(n1.right!=null)list.add(n1.right);
			}
		}
		if(list.size()<=0){break;}
		else{result.add(level+1,list);level++;}
	}
	for(int i=0;i<result.size();i++){
		list = new LinkedList<Treenode>();
		System.out.println("The content of "+ (i+1) + " linked list is");
		for(int j=0;j<result.get(i).size();j++){
			Treenode n1 = (Treenode) result.get(i).get(j);
			System.out.println(""+n1.item);
		}
	}

}
public void rightmostsibling(int search){
	Treenode n = new Treenode();
	n = Root;
	ArrayList<LinkedList<Treenode>> result = new ArrayList<LinkedList<Treenode>>();
	LinkedList<Treenode> list = new LinkedList<Treenode>();
	if(n.item == search){System.out.println("The node is root node no siblings for it");return;}
	list.add(n);
	result.add(list);
	int level=0;
	int flag =0;
	while(true){
		list = new LinkedList<Treenode>();
		for(int i=0;i<result.get(level).size();i++){
			Treenode n1 = (Treenode) result.get(level).get(i);
			if(n1.item == search){flag =1; break;}
			if(n!= null){
				if(n1.left !=null)list.add(n1.left);
				if(n1.right!=null)list.add(n1.right);
			}
		}
		if(list.size() <= 0)break;
		else{result.add(level+1,list);level++;}
	}
		if(flag == 1){
			int a = result.size();
			int b = result.get(a-1).size();
			Treenode n1 = (Treenode) result.get(a-1).get(b-1);
			System.out.println("The rightmost node is");
			System.out.println(""+n1.item);
		}else{
			System.out.println("node not found");
		}
	}

public void insert(int item){
	if(Root == null){
		Treenode Roottemp = new Treenode();
		Roottemp.item = item;
		Root = Roottemp;
		System.out.println("Inserted at root");
		return;
	}
	Treenode temp;
	temp = Root;
	while(true){
		if(item < temp.item){
			if(temp.left == null){
				Treenode left = new Treenode();
				left.item = item;
				temp.left = left;
				left.parent = temp;
				System.out.println("Inserted at left");
				return;
			}
			temp = temp.left;
		}
		else if(item > temp.item){
			if(temp.right == null){
				Treenode right = new Treenode();
				right.item = item;
				temp.right = right;
				right.parent = temp;
				System.out.println("Inserted at right");
				return;
			}
			temp = temp.right;
		}
	}
}
public void create_linked_list(){
	Treenode newnode = new Treenode();
	Treenode newnode1 = new Treenode();
	newnode = Root;
	int rootitem = newnode.item;
	singlelinkedlist<Integer> sll1 = new singlelinkedlist<Integer>();
	sll1.enqueue(rootitem);
	System.out.println("The root level linked list is");
	sll1.display(); 
	level = 2;
	while(newnode.left != null){
		newnode = newnode.left;
		newnode1 = Root;
		getsiblings(newnode1);
		Stack<Integer> stk1 = new Stack<Integer>();
		while(!stk.empty())
			stk1.push(stk.pop());
		singlelinkedlist<Integer> sll2 = new singlelinkedlist<Integer>();
		while(true){
			if(localcount < 2 && j < level){
					sll2.enqueue(stk1.pop());
					localcount++;
					j++;
				}
				if(localcount >= 2) { stk1.pop();localcount =0;}
				if(j >= level) break;
		}
			System.out.println("The "+ localcount+"  level linked list is");
                	sll2.display();
			level =	(int)Math.pow(2,level);
			j=0;
			//stk.clear();
			localcount=0;
		}

	}

			
			
	public void displayinorder(Treenode TempRoot){
		if(TempRoot != null){
			displayinorder(TempRoot.left);
			System.out.println(TempRoot.item+"");
			displayinorder(TempRoot.right);
		}
	}
	public void displaypostorder(Treenode TempRoot){
                if(TempRoot != null){
                        displaypostorder(TempRoot.left);
                        displaypostorder(TempRoot.right);
			System.out.println(TempRoot.item+"");
                }
        }
	public void displaypreorder(Treenode TempRoot){
                if(TempRoot != null){
                        System.out.println(TempRoot.item+"");
                        displaypreorder(TempRoot.left);
                        displaypreorder(TempRoot.right);
                }
        }

	public void display(){
		if(isEmpty()){System.out.println("Tree is empty");return;}
		System.out.println("Inorder dispaly");
		displayinorder(Root);
		System.out.println("Post order display");
		displaypostorder(Root);
		System.out.println("Pre order display");
		displaypreorder(Root);

	}
	public boolean isEmpty(){return Root == null;}
	public void search(int a){
		Treenode temproot = new Treenode();
		temproot = Root;
		if(isEmpty()){System.out.println("Tree is empty");return;}
		if(a == temproot.item){System.out.println("Found at Root"); return;}
		while(temproot != null){
			if(a < temproot.item){
				if(temproot.left == null){System.out.println("Not Found");return;}
				temproot = temproot.left;
				if(temproot.item == a){System.out.println("found at left of parent");return;}
			}else if(a > temproot.item){
				if(temproot.right == null){System.out.println("Not Found");return;}
                                temproot = temproot.right;
				if(temproot.item == a){System.out.println("found at left of parent");return;}
                        }
		}
	}
		
}
public class ip1{
	public static void main(String args[]){
		Treeoperations tr = new Treeoperations();
		Scanner scanner = new Scanner( System.in );
		boolean flag = true;
		while(flag){
			System.out.println("What do you want to do");
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Exit");
			int  input = Integer.parseInt(scanner.nextLine());
			switch(input){
				case 1: System.out.println("What do you want to insert");
					int input1 = Integer.parseInt(scanner.nextLine());
					tr.insert(input1);
					break;
				case 2: tr.display();break;
				case 3: System.out.println("What do you want to search");
                                        int input2 = Integer.parseInt(scanner.nextLine());
                                        tr.search(input2);
                                        break;
				case 4: flag = false;break;
				default: break;
			}
		}
		tr.depthlevel();
		tr.rightmostsibling(10);
	}
}
