package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.upb.fortapp.R;

public class BattlePassActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        setContentView(R.layout.activity_battlepass);
    }
}
