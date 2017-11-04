package com.example.a2dam.widgetprimeraaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adaptador;
        ListView l= (ListView) findViewById(R.id.lista);
        resultado= (TextView)findViewById(R.id.resultado);

        adaptador= new ArrayAdapter<String>(this,R.layout.lista,getResources().getStringArray(R.array.elementos));

        l.setAdapter(adaptador);

        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        resultado.setText("Has elegido:"+ adapterView.getItemAtPosition(i).toString());

    }
}
