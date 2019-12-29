package com.example.tictactoe;

import android.util.Log;

import com.example.tictactoe.Model.Position;
import com.example.tictactoe.ui.UI.Activity.StandardGameHolderActivity;

import java.util.Arrays;
import java.util.List;

public class TicTacToeGame {
    private static final String LOG_TAG = "TicTacToeGame";

    int[][] board;
    boolean locked;

    private final int blank = 0;
    private final int knot = 1;
    private final int cross = 2;
    private final int tie= 3;

    private int player; //Who's turn it is
    private int movesMade;

    public TicTacToeGame(){
        board = new int[3][3];
        locked = false;
        player = knot;
        movesMade = 0;

        //Set the board to blank //TODO: Check to see if this is necessary
//        for (int[] ints : board) {
//            for (int i : ints) {
//                i = blank;
//            }
//        }
    }

    public int makeMove(Position pos){
        if(locked){
            return -1;
        }

        int x = pos.getX();
        int y = pos.getY();

        if(board[x][y] == knot || board[x][y] == cross){ //Spot already taken
            return -1;
        }
        else{ //Valid move
            board[x][y] = player;
            movesMade++;

            if(checkWin(pos)){ //Check for a win
                locked = true;
                return player;
            }
            if(movesMade == 9){ //Check for cats game
                locked = true;
                return tie;
            }

            changeTurn();
            return 0;
        }
    }

    private void changeTurn() {
        if(player == knot){
            player = cross;
        }
        else {
            player = knot;
        }
    }

    private boolean checkWin(Position pos) {
        //TODO: check the x and y coordinates to see if there in a win in the latest move
        List<Position> checkDiagonal = Arrays.asList(new Position(0,0), new Position(2,0),
                new Position(1,1), new Position(0,2), new Position(2,2));

        //Check horizontal and vertical
        if(checkHorizontalWin(pos) || checkVerticalWin(pos)){
            return true;
        }

        //Check diagonals
        if(checkDiagonal.contains(pos)){
            Log.i(LOG_TAG, "Check Diagonals");

            switch (pos.getX()){
                case 0:
                    if(checkLeftDiagonalWin()){
                        return true;
                    }
                case 3:
                    if(checkRightDiagonalWin()){
                        return true;
                    }
                default:
                    if(checkLeftDiagonalWin() || checkRightDiagonalWin()){
                        return true;
                    }

            }
        }

        return false;
    }

    private boolean checkHorizontalWin(Position pos) {
        for (int i = 0; i < 3; i++) {
            if(board[i][pos.getY()] != player){
                return false;
            }
        }
        return true;
    }

    private boolean checkVerticalWin(Position pos) {
        for (int i = 0; i < 3; i++) {
            if(board[pos.getX()][i] != player){
                return false;
            }
        }
        return true;
    }

    boolean checkLeftDiagonalWin(){
        for (int i = 0; i < 3; i++) {
            if(board[i][i] != player){
                return false;
            }
        }
        return true;
    }

    boolean checkRightDiagonalWin(){
        for (int i = 0; i < 3; i++) {
            if(board[i][2-i] != player){
                return false;
            }
        }
        return true;
    }

    public String getPlayer() {
        if(player == cross){
            return "cross";
        }
        else{
            return "knot";
        }
    }
}
