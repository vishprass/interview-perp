import java.util.*;
class Hashentry{
	private String prod;
	private String prodname;
	Hashentry(String prod, String prodname){
		this.prod = prod;
		this.prodname = prodname;
	}
	public String getkey(){
		return prod;
	}
	public String getvalue(){
		return prodname;
	}
}
class HashMap{
	private final static int tablesize = 127;
 	Hashentry[] table;
	HashMap(){
		table = new Hashentry[tablesize];
		for(int i=0;i<tablesize;i++)
			table[i] = null;
	}
	public String get(String key){
		int sum=0;
		String[] ary = key.split("");
		for(int i=1; i< key.length();i++)
			sum+=key.charAt(i);
		int hash = (sum % tablesize);
		while(table[hash]!= null &&  !(table[hash].getkey().equals(key)))
			hash = (hash+1)%tablesize;
		if(table[hash] == null) return "Not Found";
		else return table[hash].getvalue();
	}
	public void put(String key, String pno){
		int sum = 0;
		String[] ary = key.split("");
		for(int i=1; i<key.length();i++)
                        sum+=key.charAt(i);
                int hash = (sum % tablesize);
                while(table[hash]!= null &&  !(table[hash].getkey().equals(key)))
                        hash = (hash+1)%tablesize;
		table[hash] = new Hashentry(key,pno);
	}
	public void print(){
		ArrayList list = new ArrayList();
		
		for(int i=0;i<tablesize;i++)
                       if(table[i] != null){
				list.add(""+table[i].getkey());
			}
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
}
public class hashtable1{
	public static void main(String args[]){
		HashMap hm = new HashMap();
		ArrayList list1 = new ArrayList();
		list1.add("apple");
		list1.add("tissues");
		list1.add("onions");
		list1.add("milk");
		list1.add("carrots");	
		ArrayList list2 = new ArrayList();
		list2.add("apple");
		list2.add("trash bags");
		list2.add("veg oil");
		list2.add("milk");	
		list2.add("chicken");
		for(int i=0;i<list1.size();i++)
			hm.put(""+list1.get(i),""+list1.get(i));
		for(int i=0;i<list1.size();i++)
                        hm.put(""+list2.get(i),""+list2.get(i));
		hm.print();
	}
}
