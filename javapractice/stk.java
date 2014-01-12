package stack;
import java.util.Scanner;
public class stk{

        //private variables
        private int staks[] = new int[10];
        private int top;

        //Constructor   
        public stk(){
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
	public static void main(String args[]){
	}
}

