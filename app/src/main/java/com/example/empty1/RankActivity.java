package com.example.empty1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    class Record {
        public String nom;
        public int intents;
        public double temps;
    }

    static String text = new String();
    static ArrayList<Record> records = new ArrayList<Record>();

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
        String nom = intent.getStringExtra("nom");

        if( intents>-1 && nom!=null ) {
            // Dades vàlides
            Record rec = new Record();
            rec.nom = nom;
            rec.intents = intents;
            rec.temps = 0;
            records.add( rec );

            String newtext = text + nom + ": " + Integer.toString(intents) + " intents\n";
            text = newtext;
        }
        // mostrem ranking en taula
        TableLayout tableRank = findViewById(R.id.tableRank);

        //tableRank.

        // mostrem ranking en textView
        TextView tv = findViewById(R.id.rankText);
        tv.setText(text);
        //Log.v("DEBUG", text);
    }
}

