package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
                if(click(0,0) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    topLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        topCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,0");
                if(click(1,0) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    topCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        topRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,0");
                if(click(2,0) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    topRightSquare.setImageDrawable(playerIcon);
                }
            }
        });

        middleLeftSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 0,1");
                if(click(0,1) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    middleLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        middleCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,1");
                if(click(1,1) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    middleCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        middleRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,1");
                if(click(2,1) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    middleRightSquare.setImageDrawable(playerIcon);
                }
            }
        });


        bottomLeftSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 0,2");
                if(click(0,2) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    bottomLeftSquare.setImageDrawable(playerIcon);
                }
            }
        });
        bottomCenterSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 1,2");
                if(click(1,2) == 0){
                    Drawable playerIcon = getPlayerIcon();
                    bottomCenterSquare.setImageDrawable(playerIcon);
                }
            }
        });
        bottomRightSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked: 2,2");
                if(click(2,2) == 0){
                    Drawable playerIcon = getPlayerIcon();
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

    private int click(int x, int y) {
        int result = game.makeMove(x, y);

        if(result == 0){
            Log.i(LOG_TAG, "Successful Move - Next Turn");
            Toast.makeText(this, "Valid Move", Toast.LENGTH_SHORT).show();
            //TODO: next turn
        }
        else if(result == 1){
            Log.i(LOG_TAG, "Successful Move - Game was won");
            Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();
            //TODO: game was won
        }
        else if(result == -1){
            Log.i(LOG_TAG, "Unsuccessful Move - Try again");
            Toast.makeText(this, "Invalid move - Try again", Toast.LENGTH_SHORT).show();
            //TODO: Try a different spot
        }

        return result;
    }
}
