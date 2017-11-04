package com.example.a2dam.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;

/**
 * Created by 2dam on 05/10/2017.
 */

public class DialogoSexo extends DialogFragment{

    RespuestaDialogoSexo respuesta;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pregunta muy importante");
        builder.setMessage("¿Eres una chica?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es una chica");

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es un chico");


            }
        });


        return builder.create();
    }
    public interface RespuestaDialogoSexo{
        public void onRespuesta (String s);
    }

    public void  onAttach(Activity activity){
        super.onAttach(activity);
        respuesta=(RespuestaDialogoSexo)activity;
    }



}
