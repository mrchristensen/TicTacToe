package com.example.tictactoe.ui.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tictactoe.R;
import com.example.tictactoe.ui.UI.Activity.StandardGameHolderActivity;

public class MainMenuFragment extends Fragment {
    private static final String LOG_TAG = "MainMenuFragment";

    private Button regularGameButton;
    private Button ultimateGameButton;
    private Button exitButton;

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu_fragment, container, false);

        //Setting local variables
        regularGameButton = view.findViewById(R.id.regularGameButton);
        ultimateGameButton = view.findViewById(R.id.ultimateGameButton);
        exitButton = view.findViewById(R.id.exitButton);

        //Setting click listeners
        regularGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked regularGameButton");
                //((MainActivity) getActivity()).loadSupportFragment(new MyMapFragment()); //TODO: Set the other settings through fragments (local coop vs computer, what difficulty level, etc)
                Intent personActivityIntent = new Intent(getContext(), StandardGameHolderActivity.class);
                startActivity(personActivityIntent);
            }
        });
        ultimateGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked ultimateGameButton");
                //((MainActivity) getActivity()).loadSupportFragment(new MyMapFragment()); //TODO: Set the other settings through fragments (local coop vs computer, what difficulty level, etc)
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Clicked exitButton");
                //TODO: Exit the application (give a prompt through a dialog)
            }
        });

        return view;
    }

}
