class Hashentry{
	private String Name;
	private String pno;
	Hashentry(String Name, String pno){
		this.Name = Name;
		this.pno = pno;
	}
	public String getkey(){
		return Name;
	}
	public String getvalue(){
		return pno;
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
}
public class hashtable{
	public static void main(String args[]){
		HashMap hm = new HashMap();
		hm.put("vishnu","4802471805");
		hm.put("test","1234567890");
		String pno = hm.get("vishnu");
		System.out.println("vishnu no is "+ pno);
		pno = hm.get("test");
                System.out.println("test no is "+ pno);
	}
}
