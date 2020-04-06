package Homework7;

public class Cat extends Animal{

    public Cat(){
    super();
    }

    public Cat(String name, int appetite){
        super("Кот " + name, appetite);
    }


    public int getAppetite() {
        return this.appetite;
    }


    public void eat(Plate plate){    //Кормим кота

        if(plate.getPlateBalance() >= this.appetite){    // Проверяем достаточно ли еды в миске
            plate.setPlateBalance(plate.getPlateBalance() - this.appetite);  // Убавляем количество еды на размер апптеита
            setIsHungry(false);// Кот сыт
        }
        else {
            System.out.println("Недостаточно еды в миске");
            this.isHungry = true; // Кот голоден
        }
    }


}
