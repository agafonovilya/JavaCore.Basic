package Homework6;

public class Animal {
    private int runDistanceMax;
    private int swimDistanceMax;
    private float jumpHeightMax;

    public Animal(int runDistanceMax, int swimDistanceMax, float jumpHeightMax){
        this.runDistanceMax = runDistanceMax;
        this.swimDistanceMax = swimDistanceMax;
        this.jumpHeightMax = jumpHeightMax;
    }

    public boolean canRun(int runDistance){
        return (runDistance <= this.runDistanceMax);
    }

    public boolean canSwim(int swimDistance){
        return (swimDistance <= this.swimDistanceMax) && (swimDistance > 0);
    }

    public boolean canJump(float jumpHeight){
        return (jumpHeight <= this.jumpHeightMax);
    }

    public void setRunDistanceMax(int runDistanceMax) {
        this.runDistanceMax = runDistanceMax;
    }

    public int getRunDistanceMax() {
        return runDistanceMax;
    }

    public void setSwimDistanceMax(int swimDistanceMax) {
        this.swimDistanceMax = swimDistanceMax;
    }

    public int getSwimDistanceMax() {
        return swimDistanceMax;
    }

    public void setJumpHeightMax(float jumpHeightMax) {
        this.jumpHeightMax = jumpHeightMax;
    }

    public float getJumpHeightMax() {
        return jumpHeightMax;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "runDistanceMax=" + runDistanceMax +
                ", swimDistanceMax=" + swimDistanceMax +
                ", jumpHeightMax=" + jumpHeightMax +
                '}';
    }
}
