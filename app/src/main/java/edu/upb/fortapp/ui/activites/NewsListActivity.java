package edu.upb.fortapp.ui.activites;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.activites.utils.NewsUtils;
import edu.upb.fortapp.ui.activites.utils.Noticia;

public class NewsListActivity  extends AppCompatActivity {
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        initViews();
        final List<Noticia> noticiaList = NewsUtils.getNews();
        NewsListViewAdapter adapter = new NewsListViewAdapter(this, noticiaList);
        /*
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weapon weapon = weaponList.get(position);
                Intent intent = new Intent(WeaponsListActivity.this, WeaponsDetailsActivity.class);
                intent.putExtra(Constants.WEAPON_SELECTED, gson.toJson(weapon));
                startActivity(intent);
            }
        });*/
        listview.setAdapter(adapter);
    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyNews);
    }


}


