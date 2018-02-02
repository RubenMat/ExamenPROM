package com.example.dm2.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Eltiempo extends AppCompatActivity {

    TextView txtTiempo,txtMedio;
    List<Tiempo> datos = new ArrayList<>();
    Button btnVitoria, btnBilbao,btnDonosti,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eltiempo);

        txtTiempo=(TextView)findViewById(R.id.txtTiempo);
        txtMedio=(TextView)findViewById(R.id.textoMedio);

        btnSalir=(Button)findViewById(R.id.btnSalirTiempo);
        btnVitoria=(Button)findViewById(R.id.btnVitoria);
        btnBilbao=(Button)findViewById(R.id.btnBilbao);
        btnDonosti=(Button)findViewById(R.id.btnDonosti);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnVitoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevaTarea tarea = new NuevaTarea();
                tarea.execute("http://xml.tutiempo.net/xml/8043.xml");
                txtMedio.setText("Tiempo actual en: Vitoria-Gasteiz");
            }
        });

        btnBilbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevaTarea tarea = new NuevaTarea();
                tarea.execute("http://xml.tutiempo.net/xml/8050.xml");
                txtMedio.setText("Tiempo actual en: Bilbao");
            }
        });

        btnDonosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevaTarea tarea = new NuevaTarea();
                tarea.execute("http://xml.tutiempo.net/xml/4917.xml");
                txtMedio.setText("Tiempo actual en: Donostia");

            }
        });
    }

    class NuevaTarea extends AsyncTask<String,Void,Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            RssParserSax parseador = new RssParserSax(params[0]);

            datos = parseador.parse();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            txtTiempo.setText("");
            txtTiempo.append("Hora: " + datos.get(0).getHora());
            txtTiempo.append("\nTemperatura: "+datos.get(0).getTemperatura());
            txtTiempo.append("\nEstado del cielo: "+datos.get(0).getCielo());
        }
    }
}
