package com.example.dm2.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atomico extends AppCompatActivity {

    Button btnInfo,btnVolverAtomico;
    TextView lblSimbolo,lblNumero,lblPeso,lblEbullicion,lblDensidad;
    EditText txtElem;
    String opeRes,simbolo,numero,peso,ebullicion,densidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atomico);

        btnInfo=(Button)findViewById(R.id.btnInfo);
        btnVolverAtomico=(Button)findViewById(R.id.btnVolverAtomico);

        txtElem=(EditText) findViewById(R.id.txtElemento);

        lblSimbolo=(TextView)findViewById(R.id.lblSimbolo);
        lblNumero=(TextView)findViewById(R.id.lblNumero);
        lblPeso=(TextView)findViewById(R.id.lblPeso);
        lblEbullicion=(TextView)findViewById(R.id.lblEbullicion);
        lblDensidad=(TextView)findViewById(R.id.lblDensidad);


        btnVolverAtomico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elemento = txtElem.getText().toString().trim();
                Log.e("ASBDHAGDVS",elemento);

                AsyncPost task = new AsyncPost();
                task.execute(elemento);
            }
        });
    }
    private class AsyncPost extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                HttpURLConnection conn;
                URL url = new URL("http://www.webservicex.net/periodictable.asmx/GetAtomicNumber");

                String param ="ElementName="+ URLEncoder.encode(params[0],"UTF-8");

                Log.e("ASDADS",param);
                conn = (HttpURLConnection)url.openConnection();

                conn.setDoOutput(true);

                conn.setRequestMethod("POST");

                conn.setFixedLengthStreamingMode(param.getBytes().length);
                conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

                PrintWriter out = new PrintWriter(conn.getOutputStream());
                out.print(param);
                out.close();

                String result ="";
                opeRes = "";

                Scanner inStream = new Scanner(conn.getInputStream());

                boolean a=false;
                while (inStream.hasNextLine()) {
                    result = inStream.nextLine();
                    opeRes += result;
                    String[] partes = opeRes.split(" ");
                    for (int i=0;i<partes.length;i++){
                        if(partes[i].contains("Symbol"))
                            simbolo = partes[i].replace("&lt;Symbol&gt;","").replace("&lt;/Symbol&gt;","");
                        else if(partes[i].contains("AtomicNumber"))
                            numero = partes[i].replace("&lt;AtomicNumber&gt;","").replace("&lt;/AtomicNumber&gt;","");
                        else if(partes[i].contains("AtomicWeight"))
                            peso = partes[i].replace("&lt;AtomicWeight&gt;","").replace("&lt;/AtomicWeight&gt;","");
                        else if(partes[i].contains("BoilingPoint"))
                            ebullicion = partes[i].replace("&lt;BoilingPoint&gt;","").replace("&lt;/BoilingPoint&gt;","");
                        else if(partes[i].contains("Density"))
                            densidad = partes[i].replace("&lt;Density&gt;","").replace("&lt;/Density&gt;","");
                    }

                }
            }catch (MalformedURLException e){
                Log.e("A","excepcion MalformedURLException: "+e.getMessage());
            }catch (ProtocolException e){
                Log.e("A","excepcion ProtocolException: "+e.getMessage());
            } catch(IOException e){
                Log.e("A","excepcion IOException: "+e.getMessage());
            }catch (Exception e){
                Log.e("A","excepcion Exception: "+e.getMessage());
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
           lblSimbolo.setText("Simbolo quimico: " + simbolo);
            lblNumero.setText("Numero atomico: " + numero);
            lblPeso.setText("Peso Atomico: " + peso);
            lblEbullicion.setText("Punto de ebullicion: " + ebullicion);
            lblDensidad.setText("Densidad: " + densidad);
        }
    }
}
