package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.repository.api.NoticiaAPI;
import edu.upb.fortapp.ui.activites.utils.Noticia;
import edu.upb.fortapp.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity {
    private Context context;
    private TextView mJsonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        setContentView(R.layout.activity_news2);
        mJsonTxtView = findViewById(R.id.jsonText);
        getNews();
    }

    private void getNews(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://firebasestorage.googleapis.com/v0/b/fortapp-e441e.appspot.com/o/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NoticiaAPI noticiaAPI = retrofit.create(NoticiaAPI.class);
        Call<List<Noticia>> call = noticiaAPI.getRoutes(Constants.API_PARAM_ALT);
        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo:" + response.code());
                    return;
                } else {

                      List<Noticia> noticiaList = response.body();
                      for (Noticia not: noticiaList ){
                          String content = "";
                          content += "NotId" + not.getUuid() + "\n";
                          content += "imagen" + not.getImagen() + "\n";
                          content += "titulo" + not.getTitulo() + "\n";
                          content += "fecha" + not.getFecha() + "\n";
                          content += "Contenido" + not.getContenido() + "\n\n";
                          mJsonTxtView.append(content);

                      }
                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                    mJsonTxtView.setText(t.getMessage());
            }
        });

    }
}
