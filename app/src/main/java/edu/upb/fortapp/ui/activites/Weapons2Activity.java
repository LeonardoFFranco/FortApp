package edu.upb.fortapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.models.WeaponClick;
import edu.upb.fortapp.models.repository.Weapon2;
import edu.upb.fortapp.ui.adapters.WeaponAdapter;
import edu.upb.fortapp.viewmodel.WeaponViewModel;

public class Weapons2Activity  extends AppCompatActivity {

    private WeaponViewModel weaponViewModel;
    private ListView listview;
    private Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons2);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        weaponViewModel = new ViewModelProvider(this).get(WeaponViewModel.class);

        final WeaponAdapter adapter = new WeaponAdapter();

        adapter.setCallback(new WeaponClick() {
            @Override
            public void onclick(Weapon2 weapon2) {
                Intent intent = new Intent(Weapons2Activity.this, WeaponsDetails2.class);
                intent.putExtra(Constants.WEAPON_SELECTED, gson.toJson(weapon2));
                startActivity(intent);
            }
        });

       /* listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weapon weapon = weaponViewModel.get(position);
                Intent intent = new Intent(Weapons2Activity.this, WeaponsDetailsActivity.class);
                intent.putExtra(Constants.WEAPON_SELECTED, gson.toJson(weapon));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        //weaponViewModel = ViewModelProviders.of(this).get(WeaponViewModel.class);

        weaponViewModel.getAllWeapons().observe(this, new Observer<List<Weapon2>>() {
            @Override
            public void onChanged(List<Weapon2> weapon2s) {
                adapter.setWeapon(weapon2s);
            }
        });

    }
}
