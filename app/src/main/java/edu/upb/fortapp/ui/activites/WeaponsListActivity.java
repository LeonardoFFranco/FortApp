package edu.upb.fortapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.activites.utils.Weapon;
import edu.upb.fortapp.ui.activites.utils.WeaponsUtils;

public class WeaponsListActivity  extends AppCompatActivity {
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);
        initViews();
        final List<Weapon> weaponList = WeaponsUtils.getWeapons();
        WeaponsListViewAdapter adapter = new WeaponsListViewAdapter(this, weaponList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weapon weapon = weaponList.get(position);
                Intent intent = new Intent(WeaponsListActivity.this, WeaponsDetailsActivity.class);
                intent.putExtra(Constants.WEAPON_SELECTED, gson.toJson(weapon));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyWeapons);
    }


}

