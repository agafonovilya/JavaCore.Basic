package Homework7;

public class Plate {
    protected int plateVolume;
    protected int plateBalance;

    public Plate(){
        this.plateVolume = 50;
        this.plateBalance = 0;
    }

    public Plate(int plateVolume){
        this.plateVolume = plateVolume;
        this.plateBalance = 0;
    }

    public void fillUpPlate(){   // Наполнить миску
        this.plateBalance = this.plateVolume;
        System.out.println("Миска наполнена.");
    }

    public int getPlateBalance() {   // Получить остаток в миске
        return this.plateBalance;
    }

    public void setPlateBalance(int plateBalance) { // Кормим кота, уменьшаем остаток в миске
        this.plateBalance = plateBalance;
    }


}