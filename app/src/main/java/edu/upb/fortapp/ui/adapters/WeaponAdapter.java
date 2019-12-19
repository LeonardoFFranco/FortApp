package edu.upb.fortapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.models.WeaponClick;
import edu.upb.fortapp.models.repository.Weapon2;


public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponHolder> {
    private List<Weapon2> weapon =  new ArrayList<>();
    private WeaponClick callback;

    @NonNull
    @Override
    public WeaponHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weapon_item,parent,false);
        return new WeaponHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponHolder holder, int position) {
        final Weapon2 curretWeapon = weapon.get(position);
        holder.imageView.setImageResource(curretWeapon.getImage());
        holder.textViewTittle.setText(curretWeapon.getName());
        holder.textViewType.setText(curretWeapon.getType());
        //holder.textViewType.setText(String.valueOf(curretWeapon.getHead()));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback!=null){
                    callback.onclick(curretWeapon);
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return weapon.size();
    }

    public void setWeapon(List<Weapon2> weapons){
        this.weapon = weapons;
        notifyDataSetChanged();
    }

    class WeaponHolder extends  RecyclerView.ViewHolder{
        private TextView textViewTittle;
        private  TextView textViewType;
        private ImageView imageView;

        public WeaponHolder(View itemview){
            super(itemview);
            textViewTittle = itemview.findViewById(R.id.textViewName2);
            textViewType= itemview.findViewById(R.id.textViewType2);
            imageView = itemview.findViewById(R.id.imageViewWeapon2);
        }
    }

    public void setCallback(WeaponClick callback) {
        this.callback = callback;
    }
}
