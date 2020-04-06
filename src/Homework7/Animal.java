package Homework7;

public abstract class Animal {
    protected String name;
    protected int appetite; // Количество пищи, съедаемое котом за 1 раз
    protected boolean isHungry; // Кот голодный?

    public Animal() {
        this.name = "Безымянный";
        this.appetite = 10;
        this.isHungry = true;
    }

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    public void setIsHungry(boolean hungry) {
        this.isHungry = hungry;
    }

    public boolean getIsHungry(){
        return this.isHungry;
    }
}
