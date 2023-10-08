import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

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

    public static void insertionSort(ArrayList<Integer> arrayList) {
        int exchanges = 0;
        int comparisons = 0;
        
        for (int i = 1; i < arrayList.size(); i++) {
            int current = arrayList.get(i);
            int j = i;

            while ((j > 0) && (arrayList.get(j - 1) > current)) {
                comparisons++;
                arrayList.set(j, arrayList.get(j - 1));
                exchanges++;
                j--;
            }

            arrayList.set(j, current);
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges); 
    }
    
    public static void bubbleSort(int[] array) {
        int temp = 0;
        int exchanges = 0;
        int comparisons = 0;
    
        int n = array.length;
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchanges++;
                }
            }
        }
        
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }    

    public static void main(String[] args) {
        int[] array = new int[10];
        int index = 0; 
                
        try {
            Scanner line = new Scanner(new File("datasets/small/random.txt"));
                while (line.hasNextInt()) {
                    array[index] = line.nextInt();
                    line.nextLine();
                    index++;
                }
        } catch (Exception e) {
            System.out.print("");
        }

        for (int i = 0; i <= index; i++) {
            //System.out.print(array[i] + " ");
        }

        radixSort(array);

    }
}