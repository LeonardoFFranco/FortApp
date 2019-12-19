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
                            Noticias noticia3 = new Noticias("Noticia3","Descripcion","10/10/19","Eventos");
                            Noticias noticia4 = new Noticias("Noticia4","Descripcion4","05/11/19","Eventos");
                            Noticias noticia5 = new Noticias("Noticia5","Descripcion5","12/11/19","Eventos");
                            Noticias noticia6 = new Noticias("Noticia6","Descripcion6","23/12/19","Eventos");
                            Noticias noticia7 = new Noticias("Noticia7","Descripcion7","12/12/19","Eventos");
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
