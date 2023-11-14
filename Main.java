import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Heap {
    static int comparisons = 0;
    static int exchanges = 0;

    static boolean precedes(int a, int b) {
        return a < b;
    }
    
    static int[] downHeap(int[] array, int index, int heapSize) {
        boolean foundSpot = false;
        int l = index;
        int key = array[l];
        int k = 2 * l + 1;

        while (k < heapSize && !foundSpot) {
            if (k + 1 < heapSize && !precedes(array[k + 1], array[k]))
                k = k + 1;

            if (k < heapSize && !precedes(array[k], key)) {
                array[l] = array[k];
                l = k;
                k = 2 * l + 1;
            } else {
                foundSpot = true;
            }
        }

        array[l] = key;
        return array;
    }

    static void sort(int[] array) {
        int y = array.length / 2;

        while (y >= 0) {
            downHeap(array, y, array.length);
            y--;
        }

        y = array.length - 1;
        while (y > 0) {
            int temp = array[0];
            array[0] = array[y];
            array[y] = temp;

            downHeap(array, 0, y);

            y--;
        }
    }
}

class Quick {
    static int comparisons = 0;
    static int exchanges = 0;

    static int partition(int[] array, int lo, int hi) {
        int pivot = array[lo];

        while (lo < hi) {
            while (pivot < array[hi] && lo < hi) {
                comparisons++;
                hi--;
            }
            if (hi != lo) {
                array[lo] = array[hi];
                exchanges++;
                lo++;
            }
            while (array[lo] < pivot && lo < hi) {
                comparisons++;
                lo++;
            }
            if (hi != lo) {
                array[hi] = array[lo];
                exchanges++;
                hi--;
            }
        }
        array[hi] = pivot;

        return hi;
    }

    static void sort(int[] array, int lo, int hi) {
        if (lo < hi) {
            int pivotPoint = partition(array, lo, hi);

            if (lo < pivotPoint) 
                sort(array, lo, pivotPoint - 1);
            
            if (pivotPoint < hi) 
                sort(array, pivotPoint + 1, hi);
        }

    }
    static void printStats() {
        System.out.println("Exchanges:" + exchanges);
        System.out.println("Comparisons: " + comparisons);
    }
}

class Shell {
    static int comparisons = 0;
    static int exchanges = 0;

    static void segmentedInsertionSort(int[] array, int n, int h) {
        for (int i = h; i < n; i++) {
            int current = array[i]; 
            int j = i;

            while(j > h - 1 && (array[j-h] > current)) {
                comparisons++;
                array[j] = array[j - h];
                j = j - h;
                exchanges++;
            }

            array[j] = current;
        }
    }
    
    static int[] sort(int[] array, int n) {
        int h = 1;
    
        while (h < n / 2) {
            h = h * 2 + 1;
        }
        
        while (h >= 1) {
            segmentedInsertionSort(array, n, h);
            h = (h - 1) / 2;
        }    

        return array;
    }

    static void printStats() {
        System.out.println("Exchanges:" + exchanges);
        System.out.println("Comparisons: " + comparisons);
    }
}

public class Main {
    public static void selectionSort(ArrayList<Integer> list) {
        int temp, min, exchanges = 0, comparisons = 0;
        int numberOfItems = list.size();

        for (int pass = 0; pass != numberOfItems - 1; pass++) {
            min = pass;
            
            for (int index = pass + 1; index != numberOfItems; index++) {
                comparisons++;
                if (list.get(index) < list.get(min))
                    min = index;
            } 
            
            temp = list.get(min);
            list.set(min, list.get(pass));
            list.set(pass, temp);
            exchanges++;
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);    
    }

    public static void insertionSort(int[] array) {
        int exchanges = 0;
        int comparisons = 0;
        int n = array.length;
    
        for (int i = 1; i < n; i++) {
            int current = array[i];
            int j = i;
    
            while (j > 0 && array[j - 1] > current) {
                comparisons++;
                array[j] = array[j - 1];
                exchanges++;
                j--;
            }
    
            array[j] = current;
        }
    
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }    
    
    public static void bubbleSort(int[] array) {
        int temp = 0;
        int exchanges = 0;
        int comparisons = 0;
        int n = array.length;
        boolean madeSwaps = true;
    
        for (int i = 1; i < n; i++) {
            if (madeSwaps) {
                madeSwaps = false;
                for (int j = 0; j < n - i; j++) {
                    comparisons++;
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        exchanges++;
                        madeSwaps = true;
                    }
                }
            } else break;
        }
        
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int index = 0; 
                
        try {
            Scanner line = new Scanner(new File("datasets/small/ordered.txt"));
                while (line.hasNextInt()) {
                    array[index] = line.nextInt();
                    line.nextLine();
                    index++;
                }
        } catch (Exception e) {
            System.out.print("");
        }

        Heap.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}