/**
 * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно, можно пользоваться:
 * String str = "apple";
 * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово
 * Используем только маленькие буквы
 */

package Homework3;

import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String rightAnswer;
        String userAnswer;
        char[] gameField = {35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35};

        int numOfWord = (int) (Math.random()*words.length);
        rightAnswer = words[numOfWord];

        System.out.println("Компьютер загадал слово. (Подсказка для тестирования: " + rightAnswer + ")");
        userAnswer = getAnswerFromScanner(gameField.length);

        if (userAnswer.equals(rightAnswer)) {
            System.out.println("Это правильный ответ! Вы выиграли.");
        } else {
            do {
                for (int i = 0; i < gameField.length && i < userAnswer.length() && i < rightAnswer.length(); i++) {
                    if (userAnswer.charAt(i) == rightAnswer.charAt(i)) {
                        gameField[i] = userAnswer.charAt(i);
                    }
                }
                System.out.println(gameField);
                userAnswer = getAnswerFromScanner(gameField.length);
            } while (!userAnswer.equals(rightAnswer));

            System.out.println("Это правильный ответ! Вы выиграли.");
        }
    }

    public static String getAnswerFromScanner(int answerMaxLength) {
        Scanner scanner = new Scanner(System.in); // создание объекта класса Scanner
        String scannerBuffer;
        do {
            System.out.print("Введите свой ответ: ");
            scannerBuffer = scanner.nextLine();
            if (scannerBuffer.length() > answerMaxLength) System.out.println("Вы ввели слишком длиннный ответ.");
        } while (scannerBuffer.length() > answerMaxLength);

        return scannerBuffer;
    }

}
