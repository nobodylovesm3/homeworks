package definitely.hw7_exercise.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import definitely.hw7_exercise.ui.Cities;

@Database(entities = {Cities.class}, version = 1, exportSchema = false)
public abstract class RoomDatabaseCities extends RoomDatabase {

    public abstract CitiesDao citiesDao();


    private static RoomDatabaseCities INSTANCE;

    static RoomDatabaseCities getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabaseCities.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseCities.class, "test_database").
                            build();
                }
            }
        }
        return INSTANCE;
    }
}
