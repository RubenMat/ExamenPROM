package com.example.dm2.myapplication;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Multimedia extends AppCompatActivity {

    Spinner spinner;
    MediaPlayer mp;
    Button btnVolverMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        btnVolverMulti=(Button)findViewById(R.id.btnVolverMulti);

        spinner=(Spinner)findViewById(R.id.spinAnimales);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.animales, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);


        btnVolverMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                        switch (adapterView.getSelectedItem().toString()){
                            case "Burro":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.burro);
                                mp.start();
                                break;
                            case "Donkey":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.burro);
                                mp.start();
                                break;
                            case "Caballo":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.caballos);
                                mp.start();
                                break;
                            case "Horse":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.caballos);
                                mp.start();
                                break;
                            case "Cabra":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.cabra);
                                mp.start();
                                break;
                            case "Goat":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.cabra);
                                mp.start();
                                break;
                            case "Gallina":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gallina);
                                mp.start();
                                break;
                            case "Chicken":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gallina);
                                mp.start();
                                break;
                            case "Gallo":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gallo);
                                mp.start();
                                break;
                            case "Cock":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gallo);
                                mp.start();
                                break;
                            case "Gato":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gato);
                                mp.start();
                                break;
                            case "Cat":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.gato);
                                mp.start();
                                break;
                            case "Oveja":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.ovejas);
                                mp.start();
                                break;
                            case "Sheep":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.ovejas);
                                mp.start();
                                break;
                            case "Vaca":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.vaca);
                                mp.start();
                                break;
                            case "Cow":
                                mp = MediaPlayer.create(getApplicationContext(),R.raw.vaca);
                                mp.start();
                                break;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
    }
}
