import java.util.*;

public class stackinbuilt {

   public static void main(String args[]) {
      Stack st = new Stack();
      st.push(20);
      st.push(30);
      st.push(40);
      System.out.println(st);
      st.pop();
      st.pop();
      System.out.println(st);
      Stack<String> collection = new Stack<String>();
      collection.push("COMMON MAN");
	collection.push("VIP");
	collection.push("VVIP");
	 System.out.println(collection);
      collection.pop();
      collection.pop();
      System.out.println(collection);
	for (String s : collection)
System.out.println(s);
   }
}
