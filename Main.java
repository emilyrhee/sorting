import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void insertionSort(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        for (int j = 1; j < n; j++) {
            int key = arrayList.get(j);
            int i = j - 1;
            while ((i > -1) && (arrayList.get(i) > key)) {
                arrayList.set(i + 1, arrayList.get(i));
                i--;
            }
            arrayList.set(i + 1, key);
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