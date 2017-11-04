package com.example.casa.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button anadir,borrar;
    EditText etDisco,etGrupo;
    ListView listaDiscos;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDisco=findViewById(R.id.etTitulo);
        etGrupo=findViewById(R.id.etGrupo);
        listaDiscos=findViewById(R.id.listaDiscos);
        anadir=findViewById(R.id.anadir);
        borrar=findViewById(R.id.borrar);

        db=openOrCreateDatabase("MisDisco", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MisDiscos(Grupo varchar,Disco varchar);");

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO MisDiscos VALUES('"+etGrupo.getText().toString()+"','"+
                etDisco.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Se añadio el disco"+etDisco.getText().toString(),Toast.LENGTH_LONG).show();
                listar();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DELETE FROM MisDiscos WHERE Grupo = '"+etGrupo.getText().toString()+"'AND Disco='"+etDisco.getText().toString()+"' ");
                Toast.makeText(getApplicationContext(), "Se borró el disco"+etDisco.getText().toString(), Toast.LENGTH_SHORT).show();
                listar();
            }
        });


    }

    private void listar() {
        ArrayAdapter<String> adaptador;
        List<String> lista=new ArrayList<String>();
        Cursor c=db.rawQuery("SELECT * FROM MisDiscos",null);

        if(c.getCount()==0){
            lista.add("No hay registros");
        }else{
            while(c.moveToNext()){
                lista.add(c.getString(0)+"-"+c.getString(1));
            }
        }
        adaptador=new ArrayAdapter<String>(getApplicationContext(),R.layout.lista_fila,lista);
        listaDiscos.setAdapter(adaptador);
    }
}
