package com.example.a2dam.segundaaplicacion;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {


    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    CheckBox checkBox1;
    TextView titulo;
    TextView resultado;
    RadioGroup grupoRadios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        grupoRadios = (RadioGroup) findViewById(R.id.radioGroup);
        grupoRadios.setOnCheckedChangeListener(this);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox1.setOnCheckedChangeListener(this);
        titulo =(TextView) findViewById(R.id.titulo);
        resultado = (TextView) findViewById(R.id.resultado);






    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radioButton1:
                resultado.setText(R.string.radio1);
                break;
            case R.id.radioButton2:
                resultado.setText(R.string.radio2);
                break;
            case R.id.radioButton3:
                resultado.setText(R.string.radio3);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            resultado.setText(R.string.checkboxon);
        }else{
            resultado.setText(R.string.checkboxoff);
        }
    }
}
