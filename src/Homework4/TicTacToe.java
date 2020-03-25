package Homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /**
     * Блок настроек игры
     */
    private static char[][] map;    // матрица игры
    private static int SIZE = 5;    // размерночть поля
    private static String Hat = ""; // горизонтальная часть шапки

    private static final char DOT_EMPTY = '●';  // пустой символ - свободное поле
    private static final char DOT_X = 'X';  // крестик
    private static final char DOT_O = 'O';  // нолик

    private static boolean SILLY_MODE = true; //Режим игры компьютера

    private static Scanner scanner = new Scanner(System.in);
    private  static Random random = new Random();

    private static int lastX, lastY; //Переменные всегда хранят последний ход

    public static void main(String[] args) throws InterruptedException {
        initMap(); //Инициализируем игровое поле
        printMap(); //Печатаем игровое поле

        while(true) {
            humanTurn();    // ход человека
            if(isEndGame(DOT_X)) {
                break;
            }

            computerTurn(); // ход компьютера
            if(isEndGame(DOT_O)) {
                break;
            }
        }

        System.out.println("Игра закончена");
    }

    /**
     * Метод подготовки игрового поля. Ячейки заполняются сиволами ●
     */
    private static void initMap() {
        initHat();

        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Инициализация горизонталььной части шапки в зависимости от размерности поля
     */
    private static void initHat() {

        for (int i = 0; i <= SIZE; i++) {
            Hat += i + " ";
        }
    }

    /**
     * Метод вывода игрового поля на экран
     */

    private static void printMap() {

        System.out.println(Hat); //Выводим горизонтальную часть шапки

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;

        do{
            System.out.print("Введите координаты ячейки через пробел: ");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        }while (!isCellValidToTurn(x,y));

        map[y][x] = DOT_X;
        lastX = x;
        lastY = y;

    }

    /**
     * Ход компьютера. Первый ход компьютер делает в случайную ячейку. Следущий ход делается в ячейку с максимальным числом соседей того же знака.
     */
    private static void computerTurn() throws InterruptedException {
        int x = -1;
        int y = -1;

        if(SILLY_MODE) {
            do {
                ComputerThinkDelay();
                System.out.println();
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValidToTurn(x, y));

            SILLY_MODE = false;
        }
        else {
            int maxRate = 0;
            ComputerThinkDelay();

            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(map[i][j] == DOT_EMPTY) {
                        int rate = calcRate(i, j); //вызываю функцию подсчета пустой ячейки
                        if (rate > maxRate) {
                            maxRate = rate;
                            y = i;
                            x = j;
                        }
                    }
                }
            }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;

        lastX = x;
        lastY = y;
    }

    /**
     * Метод подсчета рейтинга ячейки. Максимальный рейтнг у ячейки с максимальным количеством соседей того же знака.
     */
    private static int calcRate(int x, int y){
        int rate = 0;

        for(int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++) {
                if(isCellCoordinatesValid(i, j)) {
                    if(map[i][j] == DOT_O){
                        rate++;
                    }
                }
            }
        }

        return rate;
    }


    /**
     * Метод валидации запрашиваемой ячейки на корректность
     * @param x - координата по горизонтали
     * @param y - координата по вертикали
     * @return boolean - признак валидности
     */
    private static boolean isCellValidToTurn(int x, int y) {
        boolean result = true;

        // проверка координаты
        if(!isCellCoordinatesValid(x, y)) {
            result = false;
            System.out.print("Вы ввели неверные координаты. ");
        }
        // проверка заполненности ячейки
        else {
            if(map[y][x] != DOT_EMPTY) {
                result = false;
                System.out.print("Эта ячейка уже заполнена. ");
            }
        }
        return result;
    }

    /**
     * Метод проверки ячейки на корректность при подсчете ее рейтинга
     */
    private static boolean isCellCoordinatesValid(int x, int y) {
        boolean result = true;

        // проверка координаты
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }

        return result;
    }



    /**
     * Метод проверки игры на завершение
     * @param playerSymbol - символ, которым играет текущий игрок
     * @return boolean - признак завершения игры
     */
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        // проверяем необходимость следующего хода
        if(checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    /**
     * Проверка на 100%-ю заполненность поля
     * @return boolean - признак оптимальности
     */
    private static boolean isMapFull(){
        boolean result = true;

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return  result;
    }

    /**
     * Метод проверки выигрыша.
     * Проверку выигрыша производим только относительно последнего хода, чтобы не тратить ресурсы на проверку всего поля.
     * @param playerSymbol - символ, введенный пользователем
     * @return boolean - результат проверки
     */
    private static boolean checkWin(char playerSymbol){
        boolean result = false;
        int x, y;

        /*Проверяем горизонталь. За нулевую точку берем последний ход и проверяем 3 следующие ячейки справа.
        * Затем нулевую точку сдвигаем на единицу влево и опять проверяем 3 соседних ячейки справа.
        * И так 4 раза, т.е. проверяем все возможные варианты по горизонтали.
        * */
        y = lastY;
        for (int i = 0; i <= 3; i++) {
            x = lastX - i;
            if (isCellCoordinatesValid(x, y) &&
                isCellCoordinatesValid(x + 1, y) &&
                isCellCoordinatesValid(x + 2, y) &&
                isCellCoordinatesValid(x + 3, y)) {
                    if ((map[y][x] == playerSymbol) &&
                        (map[y][x+1] == playerSymbol) &&
                        (map[y][x+2] == playerSymbol) &&
                        (map[y][x+3] == playerSymbol)) {
                        result = true;
                    }
            }
        }
        /*Проверяем вертикаль. За нулевую точку берем последний ход и проверяем 3 следующие ячейки снизу.
         * Затем нулевую точку сдвигаем на единицу вверх и опять проверяем 3 соседних ячейки снизу.
         * И так 4 раза, т.е. проверяем все возможные варианты по вертикали.
         * */
        x = lastX;
        for (int i = 0; i <= 3; i++) {
            y = lastY - i;
            if (isCellCoordinatesValid(x, y) &&
                    isCellCoordinatesValid(x, y + 1) &&
                    isCellCoordinatesValid(x, y + 2) &&
                    isCellCoordinatesValid(x, y + 3)) {
                if ((map[y][x] == playerSymbol) &&
                        (map[y+1][x] == playerSymbol) &&
                        (map[y+2][x] == playerSymbol) &&
                        (map[y+3][x] == playerSymbol)) {
                    result = true;
                }
            }
        }

        /*Проверяем диагональ слева направо. За нулевую точку берем последний ход и проверяем 3 следующие ячейки по дигонали слева направо.
         * Затем нулевую точку сдвигаем на единицу влево и вверх и опять проверяем 3 следующие ячейки по дигонали слева направо.
         * И так 4 раза, т.е. проверяем все возможные варианты по дигонали слева направо.
         * */
        for (int i = 0; i <= 3; i++) {
            x = lastX - i;
            y = lastY - i;
            if (isCellCoordinatesValid(x, y) &&
                    isCellCoordinatesValid(x + 1, y + 1) &&
                    isCellCoordinatesValid(x + 2, y + 2) &&
                    isCellCoordinatesValid(x + 3, y + 3)) {
                if ((map[y][x] == playerSymbol) &&
                        (map[y+1][x+1] == playerSymbol) &&
                        (map[y+2][x+2] == playerSymbol) &&
                        (map[y+3][x+3] == playerSymbol)) {
                    result = true;
                }
            }
        }

        /*Проверяем диагональ справо налево. За нулевую точку берем последний ход и проверяем 3 следующие ячейки по дигонали справо налево.
         * Затем нулевую точку сдвигаем на единицу вправо и вверх и опять проверяем 3 следующие ячейки по дигонали справо налево.
         * И так 4 раза, т.е. проверяем все возможные варианты по дигонали справо налево.
         * */
        for (int i = 0; i <= 3; i++) {
            x = lastX + i;
            y = lastY - i;
            if (isCellCoordinatesValid(x, y) &&
                    isCellCoordinatesValid(x - 1, y + 1) &&
                    isCellCoordinatesValid(x - 2, y + 2) &&
                    isCellCoordinatesValid(x - 3, y + 3)) {
                if ((map[y][x] == playerSymbol) &&
                        (map[y+1][x-1] == playerSymbol) &&
                        (map[y+2][x-2] == playerSymbol) &&
                        (map[y+3][x-3] == playerSymbol)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private static void ComputerThinkDelay() throws InterruptedException {
        System.out.print("Компьютер совершает ход");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(300);
            System.out.print(".");
        }
        System.out.println();
    }
}

