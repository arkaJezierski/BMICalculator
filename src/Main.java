import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height;
        int age;

        System.out.println("Write weight(kg), height(cm) and age");
        System.out.println("Press enter after every value.");

        //Get values and create object
        BMIData data = new BMIData(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());

//        weight = scanner.nextDouble();
//        height = scanner.nextDouble();
//        age = scanner.nextInt();
//        BMIData data = new BMIData(weight, height, age);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("journal.txt", true));
            writer.append("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}