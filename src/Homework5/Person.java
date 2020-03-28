package Homework5;

public class Person {

    private String fio;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Person(String fio, String position, String email, long phoneNumber, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printPersonInfo(){
        System.out.println(toString()); //Скажите, это корректное использование метода toString?
    }

    @Override
    public String toString() {
        return  "FIO:'" + fio + '\'' +
                ", Position:'" + position + '\'' +
                ", Email:'" + email + '\'' +
                ", PhoneNumber:" + phoneNumber +
                ", Salary:" + salary +
                ", Age:" + age;
    }

    public int getAge(){
        return age;
    }

}
