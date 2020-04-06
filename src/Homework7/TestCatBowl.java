package Homework7;
import java.util.Scanner;


public class TestCatBowl {

    private static Scanner scanner = new Scanner(System.in);
    private final static int PLATE_NUMBER = 0; //определяем номер миски из которой будет есть все коты

    public static void main(String[] args){
        Cat[] arrayOfCats = new Cat[4];   // Создаем массив котов
        arrayOfCats[0] = new Cat("Барсик", 20);
        arrayOfCats[1] = new Cat("Мурзик", 15);
        arrayOfCats[2] = new Cat("Васька", 25);
        arrayOfCats[3] = new Cat();

        Plate[] arrayOfPlate = new Plate[3];   // Создаем массив мисок
        arrayOfPlate[0] = new Plate();    // Создаем миски
        arrayOfPlate[1] = new Plate();    // Создаем миски
        arrayOfPlate[2] = new Plate();    // Создаем миски



        do {
            catEat(arrayOfCats, arrayOfPlate[PLATE_NUMBER]);   //Кормим котов

            if (isSomeoneHungry(arrayOfCats)) {     //Проверяем остался ли кто-то голодным
                fillUpPlate(arrayOfPlate[PLATE_NUMBER]);       //Наполняем миску
                }

        } while (isSomeoneHungry(arrayOfCats));

        System.out.println("Вы накормили всех котов!");

    }

    /**
     * Метод проверяет остались ли голодные коты
      * @param arrayOfCats
     * @return
     */
    public static boolean isSomeoneHungry(Cat[] arrayOfCats){
        boolean isSomeoneHungry = false;
        for (Cat cat: arrayOfCats) {
            if(cat.getIsHungry()) {
                isSomeoneHungry = true;
            }
        }
        return isSomeoneHungry;
    }

    /**
     * Метод кормит всез котов массива из однйо переданной миски
     * @param arrayOfCats
     * @param plate
     */
    public static void catEat(Cat[] arrayOfCats, Plate plate){
        for (Cat cat : arrayOfCats) {
            if (cat.isHungry) {    // Проверяем голоден ли кот
                cat.eat(plate);
                if (!cat.isHungry) {
                    System.out.println(cat.name + " поел, теперь он сыт.");
                } else {
                    System.out.println(cat.name + " не поел, ему не хватило еды");
                }
            }
        }
        System.out.println();
    }

    /**
     * Наполняем миску
     * @param plate
     */
    public static void fillUpPlate(Plate plate) {
        String enter = "";
        do{
            System.out.println("Чтобы наполнить миску и продолжить кормить котов введите 'продолжить'");
            enter = scanner.next();
        }while (!enter.equals("продолжить"));
        plate.fillUpPlate(); // Наполняем миску
    }

}




