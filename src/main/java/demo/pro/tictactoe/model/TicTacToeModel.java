package demo.pro.tictactoe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToeModel {
    private ArrayList<List<String>> block;
    private int isWinner;//0 draw, 1->player1, 2->player2,3->draw
    String player1;
    String player2;

    public TicTacToeModel() {
        initialiseBlock();
        isWinner = 0;
    }

    private void initialiseBlock() {
        block = new ArrayList<List<String>>();
        block.add(Arrays.asList(" "," "," "));
        block.add(Arrays.asList(" "," "," "));
        block.add(Arrays.asList(" "," "," "));
    }

    private int checkWinner() {
//        System.out.println("TicTacToeModel::checkWinner");
        String line = new String();
        for(int i = 0; i < 8; i++) {
            switch (i) {
                case 1:
                    line = block.get(0).get(0) + block.get(0).get(1) + block.get(0).get(2);
//                    System.out.println("Case1 Line = "+line);
                    break;
                case 2:
                    line = block.get(1).get(0) + block.get(1).get(1) + block.get(1).get(2);
//                    System.out.println("Case2 Line = "+line);
                    break;
                case 3:
                    line = block.get(2).get(0) + block.get(2).get(1) + block.get(2).get(2);
//                    System.out.println("Case3 Line = "+line);
                    break;
                case 4:
                    line = block.get(0).get(0) + block.get(1).get(0) + block.get(2).get(0);
//                    System.out.println("Case4 Line = "+line);
                    break;
                case 5:
                    line = block.get(0).get(1) + block.get(1).get(1) + block.get(2).get(1);
//                    System.out.println("Case5 Line = "+line);
                    break;
                case 6:
                    line = block.get(0).get(2) + block.get(1).get(2) + block.get(2).get(2);
//                    System.out.println("Case6 Line = "+line);
                    break;
                case 7:
                    line = block.get(0).get(0) + block.get(1).get(1) + block.get(2).get(2);
//                    System.out.println("Case7 Line = "+line);
                    break;
                case 8:
                    line = block.get(0).get(2) + block.get(1).get(1) + block.get(2).get(0);
//                    System.out.println("Case8 Line = "+line);
                    break;
            }

            if(line.equals("XXX")) {
                isWinner = 1;
                return isWinner;
            } else if(line.equals("OOO")) {
                isWinner = 2;
                return isWinner;
            } else {
                int c = 0;
                for(int m = 0;m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        if(block.get(m).get(n) != " "){
                            c++;
                        }
                    }
                }

                if(c == 9) {
                    isWinner = 3;
                    return isWinner;
                }
            }
        }

        return isWinner;
    }

    private void setPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SELECT PLAYERS!!");
        System.out.println("Player1(X) : ");
        player1 = scanner.nextLine();
        System.out.println("Player2(O) : ");
        player2 = scanner.nextLine();
    }
    private void displayBlock() {
        System.out.println("  1  2  3");
        for(int i = 0; i < 3; i++) {
            System.out.print(Integer.toString(i+1)+"| ");
            for(int j = 0; j < 3; j++) {
                System.out.print(block.get(i).get(j) + "|");
            }
            System.out.println("\n---------");
        }
    }

    private Boolean setBlockGrid(int playerRow, int playerCol, int player) {
        if(player == 1) {
            if(block.get(playerRow-1).get(playerCol-1) != " "){
                return false;
            }
            block.get(playerRow-1).set(playerCol-1, "X");
        } else {
            if(block.get(playerRow-1).get(playerCol-1) != " "){
                return false;
            }
            block.get(playerRow-1).set(playerCol-1, "O");
        }

        return true;
    }

    public void startGame() {
        displayBlock();
        setPlayer();
        displayBlock();
        int player1Row;
        int player1Col;
        int player2Row;
        int player2Col;
        Scanner sc = new Scanner(System.in);
        while(isWinner == 0) {
            boolean isValid = true;
            System.out.println("Player1(X) Select Grid Number");

            do {
                System.out.print("ROW: ");
                player1Row = sc.nextInt();
                System.out.print("COL: ");
                player1Col = sc.nextInt();
                if(!(player1Row > 0 && player1Row<= 3) && !(player1Col > 0 && player1Col<= 3) ) {
                    System.out.println("Invalid Grid Number. Enter Again");
                    isValid = false;
                    continue;
                } else {
                    isValid = true;
                }
                if(setBlockGrid(player1Row,player1Col,1) == false){
                    System.out.println("Invalid Grid Number. Enter Again");
                    isValid = false;
                }
            } while(isValid == false);

            displayBlock();

            if(checkWinner() == 1) {
                System.out.println("WINNER WINNER CHICKEN DINNER for " + player1);
                return;
            } else if(checkWinner() == 2){
                System.out.println("WINNER WINNER CHICKEN DINNER for " + player2);
                return;
            } else if(checkWinner() == 3) {
                System.out.println("DRAW");
                return;
            }


            System.out.println("Player2(O) Select Grid Number");
            do {
                System.out.print("ROW: ");
                player2Row = sc.nextInt();
                System.out.print("COL: ");
                player2Col = sc.nextInt();
                if(!(player2Row > 0 && player2Row<= 3) && !(player2Col > 0 && player2Col<= 3) ) {
                    System.out.println("Invalid Grid Number. Enter Again");
                    isValid = false;
                    continue;
                } else {
                    isValid = true;
                }
                if(setBlockGrid(player2Row,player2Col,0) == false){
                    System.out.println("Invalid Grid Number. Enter Again");
                    isValid = false;
                }
            } while(isValid == false);

            displayBlock();

            if(checkWinner() == 1) {
                System.out.println("WINNER WINNER CHICKEN DINNER for " + player1);
                return;
            } else if(checkWinner() == 2){
                System.out.println("WINNER WINNER CHICKEN DINNER for " + player2);
                return;
            } else if(checkWinner() == 3) {
                System.out.println("DRAW");
                return;
            }
        }
    }
}
