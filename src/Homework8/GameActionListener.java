package Homework8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;
    private static boolean SILLY_MODE = true;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;  // Передаем номер ряда, номер столбца и ссылку на кнопку, к которой привязыаем наш GameActionListener
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья");
                board.emptyField();
                SILLY_MODE = true;
            } else {
                updateByAiData(board);
            }
        } else {
            board.getGame().showMessage("Некорректный ход");
        }

    }

    /**
     * Ход человека
     *
     * @param board GameBoard() - ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board) {
        // Обновляем матрицу игры
        board.updateGameField(row, cell);
        // Обновляем содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        // После хода проверим состояние победы
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
            SILLY_MODE = true;
        } else {
            board.getGame().passTurn();
        }
    }

    /**
     * Ход комппьютера
     *
     * @param board GameBoard() - ссылка на игровое поле
     */
    private void updateByAiData(GameBoard board) {

        int maxRate = 0;
        int x = 0;
        int y = 0;

        if(SILLY_MODE) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));

            SILLY_MODE = false;
        }
        else {
            for (int i = 0; i < GameBoard.dimension; i++) {
                for (int j = 0; j < GameBoard.dimension; j++) {
                    if (board.getCellSign(j, i) == GameBoard.nullSymbol) {
                        int rate = calcRate(board, i, j); //вызываю функцию подсчета пустой ячейки
                        if (rate > maxRate) {
                            maxRate = rate;
                            y = j;
                            x = i;
                        }
                    }
                }
            }
        }

        // Обновим матрицу игры
        board.updateGameField(x, y);

        // Обновим содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        // Проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
            SILLY_MODE = true;
        } else {
            board.getGame().passTurn();
        }

        if (board.isFull()) {
            board.getGame().showMessage("Ничья");
            board.emptyField();
            SILLY_MODE = true;
        }
    }

    /**
     * Метод подсчета рейтинга ячейки
     * @param board
     * @param x
     * @param y
     * @return
     */
    private static int calcRate(GameBoard board, int x, int y){
        int rate = 0;

        for(int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++) {
                if(isCellValidCalcRate(i, j)) {
                    if(board.getCellSign(j,i) == board.getGame().getCurrentPlayer().getPlayerSign()){
                        rate++;
                    }
                }
            }
        }

        return rate;
    }

    /**
     * Метод валидации запрашиваемой ячейки на корректность
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValidCalcRate(int x, int y) {
        return !(x < 0 || x >= GameBoard.dimension || y < 0 || y >= GameBoard.dimension);
    }

}