package com.example.empty1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int partida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simButton = findViewById(R.id.simpartidaButton);
        simButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // simulem partida amb certs intents
                int intents = 11;

                Intent intent = new Intent(MainActivity.this, RankActivity.class);
                intent.putExtra("intents",intents);
                intent.putExtra("partida",partida++);
                startActivity(intent);
            }
        });


        Button rankButton = findViewById(R.id.rankButton);
        rankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RankActivity.class);
                // llancem intent sense extres
                startActivity(intent);
            }
        });


    }
}