package edu.upb.fortapp.repository;

import androidx.lifecycle.LiveData;

import edu.upb.fortapp.models.Base;

public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);


}
