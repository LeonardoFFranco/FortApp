package edu.upb.fortapp.repository;

import androidx.lifecycle.LiveData;

import edu.upb.fortapp.models.Base;
import edu.upb.fortapp.repository.firebase.FirebaseRepository;

public class Repository implements RepositoryImpl {

    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
    }

    @Override
    public LiveData<Base> login(String email, String password) {
        return FirebaseRepository.getInstance().login(email, password);
    }

}