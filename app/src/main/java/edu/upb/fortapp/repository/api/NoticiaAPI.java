package edu.upb.fortapp.repository.api;

import java.util.List;

import edu.upb.fortapp.ui.activites.utils.Noticia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NoticiaAPI {
    @GET("api%2Fnoticias2.json")
    //https://firebasestorage.googleapis.com/v0/b/fortapp-e441e.appspot.com/o/
    Call<List<Noticia>> getRoutes(@Query("alt") String alt);
}