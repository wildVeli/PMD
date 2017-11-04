package com.example.a2dam.cuartaaplicacion;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final short CANTIDAD_BOTONES=18;
    int[] colores=new int [CANTIDAD_BOTONES];
    GridLayout g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newChildren();


    }

    public void newChildren(){
        g= (GridLayout) findViewById(R.id.grid);
        Button b;
        for(short i=0;i<CANTIDAD_BOTONES;i++){
            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            );

            if(i==CANTIDAD_BOTONES-1){
                b.setText("RESET!");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        for (short i=0;i<g.getChildCount();i++){
                            g.getChildAt(i).setBackgroundColor(colores[i]);
                        }
                    }
                });
            }else{
                b.setText("btn"+(i+1));
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setBackgroundColor(Color.WHITE);
                    }
                });
            }
            b.setId(View.generateViewId());
            g.addView(b,i);
            Random rnd=new Random();
            int color= Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            b.setBackgroundColor(color);
            colores[i]=color;
        }

    }
}
