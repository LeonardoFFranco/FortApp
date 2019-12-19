package edu.upb.fortapp.ui.activites;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import edu.upb.fortapp.R;
import edu.upb.fortapp.models.repository.Weapon2;

public class WeaponsDetails2 extends AppCompatActivity {

    private ImageView weaponImage;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typeTextView;
    private TextView damageTextView;
    private TextView headTextView;
    private TextView reloadTextView;
    private TextView fireTextView;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons_details2);
        initViews();

        //Weapon2 weapon =

        Weapon2 weapon = this.gson.fromJson(getIntent().getStringExtra(Constants.WEAPON_SELECTED), Weapon2.class);

        fillWeaponData(weapon);
    }

    // Esto ya saben!
    private void initViews() {
        this.weaponImage = findViewById(R.id.imageView2);
        this.nameTextView = findViewById(R.id.nameTextView2);
        this.typeTextView = findViewById(R.id.typeTextView2);
        this.damageTextView = findViewById(R.id.damageTextView2);
        this.headTextView = findViewById(R.id.headTextView2);
        this.reloadTextView = findViewById(R.id.reloadTextView2);
        this.fireTextView = findViewById(R.id.fireTextView2);
    }

    private void fillWeaponData(Weapon2 weapon) {
        this.weaponImage.setImageResource(weapon.getImage());
        this.nameTextView.setText(weapon.getName());
        this.typeTextView.setText(weapon.getType());
        this.damageTextView.setText(String.valueOf(weapon.getDamage()));
        this.headTextView.setText(String.valueOf(weapon.getHead()));
        this.reloadTextView.setText(weapon.getReload());
        this.fireTextView.setText(String.valueOf(weapon.getFireRate()));
    }
}

