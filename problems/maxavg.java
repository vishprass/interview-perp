import java.util.*;
class maxavg{
	public static void main(String[] args){
		ArrayList arr = new ArrayList();
		boolean loop = true;
		while(loop){
			System.out.println("Enter the no");
			Scanner sc = new Scanner(System.in);
    			int num = sc.nextInt();
			if(num == 0){ loop = false; break;}
			arr.add(num);
		}
		Collections.sort(arr);
		int sum =0;
		double avg=0.0;
		for(int i=0; i<arr.size()-3;i++)
			sum+=(int)arr.get(i);
		avg = (double)sum/((double)arr.size()-3);
		System.out.println(""+avg);
	}
}
