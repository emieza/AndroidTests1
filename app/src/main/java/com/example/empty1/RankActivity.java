package com.example.empty1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
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

            //String newtext = text + nom + ": " + Integer.toString(intents) + " intents\n";
            //text = newtext;
        }
        // mostrem ranking en taula
        TableLayout tableRank = findViewById(R.id.tableRank);
        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);

        for( Record record: records ) {
            TableRow row = new TableRow(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            // set text
            tv1.setText(record.nom);
            tv2.setText(Integer.toString(record.intents));
            tv3.setText(Double.toString(record.temps));
            // layout params
            tv1.setLayoutParams(params1);
            tv2.setLayoutParams(params1);
            tv3.setLayoutParams(params1);
            // afegim a la row i al table layout
            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);
            row.setLayoutParams(params2);
            tableRank.addView(row);
        }


        //tableRank.

        // mostrem ranking en textView
        //TextView tv = findViewById(R.id.rankText);
        //tv.setText(text);
        //Log.v("DEBUG", text);
    }
}

