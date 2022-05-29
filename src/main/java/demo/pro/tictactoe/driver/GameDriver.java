package demo.pro.tictactoe.driver;

import demo.pro.tictactoe.model.TicTacToeModel;

import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        TicTacToeModel ticTacToeModel = new TicTacToeModel();
        System.out.println("WELCOME TO THE GAME OF TicTacToe !!!!! ");
        int isPlay = 1;
        do {
            Scanner sc = new Scanner(System.in);
            ticTacToeModel.startGame();
            System.out.println("To exit game press 0");
            isPlay = sc.nextInt();
        } while(isPlay != 0);

    }
}
