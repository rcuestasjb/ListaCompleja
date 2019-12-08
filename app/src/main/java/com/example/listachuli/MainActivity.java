package com.example.listachuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import com.google.gson.Gson;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

//1) Definicion de la clase evento; esta clase la utilizaremos para rellenar una lista
class Evento {
    public String categoria;
    public String descripcion;
    public String dia;
    public String hora;
    public String id;
    public String titulo;
    public Integer valoracion;

    public Evento(String titulo) {
        this.titulo = titulo;
    }
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //1) Creación de la activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Obtenemos el id del list View (con el id definido en el layout), mas tarde la rellenaremos
        ListView listView = (ListView) findViewById(R.id.listViewEventos);

        //3) Vamos a leer el fichero lista json del a carpeta de assets
        String json ="";
        try {
            InputStream stream = getAssets().open("lista.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json  = new String(buffer);
        } catch (Exception e) { }

        //4) En el string json ahora tenemos el listado como texto, en la siguente linea vamos a parsear
        //el string y convertirlo en una Arraylist de objetos eventos
        ArrayList<Evento> listaEventos  = new ArrayList<Evento>(Arrays.asList(new Gson().fromJson(json, Evento[].class)));

        //5) Instanciamos nuestroAdapter item
        AdapterItem adapter = new AdapterItem(this, listaEventos);
        listView.setAdapter(adapter);

    }
}
