package definitely.hw7_exercise.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import definitely.hw7_exercise.ui.Cities;

@Dao
public interface CitiesDao {

    @Insert
    void insertCities(Cities cities);

    @Delete
    void deleteCity(Cities cities);

    @Update
    void updateCities(ArrayList<Cities> cities);

    @Query("SELECT * from all_cities ORDER BY id ASC")
    LiveData<List<Cities>> getAllCities();

    @Query("DELETE  FROM all_cities")
    void deleteAll();
}
