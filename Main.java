import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

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
        for (int i = 1; i < arrayList.size(); i++) {
            int current = arrayList.get(i);
            int j = i;
            while ((j > 0) && (arrayList.get(j - 1) > current)) {
                arrayList.set(j, arrayList.get(j - 1));
                j--;
            }
            arrayList.set(j, current);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try {
            Scanner line = new Scanner(new File("datasets/prototype.txt"));
            while(line.hasNextInt()) {
                list.add(line.nextInt());
                line.nextLine();
            }
        } catch(Exception e) {
            System.out.print("");
        }

        insertionSort(list);

        for(int i:list) { 
            System.out.print(i+" ");          
        }
    }
}