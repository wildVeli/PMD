package com.example.casa.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView resul;
    String[] info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resul=(TextView)findViewById(R.id.resultado);


        Intent i=getIntent();
        info=i.getStringArrayExtra("intento");
        resul.setText("Hola "+info[1]+" "+info[0]);




    }

}
