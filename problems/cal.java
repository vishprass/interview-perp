class cal{
	public static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static String[] weekday ={"sunday","monday","teusday","wednesday","thursday","friday","saturday"};
	public static void main(String[] args){
		cal cl = new cal();
		cl.getdate(1,1,2014,4);
	}
	public void getdate(int date,int month,int year,int day){
		 for(int i=day;i>0;i--){
			if(date == 1){
				if(month == 1){
                                	month=12;
                                	year--;
                        	}else
                                	month--;
				date = getnewdate(month,year);
			}
			else 
				date--;
		}
		for(int i=0;i<7;i++){
			System.out.println(weekday[i]+" "+date+"-"+month+"-"+year);
			if(date != days[month-1]) date++;
			else{ 
				date = 1;
				month++;
			}
			if(month >12){
				month =1;
				year++;
			}
		}
	}
	public int getnewdate(int month,int year){
		if(year%4 == 0)days[1]=29;
		return days[month-1];
	}
}
