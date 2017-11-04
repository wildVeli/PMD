package com.example.casa.layouts;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioGroup grupoRadios;
    Button estaVentana,otraVentana;
    EditText nombre;
    TextView resul;
    String[] info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estaVentana=(Button)findViewById(R.id.b1);
        otraVentana=(Button)findViewById(R.id.b2);
        nombre=(EditText)findViewById(R.id.eT1);
        resul=(TextView)findViewById(R.id.resultadoMismaVentana);

        info=new String [2];
        info[1]="";

        grupoRadios=(RadioGroup)findViewById(R.id.rG0);

        otraVentana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);

                info[0]=nombre.getText().toString();

                i.putExtra("intento",info);
                startActivity(i);

            }
        });
        estaVentana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText("hola "+info[1]+" "+nombre.getText().toString());
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rB0:
                if (checked)
                    info[1]="Sr";
                    break;
            case R.id.rB1:
                if (checked)
                    info[1]="Sra";
                    break;
        }

    }
}
