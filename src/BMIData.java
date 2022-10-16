import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class BMIData {
    private double weight;
    private double height;
    private int age;
    private double bmi;
    private LocalDate now;

    public BMIData(double weight, double height, int age){
        Date date = new Date();

        this.weight = weight;
        this.height = height/100;
        this.age = age;
        this.now = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        calculateBMI();
    }

    private void checkAge(){
        if(age < 18) System.out.println("You should watch out with it. Your weight can change very quickly");
    }

    public void calculateBMI(){
        this.bmi = this.weight/(this.height*this.height);
    }

    public double getWeight(){
        return this.weight;
    }
    public double getHeight(){
        return this.height;
    }
    public int getAge(){
        return this.age;
    }
    public LocalDate getNow(){
        return this.now;
    }
    public double getBmi(){
        return this.bmi;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setAge(int age){
        this.age = age;
    }
}
