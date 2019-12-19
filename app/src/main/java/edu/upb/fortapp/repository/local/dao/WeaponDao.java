package edu.upb.fortapp.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.upb.fortapp.models.repository.Weapon2;


@Dao
public interface WeaponDao {
    @Insert
    void insert(Weapon2 weapon2);

    @Update
     void update(Weapon2 weapon2);

    @Delete
    void delete(Weapon2 weapon2);

    @Query("DELETE FROM  weapon_table")
    void deleteAllWeapons();

    @Query("SELECT * FROM weapon_table")
    LiveData<List<Weapon2>> getAllWeapons();
}
