import java.util.*;
class Treenode{
	Comparable item;
	Treenode left;
	Treenode right;
	
}
class Treeoperations{
	private Treenode Root;
	public void insert(Comparable item){
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
			if(item.compareTo(temp.item) < 0){
				if(temp.left == null){
					Treenode left = new Treenode();
					left.item = item;
					temp.left = left;
					System.out.println("Inserted at left");
					return;
				}
				temp = temp.left;
			}
			else if(item.compareTo(temp.item) > 0){
				if(temp.right == null){
					Treenode right = new Treenode();
					right.item = item;
					temp.right = right;
					System.out.println("Inserted at right");
					return;
				}
				temp = temp.right;
			}
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
                        displayinorder(TempRoot.left);
                        displayinorder(TempRoot.right);
			System.out.println(TempRoot.item+"");
                }
        }
	public void displaypreorder(Treenode TempRoot){
                if(TempRoot != null){
                        System.out.println(TempRoot.item+"");
                        displayinorder(TempRoot.left);
                        displayinorder(TempRoot.right);
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
	public void search(Comparable a){
		Treenode temproot = new Treenode();
		temproot = Root;
		if(isEmpty()){System.out.println("Tree is empty");return;}
		if(a.compareTo(temproot.item)== 0){System.out.println("Found at Root"); return;}
		while(temproot != null){
			if(a.compareTo(temproot.item) < 0){
				if(temproot.left == null){System.out.println("Not Found");return;}
				temproot = temproot.left;
				if(temproot.item.compareTo(a) == 0){System.out.println("found at left of parent");return;}
			}else if(a.compareTo(temproot.item) > 0){
				if(temproot.right == null){System.out.println("Not Found");return;}
                                temproot = temproot.right;
				if(temproot.item.compareTo(a) == 0){System.out.println("found at left of parent");return;}
                        }
		}
	}	
}
public class Tree{
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
	}
}
