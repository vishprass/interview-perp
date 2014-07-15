class boyermoore{
	private int[] right;
	private String pat;
	public boyermoore(String pat){
		this.pat = pat;
		right = new int[256];
		for(int i=0;i<256;i++)
			right[i] =-1;
		for(int j=0;j<pat.length();j++)
			right[pat.charAt(j)] = j;
	}
	public int search(String txt){
		int N=txt.length();
		int M = pat.length();
		int skip;
		for(int i=0;i<N-M;i+=skip){
			skip = 0;
		for(int j=M-1;j >=0; j--){
			if(pat.charAt(j) != txt.charAt(j)){
				skip = j-right[txt.charAt(i+j)];
				if(skip < 0) skip =1; break;
			}
		}
		if(skip ==0) return i;
		}
	return N;
	}
}
public class bayermooresort{
	public static void main(String args[]){
		String txt = "vishnu prasad sattigeri";
		String pat = "rasa";
		boyermoore bm = new boyermoore(pat);
		int pos = bm.search(txt);
		if(pos < txt.length())
			System.out.println("Found at position"+ pos);
		else
			System.out.println("String not dound");
	}
}
