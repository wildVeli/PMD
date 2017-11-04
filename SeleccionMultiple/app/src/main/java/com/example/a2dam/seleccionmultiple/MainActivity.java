package com.example.a2dam.seleccionmultiple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    TextView resultado;
    ListView l;
    String seleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adaptador;

        l= (ListView) findViewById(R.id.lista);

        resultado= (TextView)findViewById(R.id.resultado);
        l.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,getResources().getStringArray(R.array.elementos));
        l.setAdapter(adaptador);

        l.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            seleccionado="";
            resultado.setText("");
            SparseBooleanArray checked=l.getCheckedItemPositions();
            for (short i=0;i<checked.size();i++){
                if(checked.valueAt(i)){
                    seleccionado=(seleccionado+adapterView.getItemAtPosition(checked.keyAt(i)).toString()+" ");
                }

            }
            resultado.setText(seleccionado);
            //

        }
}
