package com.example.dm2.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSalir,btnTiempo,btnAtomico,btnMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnTiempo=(Button)findViewById(R.id.btnTiempo);
        btnAtomico=(Button)findViewById(R.id.btnAtomicos);
        btnMedia=(Button)findViewById(R.id.btnMultimedia);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this,Eltiempo.class);
                startActivity(intento);
            }
        });

        btnAtomico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this,Atomico.class);
                startActivity(intento);
            }
        });

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this,Multimedia.class);
                startActivity(intento);
            }
        });
    }
}
