import java.util.Random;
class Sortessentials{
	protected long starttime;
	protected long endtime;
	public boolean Comparetwo(Comparable a,Comparable b){
		return a.compareTo(b) > 0;
	}
	public 	Comparable[] exhg(Comparable a[], int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
	public void printarray(Comparable a[]){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	public void isSorted(Comparable a[]){
		int flag = 0;
		for(int i=0;i<a.length-1;i++)
			if(Comparetwo(a[i],a[i+1])) flag = 1;
		if(flag == 0){System.out.println("Array is sorted");}
		else {System.out.println("Array is not sorted");}
	}
	public void Timetaken(long starttime, long endtime){
		long timetaken = (endtime-starttime);
		System.out.println("Time taken to Sort is "+ timetaken +" Nano sec");		
	}
	public void printmessage(Comparable a[],long starttime, long endtime,String sorttype){
	 	System.out.println("------------------------------------------------");
		System.out.println(sorttype);
		System.out.println("");
		System.out.println("Sorted list is");
                System.out.println("");
                printarray(a);
                System.out.println("");
                isSorted(a);
                System.out.println("");
                Timetaken(starttime,endtime);
		System.out.println("------------------------------------------------");
		System.out.println("");
	}
}
class SelectionSort{
	public void  Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
		sess.starttime = System.nanoTime();
		for(int i = 0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(sess.Comparetwo(a[i],a[j])){
					a = sess.exhg(a,i,j);
				}
			}	
		}
		sess.endtime = System.nanoTime();
		sess.printmessage(a,sess.starttime,sess.endtime,"Selection Sort");
	}
}
class InsertionSort{
	public void Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
		sess.starttime = System.nanoTime();
		for(int i=1;i<a.length;i++)
			for(int j=i;j>0 && sess.Comparetwo(a[j-1],a[j]);j--)
				a=sess.exhg(a,j-1,j);
		sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Insertion Sort");
	}
}	
class ShellSort{
	public void Sort(Comparable[] a){
		int N = a.length;
		Sortessentials sess = new Sortessentials();
		sess.starttime = System.nanoTime();
		int h = 1;
		while(h <= N) h = (h*3)+1;
		while(h >= 1){
			for(int i = h;i < N;i++)
				for(int j = i;j >= h && sess.Comparetwo(a[j-h],a[j]);j -= h)
					sess.exhg(a,j-h,j);
			h = h/3;
		}
		sess.endtime = System.nanoTime();
		sess.printmessage(a,sess.starttime,sess.endtime,"Shell Sort");
	}
}
class MergeSort{
	public void Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
		sess.starttime = System.nanoTime();
		int low=0;
		int i = low;
		int high = a.length;
		int mid = (low+high)/2;
		int j= mid+1;
		Comparable[] b;
		b=a;
		for(int k = low; k < high; k++)
			b[k] = a[k];
		for(int k = low; k < high; k++){
			if(i > mid){a[k] = b[j++];}
			else if(j > high){a[k] = b[i++];}
			else if(sess.Comparetwo(b[i],b[j])){a[k] = b[j++];}
			else a[k] = b[i++];
		}
		sess.endtime = System.nanoTime();
		sess.printmessage(a,sess.starttime,sess.endtime,"Merge Sort");
        }
}
class TopDownMergeSort{
        public void Merge(Comparable[] a, int low, int mid, int high){
                Sortessentials sess = new Sortessentials();
		int i = low;
                int j = mid+1;
                Comparable[] b;
                b=a;
                for(int k = low; k <= high; k++)
                        b[k] = a[k];
                for(int k = low; k <= high; k++){
                        if(i > mid){a[k] = b[j++];}
                        else if(j > high){a[k] = b[i++];}
                        else if(sess.Comparetwo(b[i],b[j])){a[k] = b[j++];}
                        else a[k] = b[i++];
                }
        }
	public void Sort(Comparable[] a){
		Comparable b[] = new Comparable[a.length];
		Sortessentials sess = new Sortessentials();
                sess.starttime = System.nanoTime();
		Sort(a,0,a.length-1);
		sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Top Down  Merge Sort");

	}
	public void Sort(Comparable[] a, int low, int high){
		int mid;
		if(high <= low) return;
		mid = low+(high-low)/2;
		Sort(a,low,mid);
		Sort(a,mid+1,high);
		Merge(a,low,mid,high);
	}
}
class MergeSortBU extends TopDownMergeSort{
	public void Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
                sess.starttime = System.nanoTime();
		int N = a.length;
		Comparable b[] = new Comparable[N];
		for(int i=1; i<N; i = (i + i))
			for(int j=0; j < N-i; j += (i+i))
				Merge(a,j,j+i-1,Math.min(j+i+i-1,N-1));
		sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Bottom Up  Merge Sort");
	}
}
class QuickSort{
	public void Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
                sess.starttime=System.nanoTime();
		int low =0;
		int high = a.length-1;
		a = Sort(a,low,high);
		sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Quick Sort");
	}
	public Comparable[] Sort(Comparable[] a, int low, int high){
		if(low >= high) return a;
		int j= Partation(a,low,high);
		Sort(a,low,j-1);
		Sort(a,j+1,high);
		return a;
	}
	public int Partation(Comparable[] a, int low, int high){
		Sortessentials sess = new Sortessentials();
		int i = low; int j = high;
		while(true){
			while(sess.Comparetwo(a[++i],a[low])) if(i == high) break;
			while(sess.Comparetwo(a[high],a[--j])) if(j == low) break;
			if(i >= j) break;
			sess.exhg(a,i,j);
		}
		sess.exhg(a,low,j);
		return j;
	}
}


class Quick3way
{
	 public void Sort(Comparable[] a){
                Sortessentials sess = new Sortessentials();
                sess.starttime=System.nanoTime();
                int low =0;
                int high = a.length-1;
                a = Sort(a,low,high);
                sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Quick Sort 3 way");
        }

	public  Comparable[] Sort(Comparable[] a, int lo, int hi){
		Sortessentials sess = new Sortessentials();
		if (hi <= lo) return a;
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) sess.exhg(a, lt++, i++);
			else if (cmp > 0) sess.exhg(a, i, gt--);
			else i++;
		}
		Sort(a, lo, lt - 1);
		Sort(a, gt + 1, hi);
		return a;
	}
}

class HeapSort{
	private Comparable[] Sink(Comparable[] a, int K, int N){
		Sortessentials sess = new Sortessentials();
		int j=0;
		while(2*K <= N){
			j=2*K;
			if(j < N && sess.Comparetwo(a[j+1],a[j])) j++;
			if(!(sess.Comparetwo(a[j],a[K]))) break;
			sess.exhg(a,j,K);
			K = j;
		}
		return a;
	}
	public void Sort(Comparable[] a){
		Sortessentials sess = new Sortessentials();
		sess.starttime = System.nanoTime();
		int N = a.length;
		for(int i=N/2; i >= 1; i--)
			a = Sink(a,i,N);
		while(N>1){
			sess.exhg(a,1,N--);
			a = Sink(a,1,N);
		}
		sess.endtime = System.nanoTime();
                sess.printmessage(a,sess.starttime,sess.endtime,"Heap Sort");
	}
}

public class Sorting{
	public static void main(String[] args){
		SelectionSort ss = new SelectionSort();
		Comparable a[] = {"vishnu","prasad","shreenivas","sattigeri"};
		ss.Sort(a);
		InsertionSort is = new InsertionSort();
		is.Sort(a);
		ShellSort sh = new ShellSort();
		sh.Sort(a);
		MergeSort mg = new MergeSort();
		mg.Sort(a);
		TopDownMergeSort  tdmg = new TopDownMergeSort();
		tdmg.Sort(a);
		MergeSortBU mgbu = new MergeSortBU();
		mgbu.Sort(a);
		QuickSort qs = new QuickSort();
		qs.Sort(a);
		Quick3way q3way = new Quick3way();
		q3way.Sort(a);
		HeapSort hs = new HeapSort();
		hs.Sort(a);
	}

}
