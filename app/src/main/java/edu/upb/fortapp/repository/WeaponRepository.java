package edu.upb.fortapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.fortapp.models.repository.Weapon2;
import edu.upb.fortapp.repository.local.dao.WeaponDao;
import edu.upb.fortapp.repository.local.db.WeaponDatabase;


public class WeaponRepository {
    private WeaponDao weaponDao;
    private LiveData<List<Weapon2>> allWeapons;

    public WeaponRepository (Application application){
        WeaponDatabase database = WeaponDatabase.getInstance(application);
        weaponDao = database.weaponDao();
        allWeapons = weaponDao.getAllWeapons();
    }


    public void insert (Weapon2 weapon2){
        new InsertWeaponAsyncTask(weaponDao).execute(weapon2);

    }
    public void update (Weapon2 weapon2){
       new UpdateWeaponAsyncTask(weaponDao).execute(weapon2);

    }

    public void delete (Weapon2 weapon2){
        new DeleteWeaponAsyncTask(weaponDao).execute(weapon2);

    }

    public void deleteAll (){

        new DeleteAllWeaponAsyncTask(weaponDao).execute();

    }

    public LiveData<List<Weapon2>> getAllWeapons (){
        return allWeapons;
    }

    private static class  InsertWeaponAsyncTask extends AsyncTask<Weapon2,Void,Void> {
        private WeaponDao weaponDao;

        private InsertWeaponAsyncTask(WeaponDao weaponDao){
            this.weaponDao = weaponDao;
        }
        @Override
        protected Void doInBackground(Weapon2... weapon2s){
            weaponDao.insert(weapon2s[0]);
            return null;
        }
    }

    private static class  UpdateWeaponAsyncTask extends AsyncTask<Weapon2,Void,Void> {
        private WeaponDao weaponDao;

        private UpdateWeaponAsyncTask(WeaponDao weaponDao){
            this.weaponDao = weaponDao;
        }
        @Override
        protected Void doInBackground(Weapon2... weapon2s){
            weaponDao.update(weapon2s[0]);
            return null;
        }
    }

    private static class  DeleteWeaponAsyncTask extends AsyncTask<Weapon2,Void,Void> {
        private WeaponDao weaponDao;

        private DeleteWeaponAsyncTask(WeaponDao weaponDao){
            this.weaponDao = weaponDao;
        }
        @Override
        protected Void doInBackground(Weapon2... weapon2s){
            weaponDao.delete(weapon2s[0]);
            return null;
        }
    }

    private static class  DeleteAllWeaponAsyncTask extends AsyncTask<Void,Void,Void> {
        private WeaponDao weaponDao;

        private DeleteAllWeaponAsyncTask(WeaponDao weaponDao){
            this.weaponDao = weaponDao;
        }
        @Override
        protected Void doInBackground(Void... voids){
            weaponDao.deleteAllWeapons();
            return null;
        }
    }




}
