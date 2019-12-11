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

public class WeaponsListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Weapon> weaponList;

    public WeaponsListViewAdapter(Context context, List<Weapon> weaponList) {
        this.context = context;
        this.weaponList = weaponList;
    }


    @Override
    public int getCount() {
        return this.weaponList.size();
    }

    @Override
    public Weapon getItem(int position) {
        return this.weaponList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.weaponList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.activity_weapons, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewWeapon);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            viewHolder.textViewType = vista.findViewById(R.id.textViewType);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Weapon weapon = this.weaponList.get(position);
        viewHolder.imageView.setImageResource(weapon.getImage());
        viewHolder.textViewName.setText(weapon.getName());
        viewHolder.textViewType.setText(weapon.getType());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}

