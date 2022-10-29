package Lessons.Lesson5;

public class Person {

    private  String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Person(String fullName, String position,
                  String email, String phoneNumber,
                  int salary, int age){

        setFullName(fullName);
        setPosition(position);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);

    }

    public void printInfo(){

        System.out.println("Name: " + getFullName());
        System.out.println("Position: " + getPosition());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone number: " + getPhoneNumber());
        System.out.println("Salary: " + getSalary());
        System.out.println("Age: " + getAge());

    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

}
