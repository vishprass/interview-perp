import java.util.*;

public class queueinbuilt {

   public static void main(String args[]) {
     // Queue q = new Queue();
      Queue<Integer> q = new LinkedList<Integer>();
	q.enqueue(20);
      q.enqueue(30);
      q.enqueue(40);
      System.out.println(q);
      q.dequeue();
      q.dequeue();
      System.out.println(st);
      Queue<String> collection = new LinkedList<String>();
      collection.enqueue("COMMON MAN");
        collection.enqueue("VIP");
        collection.enqueue("VVIP");
         System.out.println(collection);
      collection.enqueue();
      collection.enqueue();
      System.out.println(collection);
        for (String s : collection)
System.out.println(s);
   }
}

