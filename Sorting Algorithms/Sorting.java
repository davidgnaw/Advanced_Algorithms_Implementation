/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR ONLINE SOURCES. YU FUNG DAVID WANG*/

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Sorting {

	public static void BubbleSort(long[] a) {
		int out, in;
		for(out = a.length-1; out > 0; out--) {
			boolean swapped = false;
			for(in = 0; in < out; in++) {
				if(a[in] > a[in+1]) {
					exch(a, in, in+1);
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}

	
	public static void InsertionSort(long[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                exch(a, j, j-1);
            }
        }
	}

	
	public static void SelectionSort(long[] a) {
		int N = a.length;

		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (a[j] < a[min])
					min = j;
			}
			exch(a, i, min);
		}
	}

	
	public static void MergeSort(long[] a) {
		long[] aux = new long[a.length];
		sort(a, aux, 0, a.length-1);
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
  private static void sort(long[] a, long[] aux, int lo, int hi) {
      if (hi <= lo) return; // base case
      int mid = lo + (hi - lo) / 2;
      sort(a, aux, lo, mid);
      sort(a, aux, mid + 1, hi);
      merge(a, aux, lo, mid, hi);
  }

  private static void merge(long[] a, long[] aux, int lo, int mid, int hi) {
      // copy to aux[]
      for (int k = lo; k <= hi; k++) {
          aux[k] = a[k];
      }
      // merge back to a[]
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) {
          if      (i > mid)           a[k] = aux[j++];
          else if (j > hi)            a[k] = aux[i++];
          else if (aux[j] < aux[i]) 	a[k] = aux[j++];
          else                        a[k] = aux[i++];
      }
  }

	public static void QuickSort(long[] a) {
		QuickSort(a, 0, a.length-1);
	}

	private static void QuickSort(long[] a, int left, int right) {
		if(right - left <= 0) // base case
			return;
		int pIdx = partition(a, left, right, right);	// always uses the right end element as pivot
		QuickSort(a, left, pIdx-1); // sorts the left (smaller than pivot) numbers
		QuickSort(a, pIdx+1, right); // sorts the right (greater than pivot) numbers
	}

	private static int partition(long[] a, int left, int right, int pIdx) {
		long pivot = a[pIdx];
		exch(a, pIdx, right);
		int storeIndex = left;
		for(int i=left; i<right; i++) {
			if(a[i] <= pivot)
				exch(a, i, storeIndex++);
		}
		exch(a, right, storeIndex); // to get pivot into position where elements great than pivot are on right and less are on left
		return storeIndex; // returns the pivot index to which the left numbers are smaller and the right are greater
	}


	private static void shuffle (long[] a) {
		Random num = new Random(); 
		for (int i = 0; i < a.length - 1; i++) {
			int ind = num.nextInt(a.length);
			exch(a, ind, i);
		}
	}

	public static void QuickSortOptimized(long[] a) {
		if (a.length - 1 <= 10) { // checks if number of elements is less or equal to cut off
			InsertionSort(a);
		}
		else {
			shuffle(a); // random shuffle
			QuickSortOptimized(a, 0, a.length-1);
		}
	}

	private static void QuickSortOptimized(long[] a, int left, int right) {
		if(right - left <= 0) // base case
			return;
		int pIdx = partition(a, left, right, right);	// always uses the right end element as pivot
		QuickSort(a, left, pIdx-1); // sorts the left (smaller than pivot) numbers
		QuickSort(a, pIdx+1, right); // sorts the right (greater than pivot) numbers
	}

	
	public static void MergeSortNonRec(long[] a) {
		int hi = a.length - 1, lo = 0; // vars same as recursive merge sort
		long[] aux = new long[a.length];

		// traverse with subarrays in the size of power of 2 (2, 4, 8 ... )
		for (int i = 1; i <= hi - lo; i = i*2) { 
			for (int j = lo; j < hi; j += i*2) { 
				
				// break into subarray
				int left = j; // left most index of subarray
				int mid = j + i - 1;
				int right = Math.min(2 * i + j - 1, hi); // right most index of subarray

				// merge and order the subarray
				merge(a, aux, left, mid, right);
			}
		}

	}


	
	// This tests whether your sorted result is correct by comparing it to reference result
	public static boolean testSort(long[] a) {
		long[] a2 = new long[a.length];
		System.arraycopy(a, 0, a2, 0, a.length);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++)
			if(a2[i] != a[i])
				return false;
		return true;
	}

	// This creates an array with n randomly generated elements between (0, n*10]
	private static long[] randArray(int n) {
		long[] rand = new long[n];
		for(int i=0; i<n; i++)
			rand[i] = (int) (Math.random() * n * 10);
		return rand;
	}

	// This creates an ordered array with n elements in ascending order
	private static long[] orderedArray(int n) {
		long[] arr = new long[n];
		for(int i=0; i<n; i++)
			arr[i] = i+1;
		return arr;
	}

	private static void startTimer() {
		timestamp = System.nanoTime();
	}

	private static double endTimer() {
		return (System.nanoTime() - timestamp)/1000000.0;
	}

  // Exchange a[i] and a[j]
  private static void exch(long[] a, int i, int j) {
      long swap = a[i];
      a[i] = a[j];
      a[j] = swap;
  }

	private static long timestamp;


	public static void main(String[] args) {


		// corner case
		boolean useOrderedArray = false;

		// run experiments
		final int BUBBLE = 0, SELECT = 1, INSERT = 2, QUICK = 3, QUICKOPT = 4, MERGEREC = 5, MERGENONREC = 6;
		int[] algorithms = {BUBBLE, SELECT, INSERT, QUICK, QUICKOPT, MERGEREC, MERGENONREC};

		// max defines the maximum size of the array to be tested, which is 2^max
		// runs defines the number of rounds to be performed per test, in order to get an average running time.
		int max = 14, runs = 5;
		double[][] stats = new double[algorithms.length][max];
		for(int i=0; i < algorithms.length; i++) {  //loop through each sorting algorithm
			switch(i) {
				case BUBBLE: System.out.print("Running Bubble Sort ..."); break;
				case SELECT: System.out.print("Running Selection Sort ..."); break;
				case INSERT: System.out.print("Running Insertion Sort ..."); break;
				case QUICK: System.out.print("Running Quicksort..."); break;
				case QUICKOPT: System.out.print("Running Optimized Quicksort..."); break;
				case MERGEREC: System.out.print("Running MergeSort Recursive ..."); break;
				case MERGENONREC: System.out.print("Running MergeSort Non Recursive ..."); break;
			} //end of switch
			for(int j = 0; j < max; j++) { //loop through each array size
				double avg = 0;
				for(int k = 0; k < runs; k++) { //loop through each run
					int n = (int) Math.pow(2, j+1);
					long[] a;
					if(useOrderedArray){ a = orderedArray(n); }
					else { a = randArray(n); }

					startTimer();
					switch(i) {
						case BUBBLE: BubbleSort(a); break;
						case SELECT: SelectionSort(a); break;
						case INSERT: InsertionSort(a); break;
						case QUICK: QuickSort(a); break;
						case QUICKOPT: QuickSortOptimized(a); break;
						case MERGEREC: MergeSort(a); break;
						case MERGENONREC: MergeSortNonRec(a); break;
					}
					avg += endTimer();

					if (testSort(a) == false)
						System.out.println("The sorting is INCORRECT!" + "(N=" + a.length + ", round=" + k + ").");
				}//end of k runs
				avg /= runs;
				stats[i][j] = avg;
			}//end of max array sizes
			System.out.println("done.");
		}//done running all sorting algorithms!

		DecimalFormat format = new DecimalFormat("0.0000");
		System.out.println();
		System.out.println("Average running time:");
	  System.out.println("N\t BubbleSort\tSelectionSort\tInsertionSort\tQuickSort\tQuickSortOpt\tMergeSortRec\tMergeSortNonRec");
		for(int i=0; i<stats[0].length; i++) {
			System.out.print((int) Math.pow(2, i+1) + "\t  ");
			for(int j=0; j<stats.length; j++) {
				System.out.print(format.format(stats[j][i]) + "\t  ");
			}
			System.out.println();
		}
	}//end of main method

}//end of class
