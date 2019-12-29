package com.example.tictactoe.ui.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tictactoe.R;
import com.example.tictactoe.ui.UI.Fragment.MainMenuFragment;

public class MenuActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        loadSupportFragment(new MainMenuFragment());

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

}
