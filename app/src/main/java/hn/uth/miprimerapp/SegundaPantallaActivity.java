package hn.uth.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SegundaPantallaActivity extends AppCompatActivity {

    TextView txwEtiquita1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        txwEtiquita1=findViewById(R.id.txwEtiqueta1);

        String valorRecibido=getIntent().getStringExtra("valor");
        txwEtiquita1.setText(valorRecibido);

    }



}