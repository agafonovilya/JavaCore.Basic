package Homework5;

public class TestPerson {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 89112223344L, 20000, 45);
        persArray[1] = new Person("Petr Petrov", "Manager", "petrov@mailbox.com", 89235467889L, 30000, 30);
        persArray[2] = new Person("Kirill Kirillov", "Director", "kirillov@mailbox.com", 89994567890L, 50000, 55);
        persArray[3] = new Person("Vasiliy Vasiliyev", "Actor", "vasiliy@mailbox.com", 898352345476L, 22500, 35);
        persArray[4] = new Person("Nikolai Nikolaev", "Driver", "nikolaev@mailbox.com", 89057651234L, 31000, 51);

        System.out.println("Выводим информацию о сотрудниках старше 40 лет:");
        for (Person person: persArray) {
            if(person.getAge() >= 40) {
                person.printPersonInfo();
            }
        }

    }
}
