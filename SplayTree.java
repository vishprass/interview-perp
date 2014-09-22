//Implementation of splay tree inserting, deleting, searching, and other operation
//Implemented for network domain
//Implemented insert,find,splay,delete
//Delete has been modified to delete the node which is least accessed as we are implementing network domain least accessed router has to be deleted when stack is full
import java.util.*;
class SplayTreeImplementation<Key extends Comparable<Key>, Value>  {
	//Root node of tree
	private Node Root;
	
	//Creating the tree
   	private class Node {
        	private Key dip;         // destination ip
        	private Value dist;  // hop count from source to destination
		private int acessCount; //number of time router has been accessed
        	private Node Left, Right;   // Left and Right subtrees

        	public Node(Key dip, Value dist, int acessCount) {
            		this.dip = dip;
            		this.dist = dist;
			this.acessCount = acessCount;
		}

    	}
	
	//To check if node contating destination ip is already there
	public boolean contains(Key dip) {
        	return (get(dip) != null);
    	}

    	// return distance associated with the given ip
    	// if no such value, return null
    	public Key get(Key dip) {
        	Root = splay(Root, dip);
        	int cmp = dip.compareTo(Root.dip);
        	if (cmp == 0) return Root.dip;
        	else          return null;
    	}
	
	//If element to be searched is found splay it to root increase acess count by 1
	public Key find(Key dip) {
		if (Root == null) return null;
		Root = splay(Root,dip);
		if(Root.dip.compareTo(dip) != 0) return null;
        	Root.acessCount++;
		return Root.dip;
    	}

	//Insert new node
	public void InsertNode(Key dip, Value dist, int acessCount) {
        	// splay dip to root if its first node
        	if (Root == null) {
            		Root = new Node(dip,dist,acessCount);
            		return;
        	}
        	//splay the tree
       	 	Root = splay(Root, dip);

        	int cmp = dip.compareTo(Root.dip);
        
       	 	// Insert new node at root
        	if (cmp < 0) {
            		Node N = new Node(dip,dist,acessCount);
            		N.Left = Root.Left;
            		N.Right = Root;
            		Root.Left = null;
            		Root = N;
        	}

        	// Insert new node at root
        	else if (cmp > 0) {
            		Node N = new Node(dip,dist,acessCount);
            		N.Right = Root.Right;
            		N.Left = Root;
            		Root.Right = null;
            		Root = N;
        	}

        	// It was a duplicate key. Simply replace the value
        	else if (cmp == 0) {
            		Root.dist = dist;
        	}

    	}	
	
	//Function to splay the tree
	private Node splay(Node H, Key dip) {
        	//Check if root is null
		if (H == null) return null;
        	int cmp1 = dip.compareTo(H.dip);

        	if (cmp1 < 0) {
            		// key not in tree, so we're done
            		if (H.Left == null) {
                		return H;
            		}
            		int cmp2 = dip.compareTo(H.Left.dip);
            		//Zig zig operation
			if (cmp2 < 0) {
                		H.Left.Left = splay(H.Left.Left, dip);
                		H = rotateRight(H);
            		}
			//zig zag operation
            		else if (cmp2 > 0) {
                		H.Left.Right = splay(H.Left.Right, dip);
                		if (H.Left.Right != null)
                    		H.Left = rotateLeft(H.Left);
            		}
            
            		if (H.Left == null) return H;
            		else                return rotateRight(H);
        	}

        	else if (cmp1 > 0) { 
            		// key not in tree, so we're done
            		if (H.Right == null) {
                		return H;
            		}

            		int cmp2 = dip.compareTo(H.Right.dip);
            		if (cmp2 < 0) {
                		H.Right.Left  = splay(H.Right.Left, dip);
                		if (H.Right.Left != null)
                    		H.Right = rotateRight(H.Right);
            		}	
            		else if (cmp2 > 0) {
                		H.Right.Right = splay(H.Right.Right,dip);
                		H = rotateLeft(H);
            		}
            
            		if (H.Right == null) return H;
            		else                 return rotateLeft(H);
        	}

        	else return H;
    	}
	//Delete least accessed node
	public void deleteNode(){
		Node n= GetLeastAccessNode();
		if(n!=null) {
			remove(n.dip);
			System.out.println(n.dip+" is removed as it was least accessed("+n.acessCount+" times) and far away node");
		}
	}
	//Get the least accessed node
	public Node GetLeastAccessNode(){
		Node n;
		n = Root;
		//Storing the root node in an lined list and in an arraylist
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		//use inbuilt linked list implementation
		LinkedList<Node> list = new LinkedList<Node>(); 
		list.add(n);
		result.add(list);
		int level =0;
		//storing roots Left and Right child in an lined list similarly again each of its Left Right child in seperate list and add it to array list
		while(true){
			list = new LinkedList<Node>();
			//store left and right child in a linked list
			for(int i=0;i<result.get(level).size();i++){
				Node n1 = (Node) result.get(level).get(i);
				if(n1!=null){
					if(n1.Left!=null)list.add(n1.Left);
					if(n1.Right!=null)list.add(n1.Right);
				}
			}
			if(list.size()<=0){break;}
			//add list in arraylist
			else{result.add(level+1,list);level++;}
		}	
		Node tempnode = null;
		//Acess each list and than node and comapre each of the acesscount and return least accesscount and which is at bottom
		for(int i=0;i<result.size();i++){
			list = new LinkedList<Node>();
			for(int j=0;j<result.get(i).size();j++){
				//get the node from linked list strored in an array list
				Node n1 = (Node) result.get(i).get(j);
				if(n1.acessCount<= 0) tempnode = n1;
			}
		}
		return tempnode;
	}

	//Remove the given node
	public void remove(Key dip) {
        	if (Root == null) return; // empty tree
        	Root = splay(Root, dip);
		int cmp = dip.compareTo(Root.dip);
        	//If root is not having any left chld make right child as Root
		if (cmp == 0) {
            		if (Root.Left == null) {
                	Root = Root.Right;
            		} 
			//Make the Left child as root and again spaly the tree ie perform zig zig or zig zag
            		else {
                		Node x = Root.Right;
                		Root = Root.Left;
                		splay(Root,dip);
                		Root.Right = x;
            		}
        	}

    	}
	
 	//Get height of tree
	public int height() { return height(Root); }
    	private int height(Node x) {
        	if (x == null) return -1;
		//Will go into each node Left and Right till reach leaf and maximum of Left tree child height or Right tree child height will be height
        	return 1 + Math.max(height(x.Left), height(x.Right));
    	}

    
    	public int size() {
        	return size(Root);
    	}
    
    	private int size(Node x) {
        	if (x == null) return 0;
        	else return (1 + size(x.Left) + size(x.Right));
    	}	
    
    	// Right rotate
    	private Node rotateRight(Node H) {
        	Node X = H.Left;
        	H.Left = X.Right;
        	X.Right = H;
        	return X;
    	}

    	// Left rotate
    	private Node rotateLeft(Node H) {
        	Node X = H.Right;
        	H.Right = X.Left;
        	X.Left = H;
        	return X;
    	}
	
	//Dispaly the tree
	public void display(){
		displaypreorder(Root);
	}
	//Display tree in preorder Root and its child
	public void displaypreorder(Node TempRoot){
                if(TempRoot != null){
                        System.out.println(TempRoot.dip+"->"+TempRoot.dist);
                        displaypreorder(TempRoot.Left);
                        displaypreorder(TempRoot.Right);
                }
        }
		    
}

//Main Function Implementation
public class SplayTree{
	public static void main(String[] args) {
		SplayTreeImplementation<String,Integer> st1 = new SplayTreeImplementation<String,Integer>();
		st1.InsertNode("110011",1,0);
		st1.InsertNode("110111",2,0);
		st1.InsertNode("100000",3,0);
		st1.InsertNode("111011",4,0);
		st1.InsertNode("111111",5,0);
		st1.InsertNode("101011",6,0);
		st1.InsertNode("100011",7,0);
		st1.display();
		System.out.println("------------");
		System.out.println(st1.find("110011")+" was found and moved to root");
		st1.display();
		System.out.println(st1.find("111011")+" was found and moved to root");
		System.out.println(st1.find("110111")+" was found and moved to root");
		System.out.println(st1.find("111111")+" was found and moved to root");
		System.out.println(st1.find("101011")+" was found and moved to root");
		System.out.println(st1.find("100011")+" was found and moved to root");
		System.out.println("------------");
		st1.deleteNode();
		System.out.println("------------");
		st1.display();
		
	}
}
