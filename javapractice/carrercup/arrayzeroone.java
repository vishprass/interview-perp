public class arrayzeroone{
	public static void main(String[] args){
		int[] arr = new int[]{0,0,1,0,1,1,1,0,0,1,0,0,1,1,0,0,1};
		int zero = 0;
		int one = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == 0) zero++;
			if(arr[i] == 1) one++;
		}
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		zero --; one = one-2;
		int flag =0; int preloop =1;int loop =2;int newloop = 0;int prevcount=3;
		while(zero > 0 || one >  0){
			newloop =(int) ((Math.pow(loop,2))-(Math.pow(preloop,2)));
			preloop = loop;
			loop = newloop;
			if(flag == 0 && zero > 0){
				int newcount = newloop;
				for(int i=prevcount;((newcount > 0) && zero >0  && i< arr.length);i++){
					arr[i] = 0;
					zero--;
					newcount--;
				}if(newcount != 0 && zero == 0) loop -= newcount+1;
				flag = 1;
			}
			else if(flag == 1 && one > 1){
                                int newcount = newloop;
				for(int i=prevcount;((newcount>0 && one>0) && i< arr.length);i++){
                                      	arr[i] = 1;
					one--;
					newcount--;
                                }if(newcount != 0 && one == 0) loop -= newcount+1;
				flag = 0;
                        }
			prevcount += loop;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+"");
		}
	}
}

