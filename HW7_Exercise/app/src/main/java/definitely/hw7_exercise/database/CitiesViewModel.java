package definitely.hw7_exercise.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import definitely.hw7_exercise.ui.Cities;

public class CitiesViewModel extends AndroidViewModel {
    private CitiesRepository repository;
    private LiveData<List<Cities>> allCities;


    public CitiesViewModel(@NonNull Application application) {
        super(application);
        repository = new CitiesRepository(application);
        allCities = repository.getAllCities();
    }

    public LiveData<List<Cities>> getAllCities() {
        return allCities;
    }


    public void insert(Cities cities, int position) {
        repository.insert(cities);
    }

    public void delete(Cities cities, int position) {
        repository.delete(cities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
