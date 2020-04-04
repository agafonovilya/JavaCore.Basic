package Homework6;

public class Cat extends Animal{

    public Cat(){
        super(200, 0, 2.0f);
    }

    public Cat(int runDistanceMax, float jumpHeightMax){
        super(runDistanceMax, 0, jumpHeightMax);
    }

    public boolean canSwim(int swimDistance){
        return false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runDistanceMax=" + getRunDistanceMax() +
                ", swimDistanceMax=" + getSwimDistanceMax() +
                ", jumpHeightMax=" + getJumpHeightMax() +
                '}';
    }
}
