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

    public BMIData(double bmi, LocalDate now){
        this.bmi = bmi;
        this.now = now;
    }
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
    public String isWeightCorect(){
        if (bmi == 0) {
            return "Enter your details";
        } else if (bmi < 18.5) {
            return "You are underweight";
        } else if (bmi < 25) {
            return "You are a healthy weight";
        } else if (bmi < 30) {
            return "You are overweight";
        } else if (bmi < 40) {
            return "You are obese";
        } else {
            return "You are severely obese";
        }
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
