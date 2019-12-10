package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.upb.fortapp.R;

public class MenuActivity extends AppCompatActivity {

    private Button map;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        setContentView(R.layout.activity_menu);
        this.map=findViewById(R.id.button11);

        this.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
