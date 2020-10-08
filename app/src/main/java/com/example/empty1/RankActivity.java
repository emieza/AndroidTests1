package com.example.empty1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RankActivity extends AppCompatActivity {

    static String text = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RankActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        int intents = intent.getIntExtra("intents",-1);
        int partida = intent.getIntExtra("partida",-1);

        if( intents>-1 && partida>-1 ) {
            // Dades vàlides
            String newtext = text + "Partida " + partida + ": " + Integer.toString(intents) + " intents\n";
            text = newtext;
        }
        // mostrem ranking
        TextView tv = findViewById(R.id.rankText);
        tv.setText(text);
        //Log.v("DEBUG", text);
    }
}

