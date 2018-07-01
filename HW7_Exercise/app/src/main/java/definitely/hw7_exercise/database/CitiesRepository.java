package definitely.hw7_exercise.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import definitely.hw7_exercise.ui.Cities;

public class CitiesRepository {
    private CitiesDao citiesDao;
    private LiveData<List<Cities>> allCities;

    CitiesRepository(Application application) {
        RoomDatabaseCities db = RoomDatabaseCities.getDatabase(application);
        citiesDao = db.citiesDao();
        allCities = citiesDao.getAllCities();

    }

    public CitiesDao getCitiesDao() {
        return citiesDao;
    }

    public void setCitiesDao(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
    }

    LiveData<List<Cities>> getAllCities() {
        return allCities;
    }

    public void setAllCities(LiveData<List<Cities>> allCities) {
        this.allCities = allCities;
    }

    public void insert(Cities cities) {
        new InsertAsyncTask(citiesDao).execute(cities);
    }

    public void delete(Cities cities) {
        citiesDao.deleteCity(cities);
    }

    public void deleteAll() {
        new DeleteAsyncTask(citiesDao).execute();
    }

    private static class InsertAsyncTask extends AsyncTask<Cities, Void, Void> {

        private CitiesDao asyncTaskDao;

        InsertAsyncTask(CitiesDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Cities... params) {
            asyncTaskDao.insertCities(params[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Void, Void, Void> {
        private CitiesDao asyncTaskDao;

        DeleteAsyncTask(CitiesDao citiesDao) {
            this.asyncTaskDao = citiesDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAll();
            return null;
        }
    }
}
