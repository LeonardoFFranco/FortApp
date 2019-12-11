package edu.upb.fortapp.ui.activites;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.fragments.MyDialogFragment;
public class MenuActivity extends AppCompatActivity {

    private Button map;
    private Button news;
    private Button weapons;
    private Button bp;
    private Button itemshop;
    private Button information;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        setContentView(R.layout.activity_menu);
        this.map=findViewById(R.id.button11);
        this.news=findViewById(R.id.button12);
        this.weapons=findViewById(R.id.button13);
        this.bp=findViewById(R.id.button14);
        this.itemshop=findViewById(R.id.button9);
        this.information=findViewById(R.id.button);

        this.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity.class);
                startActivity(intent);
            }
        });
        this.news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsActivity.class);
                startActivity(intent);
            }
        });

        this.weapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WeaponsActivity.class);
                startActivity(intent);
            }
        });
        this.bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BattlePassActivity.class);
                startActivity(intent);
            }
        });

        this.itemshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemShopActivity.class);
                startActivity(intent);
            }
        });
        this.information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                MyDialogFragment dialogFragment = new MyDialogFragment ();
                dialogFragment.show(fm, "Sample Fragment");
            }
        });


    }
}
