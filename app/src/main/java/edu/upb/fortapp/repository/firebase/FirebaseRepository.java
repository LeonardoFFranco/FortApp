package edu.upb.fortapp.repository.firebase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.upb.fortapp.models.Base;
import edu.upb.fortapp.models.Noticias;
import edu.upb.fortapp.repository.Repository;
import edu.upb.fortapp.ui.activites.utils.Noticia;

public class FirebaseRepository {
    private static FirebaseRepository instance;
    private FirebaseAuth auth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceNoticias;
   private List<Noticias> noticias= new ArrayList<>();

   public interface DataStatus{
       void DataIsLoaded(List<Noticias> noticias, List<String> keys);
   }

    public static FirebaseRepository getInstance() {
        if (instance == null) {
            instance = new FirebaseRepository();
        }
        return instance;
    }

    public FirebaseRepository() {
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceNoticias = mDatabase.getReference("noticias");
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            //subscribeToValues("noticias/");
                            Noticias noticia3 = new Noticias("Notas del parche 11.31","No sería un parche propiamente dicho si no se depurasen ciertos errores. Esta es la lista completa de corrección de bugs:\n" +
                                    "\n" +
                                    "Hemos hecho más mejoras con respecto a las caídas de FPS y a los tirones en dispositivos móviles.\n" +
                                    "El botón de disparar/construir ahora sí está disponible cuando se muestra el botón de redespliegue del ala delta en los dispositivos móviles.\n" +
                                    "Se ha corregido un error que impedía a los jugadores salir de la Herramienta de disposición del HUD en dispositivos móviles.\n" +
                                    "Se ha corregido un error en la opción Editar en paredes enemigas.\n" +
                                    "Ahora, el objetivo \"Eliminaciones sin usar la mira\" del desafío ¡A ello! registra el progreso correctamente.\n" +
                                    "Se ha corregido un error en la opción \"Unirse a la fiesta\": \"Te puedes unir a este grupo\" no funcionaba con el mando.\n" +
                                    "La cuenta atrás del cronómetro de la tienda de objetos ya no presenta errores de sincronización para varios jugadores.\n" +
                                    "Se han resuelto los problemas de estabilidad.","10/10/19","Parches");
                            Noticias noticia4 = new Noticias("Fortnite x Star Wars","Fortnite Capítulo 2 recibirá un skin de Kylo Ren. El juego de Epic Games continúa su colaboración con Disney y Star Wars de cara al estreno del Episodio IX.\n" +
                                    "Fortnite Capítulo 2 continúa colaborando con Disney y Star Wars. Tras el evento del pasado 14 de diciembre, en el que se emitió en exclusiva una escena de El Ascenso de Skywalker, se ha filtrado un skin de Kylo Ren, el villano de la nueva trilogía de películas. Este aspecto de personaje llegará en algún punto determinado de la Temporada 1 del nuevo Pase de Batalla.","05/11/19","Eventos");
                            Noticias noticia5 = new Noticias("Festival de Invierno","Arranca el evento de Navidad 2019 en Fortnite Capítulo 2. El 18 de diciembre llegó a Fortnite Battle Royale el Festival de Invierno 2019, y consigo trajo nuevos desafíos. Este evento de Navidad de la Temporada 1 del Pase de Batalla de Fortnite Capítulo 2. ","12/11/19","Eventos");
                            Noticias noticia6 = new Noticias("Pase Anual","Los jugadores hallaron archivos que hacían referencia a un pase anual que incluiría todos los pases de batalla de 2020.\n" +
                                    "No habrá pase anual en Fortnite Battle Royale, al menos no de momento. Epic Games ha reconocido que habían sopesado la posibilidad de introducir esta opción dentro de su modelo de negocio. Sin embargo, en un comunicado que recoge GamesRadar+, la desarrolladora norteamericana ha confirmado que no hay planes de lanzarlo. Como estaba previsto para 2020, no da la impresión de que la idea vaya a llegar a buen puerto finalmente.","23/12/19","Eventos");
                            Noticias noticia7 = new Noticias("Noticia7","Con la llegada del parche 10.30 el 12 de diciembre de 2019 a Fortnite, también ha llegado una opción bastante interesante: la posibilidad de jugar a pantalla partida en PS4 y Xbox One. Fortnite Capítulo 2, el cual aún se encuentra en la Temporada 1 de su Pase de Batalla, se renueva. ","12/12/19","Eventos");
                            setValue("noticias/ntc3",noticia3);
                            setValue("noticias/ntc4",noticia4);
                            setValue("noticias/ntc5",noticia5);
                            setValue("noticias/ntc6",noticia6);
                            setValue("noticias/ntc7",noticia7);


                            results.postValue(new Base(user));
                        } else {
                            results.postValue(new Base("login Failure",
                                    new NullPointerException()));
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        results.postValue(new Base("login.onFailure", e));
                    }
                });
        return results;
    }

    public LiveData<Base> register(String email, String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.createUserWithEmailAndPassword(email, password);
        return results;
    }

    /*public void readNoticias(final FirebaseRepository.DataStatus dataStatus){
        mReferenceNoticias.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FirebaseUser user = auth.getCurrentUser();
                noticias.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Noticias noticia = keyNode.getValue(Noticias.class);
                    noticias.add(noticia);
                }
                dataStatus.DataIsLoaded(noticias,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
*/
    public LiveData<Base> setValue(String path, Object value) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        mDatabase.getReference(path).setValue(value);
        return result;
    }

    public LiveData<Base> subscribeToValues(String path) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        mDatabase.getReference(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String values = new Gson().toJson(dataSnapshot.getValue());
                Log.e("Database", values);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return result;
    }
}
