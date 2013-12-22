public class problem3{
	public static void main(String[] args){
		long num=600851475143L;
		long index;
		long prevnum ;
		while(true){
			prevnum=num;
			String ret = redNum(num, num);
			String retsplit[];
			retsplit=ret.split("@");
			num=Long.parseLong(retsplit[0]);
			index=Long.parseLong(retsplit[1]);
			if(prevnum==num)break;
		}
		System.out.println(index);
	}

public static String redNum(long num, long limit){
	long index;
	for(index=2;index<limit;index++){
		if(num%index==0){
			num=num/index;
			break;
		}
	}
	return "" + num +"@" + index+"";
}
}