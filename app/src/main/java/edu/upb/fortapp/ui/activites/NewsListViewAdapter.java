package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.upb.fortapp.R;

public class NewsListViewAdapter  extends BaseAdapter {
    private Context context;
    private List<Noticia> noticiaList;

    public NewsListViewAdapter(Context context, List<Noticia> noticiaList) {
        this.context = context;
        this.noticiaList = noticiaList;
    }


    @Override
    public int getCount() {
        return this.noticiaList.size();
    }

    @Override
    public Noticia getItem(int position) {
        return this.noticiaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.noticiaList.get(position).getUuid();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.activity_news, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewNews);
            viewHolder.textViewTitulo = vista.findViewById(R.id.textViewTitulo);
            viewHolder.textViewFecha = vista.findViewById(R.id.textViewFecha);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Noticia noticia = this.noticiaList.get(position);
        viewHolder.imageView.setImageResource(noticia.getImagen());
        viewHolder.textViewTitulo.setText(noticia.getTitulo());
        viewHolder.textViewFecha.setText(noticia.getFecha());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewTitulo;
        TextView textViewFecha;
    }
}
