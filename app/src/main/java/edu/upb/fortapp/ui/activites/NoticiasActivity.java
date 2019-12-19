package edu.upb.fortapp.ui.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import edu.upb.fortapp.R;
import edu.upb.fortapp.models.Noticias;

public class NoticiasActivity extends AppCompatActivity {
    ListView lv;
    FirebaseListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceStated){
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.activity_news3);

        lv = (ListView)findViewById(R.id.listViewNoticias);
        Query query = FirebaseDatabase.getInstance().getReference("noticias");
        FirebaseListOptions<Noticias> options = new FirebaseListOptions.Builder<Noticias>().setLayout(R.layout.noticias_list_item).setQuery(query,Noticias.class).build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView titulo = v.findViewById(R.id.titulo_txtView);
                TextView descripcion=v.findViewById(R.id.descripcion_textView);
                TextView fecha=v.findViewById(R.id.fecha_textView);
                TextView categoria=v.findViewById(R.id.categoria_textView);

                Noticias noticias = (Noticias) model;
                titulo.setText("Titulo: "+noticias.getTitulo().toString());
                descripcion.setText("Descripcion: "+noticias.getDescripcion().toString());
                fecha.setText("Fecha: "+noticias.getFecha().toString());
                categoria.setText("Categoria: "+noticias.getCategoria().toString());

            }
        };
        lv.setAdapter(adapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}
