import java.util.*;
class charseq{
	public static void main(String[] args){
		String input ="AbcDefljdflsjflmnopflsjflasjftuvWxYz";
		input = input.toLowerCase();
		ArrayList arr = new ArrayList();
		for(int i=0;i<input.length();i++){
			arr.add(input.charAt(i));
		}
		Collections.sort(arr);
		char prev = (char)arr.get(0);
		char newchar ='-';
		String str =""+prev;
		String prevstr ="";
		for(int i=1;i<arr.size();i++){
			newchar=(char)arr.get(i);
			if(prev == newchar) continue;
			if(prev+1 == newchar){
				str += newchar;
			}
			else{
				if(prevstr != str){
					str = str+";";
					prevstr = str;
				}
			}
			prev = newchar;
		}
		System.out.println(str);
	}
}	
