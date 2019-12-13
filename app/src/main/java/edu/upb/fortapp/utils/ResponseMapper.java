package edu.upb.fortapp.utils;

import com.google.firebase.auth.FirebaseUser;

import edu.upb.fortapp.models.UserLogged;
import edu.upb.fortapp.models.UserType;

public class ResponseMapper {

    public static UserLogged mapUserToUserLooged(FirebaseUser user) {

        return new UserLogged(user.getEmail(), UserType.REGULAR_USER);
    }
}
