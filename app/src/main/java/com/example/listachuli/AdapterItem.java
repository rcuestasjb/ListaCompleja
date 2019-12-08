package com.example.listachuli;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterItem extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Evento> listaEventos;

    //0) AdapterItem tiene que sobre escribir 4 metodos de su clase padre BaseAdapter

    public AdapterItem (Activity activity, ArrayList<Evento> listaEventos) {
        this.activity = activity;
        this.listaEventos = listaEventos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1) Vamos a instanciar el nuestro archivo de diseño Layout
        View miVista = convertView;
        LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        miVista = inf.inflate(R.layout.item_evento, null);

        //2) Obtenemos el evento
        Evento miEvento = listaEventos.get(position);

        //3) Rellenamos los campos con la infomacion del objeto miEvento
        TextView title = (TextView) miVista.findViewById(R.id.titulo);
        title.setText(miEvento.titulo);

        TextView description = (TextView) miVista.findViewById(R.id.descripcion);
        description.setText(miEvento.descripcion);

        TextView hora = (TextView) miVista.findViewById(R.id.hora);
        hora.setText(miEvento.hora);

        TextView dia = (TextView) miVista.findViewById(R.id.dia);
        dia.setText(miEvento.dia);

        //4) Aquí ponemos la imagen (en nuestro caso una por categoria)
        ImageView imagen = (ImageView) miVista.findViewById(R.id.imageView);
        int resID = imagen.getResources().getIdentifier(miEvento.categoria , "drawable", "com.example.listachuli");
        imagen.setImageResource(resID);

        return miVista;
    }

    @Override
    public int getCount() {
        return listaEventos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return listaEventos.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}