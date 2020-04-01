package Homework6;

public class AnimalTest {
    private static final int RUN_DISTANCE = 450;  // Задаем параметры для тестирования
    private static final int SWIM_DISTANCE = 70;   // Задаем параметры для тестирования
    private static final float JUMP_HEIGHT = 0.75f;  // Задаем параметры для тестирования

    public static void main(String[] args) {

        Cat cat1 = new Cat(200, 2);
        Cat cat2= new Cat(500, 0.7f);
        Dog dog1 = new Dog(400, 100, 0.8f);
        Dog dog2= new Dog(600, 50, 0.5f);

        System.out.println("Сможет ли кот 1 пробежать " + RUN_DISTANCE + " метров? Ответ: " + cat1.canRun(RUN_DISTANCE));
        System.out.println("Сможет ли кот 2 пробежать " + RUN_DISTANCE + " метров? Ответ: " + cat2.canRun(RUN_DISTANCE));
        System.out.println("Сможет ли собака 1 пробежать " + RUN_DISTANCE + " метров? Ответ: " + dog1.canRun(RUN_DISTANCE));
        System.out.println("Сможет ли собака 2 пробежать " + RUN_DISTANCE + " метров? Ответ: " + dog2.canRun(RUN_DISTANCE));
        System.out.println();
        System.out.println("Сможет ли кот 1 проплыть " + SWIM_DISTANCE + " метров? Ответ: " + cat1.canSwim(SWIM_DISTANCE));
        System.out.println("Сможет ли кот 2 проплыть " + SWIM_DISTANCE + " метров? Ответ: " + cat2.canSwim(SWIM_DISTANCE));
        System.out.println("Сможет ли собака 1 проплыть " + SWIM_DISTANCE + " метров? Ответ: " + dog1.canSwim(SWIM_DISTANCE));
        System.out.println("Сможет ли собака 2 проплыть " + SWIM_DISTANCE + " метров? Ответ: " + dog2.canSwim(SWIM_DISTANCE));
        System.out.println();
        System.out.println("Сможет ли кот 1 перепрыгнуть препятсвие высотой " + JUMP_HEIGHT + " метр? Ответ: " + cat1.canJump(JUMP_HEIGHT));
        System.out.println("Сможет ли кот 2 перепрыгнуть препятсвие высотой " + JUMP_HEIGHT + " метр? Ответ: " + cat2.canJump(JUMP_HEIGHT));
        System.out.println("Сможет ли собака 1 перепрыгнуть препятсвие высотой " + JUMP_HEIGHT + " метр? Ответ: " + dog1.canJump(JUMP_HEIGHT));
        System.out.println("Сможет ли собака 2 перепрыгнуть препятсвие высотой " + JUMP_HEIGHT + " метр? Ответ: " + dog2.canJump(JUMP_HEIGHT));

    }

}
