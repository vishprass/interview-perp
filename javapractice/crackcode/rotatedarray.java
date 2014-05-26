class rotatedarray{
	public static void main(String arfs[]){
		int[] a = new int[] {16,17,39,58,1,2,3,4,5,6,7,8,11,13,14,15};
		int low = 0;
		int high = a.length-1;
		int search = 1;
		int mid;
		while(low <= high){
			mid = (low+high)/2;
			System.out.println(""+low+"--"+"--"+mid+"--"+high);
			if(a[mid] == search){System.out.println("Elmenet found at "+ (mid+1)+" position"); break;}
			else if(search > a[mid] && search <= a[high]){low = mid+1;}
			else if(search > a[mid] && search > a[high]){high = mid-1;}
			else if(search < a[mid] && a[high] >= a[mid] ){high = mid-1;}
			else if(search < a[mid] && a[high] < a[mid] ){low = mid+1;}
		}
		int highest = functionhighestinarray(a);
		System.out.println(highest+"");
	}
	public static int functionhighestinarray(int[] a){
		int low = 0;
                int high = a.length-1;
                int search = 1;
		int mid = 0;
		while(low  <= high){
		mid = (low+high)/2;
		if(a[high] > a[low]) return a[high];
		else if(a[mid]>a[mid+1] && a[mid] > a[mid-1]) return a[mid];
		else if(a[mid+1]>a[mid] && a[mid] > a[low]) low = mid+1;
		else high = mid-1; 
		}
		return a[mid];
		//if(a[mid] > a[mid+1]) {return a[mid];}
		//else return a[mid+1];
	}

}
