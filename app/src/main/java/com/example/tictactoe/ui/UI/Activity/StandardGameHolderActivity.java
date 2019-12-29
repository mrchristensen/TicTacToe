package com.example.tictactoe.ui.UI.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tictactoe.R;
import com.example.tictactoe.ui.UI.Fragment.GameFragment;


public class StandardGameHolderActivity extends AppCompatActivity {
    TextView currentPlayersTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_game_activity);

        //Setting instance variables
        currentPlayersTurn = findViewById(R.id.currentPlayersTurn);

        loadSupportFragment(new GameFragment());
    }

    public void loadSupportFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = manager.beginTransaction();
        if (manager.getFragments().isEmpty()) {
            fragTransaction.add(R.id.fragmentFrame, fragment);
        } else {
            fragTransaction.replace(R.id.fragmentFrame, fragment);
        }
        fragTransaction.commit();
    }

    public void updateCurrentPlayersTurn(String player){
        currentPlayersTurn.setText(player);
    }
}
