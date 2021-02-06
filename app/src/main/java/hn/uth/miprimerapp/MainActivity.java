package hn.uth.miprimerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;
    TextView  lblEtiqueta;
    Button btnCambiarTexto;
    Button btnRedireccionar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo", "onCreate");
        Log.i("-Ciclo",String.valueOf(savedInstanceState));
        txtInput = findViewById(R.id.txtEntrada);
        btnCambiarTexto = findViewById(R.id.btnCambiarTexto);
        lblEtiqueta=findViewById(R.id.txwHolaMudno);
        btnRedireccionar=findViewById(R.id.btnRedireccionar);
        btnCambiarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtInput.getText().toString().isEmpty())
                  lblEtiqueta.setText(txtInput.getText().toString());
//                Toast.makeText(MainActivity.this,txtInput.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        btnRedireccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Permite pasar parametros a otra actividad*/
                Intent intent = new Intent( MainActivity.this,SegundaPantallaActivity.class);
                intent.putExtra("valor",txtInput.getText().toString());

                /*Permite establecer comportamiento*/
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK,Intent.FLAG_ACTIVITY_CLEAR_TOP,Intent.FLAG_ACTIVITY_NEW_TASK);

                /*
                * Permite destruir una actividad por completo, y dejando la nueva como principal
                * */
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
//                Snackbar.make(v,
//                        "hola",
//                        Snackbar.LENGTH_LONG).show();


            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(!txtInput.getText().toString().isEmpty())
        outState.putString("valor",txtInput.getText().toString());
//        Log.i("ciclo","onSaveInstanceState "+lblEtiqueta.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lblEtiqueta.setText(savedInstanceState.getString("valor"));
        Log.i("ciclo","onRestoreInstanceState");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Ciclo", "onStart");
    }

    @Override
    protected void onResume () {
        super.onResume();
        Log.i("Ciclo", "onResume");
    }
    @Override
    protected void onPause () {
        super.onPause();
        Log.i("Ciclo", "onPause");
    }
    @Override
    protected void onStop () {
        super.onStop();
        Log.i("Ciclo", "onStop");
    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.i("Ciclo", "onDestroy");
    }


}