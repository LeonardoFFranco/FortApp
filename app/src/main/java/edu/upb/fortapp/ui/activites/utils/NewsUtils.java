package edu.upb.fortapp.ui.activites.utils;

import java.util.ArrayList;
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

public class NewsUtils {
/*
    public static List<Noticia> getNews() {
        return noticias;
    }*/

    public static List<Noticia> getNews() {
         final List<Noticia> noticias = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://firebasestorage.googleapis.com/v0/b/fortapp-e441e.appspot.com/o/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NoticiaAPI noticiaAPI = retrofit.create(NoticiaAPI.class);
        Call<List<Noticia>> call = noticiaAPI.getRoutes(Constants.API_PARAM_ALT);
        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if (!response.isSuccessful()) {
                    return;
                } else {

                    List<Noticia> noticiaList = response.body();
                    for (Noticia not : noticiaList) {
                         noticias.add(new Noticia(not.getUuid(),not.getTitulo(), R.drawable.assault1,not.getFecha(),not.getContenido()));
                    }


                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {

            }
        });
        return noticias;

    }


}
