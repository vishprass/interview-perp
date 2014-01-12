package stack;
import java.util.Scanner;
class Stack{
	
	//private variables
	private int staks[] = new int[10];
	private int top;
	
	//Constructor	
	public Stack(){
		top = -1;
	}
	
	//Push the new element into stack
	public void push(int item){
		if(top == 9) System.out.println("Stack is full");
		else{
			staks[++top] = item;
			System.out.println(item+" pushed into stack");
		}
	}
	
	//Display the elements of stack
	public void display(){
                if(top == -1) System.out.println("Stack is empty");
                else{
                        System.out.println("Content of stack is");
                        for(int i=top; i>=0;i--)
				System.out.println(staks[i]);
                }
        }
	
	//Pop the last element of stack
	public void pop(){
		if(top == -1) System.out.println("Stack is empty");
		else System.out.println(staks[top--]+" poped out of Stack");
	}
}

public class prg3{
        
	//For reading inputs
	private static Scanner scanner = new Scanner( System.in );
	
	public static void main(String args[]){
                //Variables
		Stack stack1 = new Stack();
                int cont = 1;
		
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. View your Stack");
		System.out.println("4. Exit");
		
		while(cont == 1){
			System.out.println("What operation you want to do");		
			int choice = Integer.parseInt(scanner.nextLine());
			switch(choice){
				case 1: System.out.println("Enter the element you need to push");
					int element = Integer.parseInt(scanner.nextLine());
					stack1.push(element);
					break;
				case 2: stack1.pop(); break;
				case 3: stack1.display(); break;
				case 4: cont = 0; break;
				default: break;
			}
		}			
        }
}

