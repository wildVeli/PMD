package com.example.a2dam.primeraaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    Button botonCambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonCambio = (Button) findViewById(R.id.button);
        texto = (TextView) findViewById(R.id.textView);
        botonCambio.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        texto.setText("FUNCIONA");
    }
}
