import java.util.*;
class arraylistsome{
	public static void main(String args[]){
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		Scanner scanner = new Scanner( System.in );
		while(true){
			System.out.println("Enter no 0 r 1");
			int no = Integer.parseInt(scanner.nextLine());
			if(arrlist.size() == 0) arrlist.add(no);
			else{
				arrlist.add(no);
				
			}
			for(int i=0;i < arrlist.size();i++) System.out.print(arrlist.get(i)+" ");
			System.out.println("");
		}
	}
}
