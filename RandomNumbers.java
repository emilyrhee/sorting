import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
   
public class RandomNumbers {
    public static void main(String args[]) {
        Random rand = new Random();

        try {
            FileWriter fileWriter = new FileWriter(
                                        new File("datasets", "large.txt")
                                    );

            for (int i = 0; i < 2000; i++) {
                fileWriter.write(Integer.toString(rand.nextInt(2000)) + "\n");
            }
            fileWriter.close();                        
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}