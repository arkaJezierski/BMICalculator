import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double weight, height;
        int age;


        while (true){
            System.out.println("1.Add new value");
            System.out.println("9.Quit");
            System.out.println("Choose your option:");
            int i=scanner.nextInt();
            switch (i){
                case 1:
                    System.out.println("Write weight(kg), height(cm) and age");
                    System.out.println("Press enter after every value.");

                    BMIData data = new BMIData(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    addValue(data);
                    break;
            }

        }


    }
    public static void addValue(BMIData data){
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("journal.txt", true));
            writer.append(String.format("%.2f",data.getBmi())+"\n" + data.getNow()+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
