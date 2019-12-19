package edu.upb.fortapp.ui.activites;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.activites.utils.Weapon;

public class WeaponsDetailsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_weapon_details);
        initViews();

        Weapon weapon = this.gson.fromJson(getIntent().getStringExtra(Constants.WEAPON_SELECTED), Weapon.class);

        fillWeaponData(weapon);
    }

    // Esto ya saben!
    private void initViews() {
        this.weaponImage = findViewById(R.id.imageView);
        this.nameTextView = findViewById(R.id.nameTextView);
        this.typeTextView = findViewById(R.id.typeTextView);
        this.damageTextView = findViewById(R.id.damageTextView);
        this.headTextView = findViewById(R.id.headTextView);
        this.reloadTextView = findViewById(R.id.reloadTextView);
        this.fireTextView = findViewById(R.id.fireTextView);
    }

    private void fillWeaponData(Weapon weapon) {
        this.weaponImage.setImageResource(weapon.getImage());
        this.nameTextView.setText(weapon.getName());
        this.typeTextView.setText(weapon.getType());
        this.damageTextView.setText(String.valueOf(weapon.getDamage()));
        this.headTextView.setText(String.valueOf(weapon.getHead()));
        this.reloadTextView.setText(weapon.getReload());
        this.fireTextView.setText(String.valueOf(weapon.getFireRate()));
    }
}
