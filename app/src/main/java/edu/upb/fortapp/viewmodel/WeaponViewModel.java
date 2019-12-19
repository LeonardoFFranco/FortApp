package edu.upb.fortapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.fortapp.models.repository.Weapon2;
import edu.upb.fortapp.repository.WeaponRepository;


public class WeaponViewModel extends AndroidViewModel {
    private WeaponRepository repository;
    private LiveData<List<Weapon2>> allWeapons;
    public WeaponViewModel(@NonNull Application application) {
        super(application);
        repository = new WeaponRepository(application);
        allWeapons = repository.getAllWeapons();
    }

    public void  insert (Weapon2 weapon2){
        repository.insert(weapon2);
    }

    public void update(Weapon2 weapon2){
        repository.update(weapon2);
    }

    public void delete(Weapon2 weapon2){
        repository.delete(weapon2);
    }

    public void deleteAllWeapons(){
        repository.deleteAll();
    }

    public LiveData<List<Weapon2>> getAllWeapons(){
        return allWeapons;
    }
}
