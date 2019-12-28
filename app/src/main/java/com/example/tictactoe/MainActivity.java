package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tictactoe.Model.Position;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    private ImageView topLeftSquare;
    private ImageView topCenterSquare;
    private ImageView topRightSquare;
    private ImageView middleLeftSquare;
    private ImageView middleCenterSquare;
    private ImageView middleRightSquare;
    private ImageView bottomLeftSquare;
    private ImageView bottomCenterSquare;
    private ImageView bottomRightSquare;

    TicTacToeGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new TicTacToeGame();

        //Setting local variables
        topLeftSquare = findViewById(R.id.topLeftSquare);
        topCenterSquare = findViewById(R.id.topCenterSquare);
        topRightSquare = findViewById(R.id.topRightSquare);
        middleLeftSquare = findViewById(R.id.middleLeftSquare);
        middleCenterSquare = findViewById(R.id.middleCenterSquare);
        middleRightSquare = findViewById(R.id.middleRightSquare);
        bottomLeftSquare = findViewById(R.id.bottomLeftSquare);
        bottomCenterSquare = findViewById(R.id.bottomCenterSquare);
        bottomRightSquare = findViewById(R.id.bottomRightSquare);

        //Setting click listeners
        topLeftSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 0,0");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(0,0)) != -1){
                    topLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        topCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,0");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(1,0)) != -1){
                    topCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        topRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,0");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(2,0)) != -1){
                    topRightSquare.setImageDrawable(playerIcon);
                }
            }
        });

        middleLeftSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 0,1");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(0,1)) != -1){
                    middleLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        middleCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,1");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(1,1)) != -1){
                    middleCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        middleRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,1");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(2,1)) != -1){
                    middleRightSquare.setImageDrawable(playerIcon);
                }
            }
        });


        bottomLeftSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 0,2");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(0,2)) != -1){
                    bottomLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        bottomCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,2");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(1,2)) != -1){
                    bottomCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        bottomRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,2");
                Drawable playerIcon = getPlayerIcon();

                if(click(new Position(2,2)) != -1){
                    bottomRightSquare.setImageDrawable(playerIcon);
                }
            }
        });
    }

    private Drawable getPlayerIcon() {
        Log.i(LOG_TAG, "Player: " + game.getPlayer());
        if(game.getPlayer().equals("knot")){
            return getResources().getDrawable(R.drawable.circle);
        }
        else{
            return getResources().getDrawable(R.drawable.plus);
        }
    }

    private int click(Position pos) {
        int result = game.makeMove(pos);

        if(result == 0){  //Todo: Make this not a magic number
            Log.i(LOG_TAG, "Successful Move - Next Turn");
            //TODO: next turn
        }
        else if(result == 1){ //Todo: Make this not a magic number
            Log.i(LOG_TAG, "Game was won - knots win");
            Toast.makeText(this, "Game Over - knots win!", Toast.LENGTH_LONG).show();
            //TODO: game was won
        }
        else if(result == 2){ //Todo: Make this not a magic number
            Log.i(LOG_TAG, "Game was won - crosses win");
            Toast.makeText(this, "Game Over - crosses win!", Toast.LENGTH_LONG).show();
            //TODO: game was won
        }
        else if(result == 3){ //Todo: Make this not a magic number
            Log.i(LOG_TAG, "Game was tied - cats game");
            Toast.makeText(this, "Game Over - cats game", Toast.LENGTH_LONG).show();
            //TODO: game was won
        }
        else if(result == -1){  //Todo: Make this not a magic number
            Log.i(LOG_TAG, "Unsuccessful Move - Try again");
            Toast.makeText(this, "Invalid move - Try again", Toast.LENGTH_SHORT).show();
            //TODO: Try a different spot
        }

        return result;
    }
}
