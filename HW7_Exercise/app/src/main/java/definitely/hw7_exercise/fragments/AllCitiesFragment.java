package definitely.hw7_exercise.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import definitely.hw7_exercise.R;
import definitely.hw7_exercise.adapters.RecyclerViewAdapter;
import definitely.hw7_exercise.database.CitiesViewModel;
import definitely.hw7_exercise.ui.Cities;

public class AllCitiesFragment extends Fragment {
    private Cursor cursor;

    public ArrayList<Cities> getCitiesArrayList() {
        return citiesArrayList;
    }

    public void setCities(ArrayList<Cities> citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }

    private Cities cities;
    private ArrayList<Cities> citiesArrayList;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private View view;
    private CitiesViewModel viewModel;


    public AllCitiesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cities_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);


        adapter = new RecyclerViewAdapter(viewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        buildList();


    }


    public void buildList() {

        cities = new Cities();
        citiesArrayList = new ArrayList<>();
        cities = new Cities(R.drawable.vratsa, "VRATSA", false);
        citiesArrayList.add(cities);
        cities = new Cities(R.drawable.montana, "MONTANA", false);
        citiesArrayList.add(cities);
        cities = new Cities(R.drawable.sofia, "SOFIA", false);
        citiesArrayList.add(cities);
        viewModel = ViewModelProviders.of(this).get(CitiesViewModel.class);
        viewModel.getAllCities().observe(this, new Observer<List<Cities>>() {
            @Override
            public void onChanged(@Nullable List<Cities> cities) {
                adapter.addItems(citiesArrayList);
            }
        });
    }


}

