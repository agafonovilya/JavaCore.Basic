package Homework6;

public class Dog extends Animal{

    public Dog(){
        super(500, 10, 0.5f);
    }

    public Dog(int runDistanceMax, int swimDistanceMax, float jumpHeightMax){
        super(runDistanceMax, swimDistanceMax, jumpHeightMax);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "runDistanceMax=" + getRunDistanceMax() +
                ", swimDistanceMax=" + getSwimDistanceMax() +
                ", jumpHeightMax=" + getJumpHeightMax() +
                '}';
    }
}
