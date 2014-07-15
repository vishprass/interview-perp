class anagramall{
	public static void main(String[] args){
		anagramall ana = new anagramall();
		String str = new String();
		str ="gum";
		ana.anagram(str,"");
	}
	public void anagram(String str1,String str2){
		if(str1.length() ==0)
			System.out.println(str2);
		for(int i=0;i<str1.length();i++){		
			anagram(str1.substring(0,i)+str1.substring(i+1,str1.length()),str1.charAt(i)+str2);
		}
	}
} 
