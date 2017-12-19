package main.transition;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /* Prueba
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView image = new ImageView(this);
        setContentView(image);
        TransitionDrawable transition = (TransitionDrawable) getDrawable(R.drawable.transition);
        image.setImageDrawable(transition);
        transition.startTransition(2000);
    }
    */

    AnimationDrawable flami;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Donde se añadira la animación
        ImageView image = findViewById(R.id.imageViewFlami);
        image.setBackgroundResource(R.drawable.transition);
        flami = (AnimationDrawable) image.getBackground();

        //
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                flami.start();
                return true;
            }

        });


    }
}
