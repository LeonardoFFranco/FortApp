package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.activites.utils.bpElemMock;
import edu.upb.fortapp.ui.activites.utils.bpElemUtils;

public class BattlePassActivity extends AppCompatActivity {
    private Context context;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlepass);
        initViews();
        final List<bpElemMock> battlePassList = bpElemUtils.getBattlePassElements();
        bpListViewAdapter adapter = new bpListViewAdapter(this, battlePassList);
        listview.setAdapter(adapter);
    }
    private void initViews() {
        listview = findViewById(R.id.listViewMyWeapons);
    }
}
