package edu.upb.fortapp.repository.local.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import edu.upb.fortapp.R;
import edu.upb.fortapp.models.repository.Weapon2;
import edu.upb.fortapp.repository.local.dao.WeaponDao;


@Database(entities = {Weapon2.class},version = 1)
public abstract class WeaponDatabase extends RoomDatabase {
    private static WeaponDatabase instance;

    public abstract WeaponDao weaponDao();

    public  static  synchronized WeaponDatabase getInstance(Context context){
        if (instance == null) {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    WeaponDatabase.class,"weapon_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }

    private static  Callback roomCallback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeaponDao weaponDao;
        private PopulateDbAsyncTask(WeaponDatabase db){
            weaponDao = db.weaponDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            weaponDao.insert(new Weapon2("Assault Rifle", R.drawable.assault1, "Common",30,60,"2.5s",5.5));
            weaponDao.insert(new Weapon2("Assault Rifle", R.drawable.assault2, "uncommon",31,62,"2.4s",5.5));
            weaponDao.insert(new Weapon2("Assault Rifle", R.drawable.assault3, "Rare",33,66,"2.3s",5.5));
            weaponDao.insert(new Weapon2("Assault Rifle", R.drawable.assault4, "Epic",35,70,"2.2s",5.5));
            weaponDao.insert(new Weapon2("Assault Rifle", R.drawable.assault5, "Legendary",36,72,"2.1s",5.5));
            weaponDao.insert(new Weapon2("Pump Shotgun", R.drawable.pump1, "Common",70,140,"5.7s",0.7));
            weaponDao.insert(new Weapon2("Pump Shotgun", R.drawable.pump2, "Uncommon",80,160,"5.3s",0.7));
            weaponDao.insert(new Weapon2("Pump Shotgun", R.drawable.pump3, "Rare",90,180,"4.8s",0.7));
            weaponDao.insert(new Weapon2("Pump Shotgun", R.drawable.pump4, "Epic",100,200,"4.4s",0.7));
            weaponDao.insert(new Weapon2("Pump Shotgun", R.drawable.pump5, "Legendary",110,220,"4.0s",0.7));
            weaponDao.insert(new Weapon2("Burst Assault Rifle", R.drawable.burst1, "Common",27,54,"2.9s",2.25));
            weaponDao.insert(new Weapon2("Burst Assault Rifle", R.drawable.burst2, "Uncommon",29,58,"2.7s",2.25));
            weaponDao.insert(new Weapon2("Burst Assault Rifle", R.drawable.burst3, "Rare",30,60,"2.6s",2.25));
            weaponDao.insert(new Weapon2("Burst Assault Rifle", R.drawable.burst4, "Epic",32,64,"2.5s",2.25));
            weaponDao.insert(new Weapon2("Burst Assault Rifle", R.drawable.burst5, "Legendary",33,66,"2.3s",2.25));
            weaponDao.insert(new Weapon2("Bolt-action Sniper Rifle", R.drawable.bolt1, "Uncommon",100,250,"3.2s",0.33));
            weaponDao.insert(new Weapon2("Bolt-action Sniper Rifle", R.drawable.bolt2, "Rare",105,262,"3.0s",0.33));
            weaponDao.insert(new Weapon2("Bolt-action Sniper Rifle", R.drawable.bolt3, "Epic",110,275,"2.3s",0.33));
            weaponDao.insert(new Weapon2("Bolt-action Sniper Rifle", R.drawable.bolt4, "Legendary",116,290,"2.5s",0.33));
            weaponDao.insert(new Weapon2("Rocket Launcher", R.drawable.rpg1, "Uncommon",85,85,"4.1s",0.75));
            weaponDao.insert(new Weapon2("Rocket Launcher", R.drawable.rpg2, "Rare",100,100,"3.6s",0.75));
            weaponDao.insert(new Weapon2("Rocket Launcher", R.drawable.rpg3, "Epic",115,115,"3.1s",0.75));
            weaponDao.insert(new Weapon2("Rocket Launcher", R.drawable.rpg4, "Legendary",130,130,"2.5s",0.75));
            weaponDao.insert(new Weapon2("Pistol", R.drawable.pistol1, "Common",24,48,"1.5s",6.75));
            weaponDao.insert(new Weapon2("Pistol", R.drawable.pistol2, "Uncommon",25,50,"1.5s",6.75));
            weaponDao.insert(new Weapon2("Pistol", R.drawable.pistol3, "Rare",26,52,"1.4s",6.75));
            weaponDao.insert(new Weapon2("Pistol", R.drawable.pistol4, "Epic",28,56,"1.4s",6.75));
            weaponDao.insert(new Weapon2("Pistol", R.drawable.pistol5, "Legendary",29,58,"1.3s",5.5));
            weaponDao.insert(new Weapon2("Grenade", R.drawable.grenade1, "Common",100,100,"-",0.0));
            weaponDao.insert(new Weapon2("Tactical Shotgun", R.drawable.tactica1, "Common",71,142,"6.3s",1.5));
            weaponDao.insert(new Weapon2("Tactical Shotgun", R.drawable.tactica2, "Uncommon",75,150,"6.0s",1.5));
            weaponDao.insert(new Weapon2("Tactical Shotgun", R.drawable.tactica3, "Rare",79,158,"5.7s",1.5));
            weaponDao.insert(new Weapon2("Tactical Shotgun", R.drawable.tactica4, "Epic",83,166,"5.4s",1.5));
            weaponDao.insert(new Weapon2("Tactical Shotgun", R.drawable.tactica5, "Legendary",87,174,"5.1s",1.5));

            return null;
        }
    }
}