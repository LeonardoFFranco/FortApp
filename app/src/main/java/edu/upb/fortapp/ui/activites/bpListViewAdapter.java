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
import edu.upb.fortapp.ui.activites.utils.bpElemMock;

public class bpListViewAdapter extends BaseAdapter {
    private Context context;
    private List<bpElemMock> bpList;

    public bpListViewAdapter(Context context, List<bpElemMock> weaponList) {
        this.context = context;
        this.bpList = weaponList;
    }


    @Override
    public int getCount() {
        return this.bpList.size();
    }

    @Override
    public bpElemMock getItem(int position) {
        return this.bpList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.bpList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();


            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.activity_bp, null); //Cual layout y principal o no.

            viewHolder.imageViewBp = vista.findViewById(R.id.imageViewBp);
            viewHolder.textViewNameBp = vista.findViewById(R.id.textViewNameBp);
            viewHolder.textViewTypeBp = vista.findViewById(R.id.textViewTypeBp);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        bpElemMock bpElement = this.bpList.get(position);
        viewHolder.imageViewBp.setImageResource(bpElement.getImagePremio());
        viewHolder.textViewNameBp.setText(bpElement.getNombrePremio());
        viewHolder.textViewTypeBp.setText(String.valueOf(bpElement.getLevel()));
        return vista;
    }

    public static class ViewHolder {
        ImageView imageViewBp;
        TextView textViewNameBp;
        TextView textViewTypeBp;
    }
}
