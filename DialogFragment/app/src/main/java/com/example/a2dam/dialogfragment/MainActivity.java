package com.example.a2dam.dialogfragment;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DialogoSexo.RespuestaDialogoSexo {

    Button b;
    boolean disponible= false;
    ProgressBar progresoHorizontal;
    ProgressBar progresoRueda;
    Chronometer cronometro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progresoHorizontal=(ProgressBar)findViewById(R.id.progresoHorizontal);
        progresoHorizontal.setVisibility(View.INVISIBLE);
        progresoRueda=(ProgressBar)findViewById(R.id.progresoRueda);
        cronometro=(Chronometer)findViewById(R.id.cronometro);
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.start();
        progresoRueda.setVisibility(View.INVISIBLE);
        progresoHorizontal.setMax(5000);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }
    public void onRespuesta(String s){

        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Este mensaje se autodestruira",Toast.LENGTH_LONG).show();
        progresoRueda.setVisibility(View.VISIBLE);
        b.setVisibility(View.GONE);
        progresoHorizontal.setVisibility(View.GONE);
        new CountDownTimer(8000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                System.exit(0);
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        if(!disponible){
            progresoHorizontal.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"CARGANDO",Toast.LENGTH_LONG).show();
            new CountDownTimer(5000, 1000) {
                public void onTick(long millisUntilFinished) {
                    progresoHorizontal.setProgress(5000-(int) millisUntilFinished);

                }

                public void onFinish() {
                    progresoHorizontal.setProgress(5000);
                    disponible=true;
                    DialogoSexo ds=new DialogoSexo();
                    ds.show(getFragmentManager(),"Mi diálogo");
                    progresoHorizontal.setVisibility(View.GONE);
                }
            }.start();
        }



    }
}
