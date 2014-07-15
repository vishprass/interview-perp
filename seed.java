import java.util.*;
class seed{
	public static void main(String[] args){
		int num=1716;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=2;i<=(num/2);i++)
			if(num%i == 0)
				arr.add(i);
		for(int tempnum:arr){
			int temp1=tempnum;
			int temp=temp1;
			while(tempnum>0){
				temp *= tempnum%10;
				tempnum = tempnum/10;
			}
			if(temp == num)
				System.out.println(temp1+"");
		}
	}
}
