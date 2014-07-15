import java.util.*;
import java.lang.*;
class longestseq{
	public static void main(String[]  args){
		int[] seq = {-2,1,-3,4,-1,2,1,-5,4};
		int[] sum = new int[seq.length];
		sum[0] = seq[0];
		for(int i=1;i<seq.length;i++){
			sum[i]=Math.max(sum[i-1]+seq[i],seq[i]);
		}
		List<Integer> sumlist = new ArrayList<Integer>();
		for(int i=0; i<sum.length;i++)
			sumlist.add(sum[i]);
		System.out.println(Collections.max(sumlist));
	}
}
