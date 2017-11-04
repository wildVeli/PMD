package com.example.a2dam.terceraaplicacion;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageButton llamada;
    ImageView contacto;
    TextView texto;

    boolean llamando=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llamada=(ImageButton) findViewById(R.id.imageButton);
        contacto=(ImageView) findViewById(R.id.imageView);
        texto=(TextView) findViewById(R.id.texto);

    }

    public void llamar(View view) {

        if(llamando){
            llamando=false;
            contacto.setImageResource(R.drawable.steve);
            llamada.setImageResource(R.drawable.call);
            texto.setText(R.string.colgar);

        }else{
            llamando=true;
            contacto.setImageResource(R.drawable.stevejobs);
            llamada.setImageResource(R.drawable.colgar);
            texto.setText(R.string.llamando);
        }
    }
}
