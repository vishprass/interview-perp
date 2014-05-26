class someshit{
	public static void main(String args[]){
		int games = 5623;
		int count = 0;
		while(true){
			if(games == 1) break;
			if(games%2 == 0){ games = games/2; count+=games;}
			else {games-=1; count+=games;}
		}
		System.out.println(count+" no of games");
	}
}
