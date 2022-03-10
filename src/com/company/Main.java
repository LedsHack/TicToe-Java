package com.company;
import java.util.Scanner;
/*TicToe by LEDShack */
public class Main {

    public static void main(String[] args) {
        String[] display = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        int game = 0;
        int[] StepX = new int[5];
        //int[] StepX = {1, 4, 5};
        int[] StepY = new int[5];
        String play = "X";
        /* Я незнаю як по другому */
        int cnX = 0;
        int cnY = 0;

        while(true){
            doska(display);

            Scanner in = new Scanner(System.in);
            System.out.println("Ваш ход ("+ play +"): ");
            int hod = in.nextInt();

            if(CheckAcc(StepX, StepY, hod, cnX, cnY) || hod < 1 || hod > 9){
                System.out.println("Ви зробили не вірний хід \nВиберіть вільну клітинку в діапазоні [1-9]");
                continue;
            }

            if(play == "X"){
                display[hod - 1] = "X";
                StepX[cnX] = hod;
                if(CheckWin(StepX, cnX)){
                    break;
                }else play = "O";
                cnX++;
            }else{
                display[hod - 1] = "O";
                StepY[cnY] = hod;
               // StepY.
                if(CheckWin(StepY, cnY)){
                    break;
                }else play = "X";
                cnY++;
            }
            game++;
            if(game == 9) {
                play = "Дружба";
                break;
            }
        }
        System.out.println("Переможець: " + play);

    }
    public static void doska(String[] display){
        for(int i = 0; i < 9; i += 3){
            System.out.println("| " + display[i] + " | | " + display[i + 1] + " | | " + display[i + 2] + " |");
        }
    }
    public static boolean CheckAcc(int[] player, int[] player2, int acc, int cnnx, int cnny){
        for(int i = 0; i <= cnnx; i++){
            if(player[i] == acc) return true;
        }
        for(int i = 0; i <= cnny; i++){
            if(player2[i] == acc) return true;
        }
        return false;
    }
    public static boolean CheckWin(int[] player, int cnn){
        int[][] win =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
        int check = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k <= cnn; k++){
                    if(win[i][j] == player[k]) check++;
                }
            }
            if(check == 3){
                return true;
            }else check = 0;
        }
        return false;
    }
}
