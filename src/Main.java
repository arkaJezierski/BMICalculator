import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static void main(String[] args) {
//        double weight, height;
//        int age = 0;
        BMIData data = null;
        scanner = new Scanner(System.in);
        List<BMIData> allData = new ArrayList<>();
        getData(allData);

        while (true){
            System.out.println("1.Add new value");
            System.out.println("9.Quit");
            System.out.println("Choose your option:");

            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Write weight(kg), height(cm) and age");
                    System.out.println("Press enter after every value.");

                    data = new BMIData(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    if(isDayExist(allData)){
                        allData.remove(allData.size()-1);
                    }
                    addValue(data);
                    allData.add(new BMIData(data.getBmi(), data.getNow()));

                    break;
                case 2:
                    if (data != null)
                        System.out.println(data.isWeightCorect());
                    else
                        System.out.println("First you must add new value");
                    break;
                case 3:
                    break;
                case 9:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Option doesn't exist");
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

    public static void getData(List<BMIData> db){
        try {
            File read = new File("journal.txt");
            scanner = new Scanner(read);
            while (scanner.hasNext()){
                db.add(new BMIData(scanner.nextDouble(), LocalDate.parse(scanner.next())));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean isDayExist(List<BMIData> db){
        for(BMIData x: db){
            if (x.getNow() == LocalDate.now()){
                return true;
            }
        }
        return false;
    }
}
