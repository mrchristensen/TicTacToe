package com.example.tictactoe;

public class TicTacToeGame {
    int[][] board;

    private final int blank = 0;
    private final int knot = 1;
    private final int cross = 2;
    private int player;

    public TicTacToeGame(){
        board = new int[3][3];
        player = knot;

        //Set the board to blank //TODO: Check to see if this is necessary
        for (int[] ints : board) {
            for (int i : ints) {
                i = blank;
            }
        }
    }

    public int makeMove(int x, int y){
        if(board[x][y] == knot || board[x][y] == cross){ //Spot already taken
            return -1;
        }
        else{ //Valid move
            board[x][y] = player;

            if(checkWin(x, y)){
                return 1;
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

    private boolean checkWin(int x, int y) {
        return false; //TODO: check the x and y coordinates to see if there in a win in the latest move
        //TODO: Check for all spaces taken
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
