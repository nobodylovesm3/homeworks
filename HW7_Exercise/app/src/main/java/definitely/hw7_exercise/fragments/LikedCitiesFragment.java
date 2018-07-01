package definitely.hw7_exercise.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

public class LikedCitiesFragment extends Fragment {
    private View view;
    private Cities cities;
    private ArrayList<Cities> citiesList;
    private CitiesViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cities_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new RecyclerViewAdapter(viewModel);

        viewModel = ViewModelProviders.of(this).get(CitiesViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void setCities(final ArrayList<Cities> citiesArrayList) {
//        citiesList = new ArrayList<>();
//        for (int i = 0; i < citiesArrayList.size(); i++) {
//            if (citiesArrayList.get(i).isLiked()) {
//                citiesList.add(citiesArrayList.get(i));
//            }
//        }
//        adapter.addItems(citiesArrayList);
//
//        viewModel.getAllCities().observe(this, new Observer<List<Cities>>() {
//            @Override
//            public void onChanged(@Nullable List<Cities> cities) {
//                adapter.addItems(citiesArrayList);
//            }
//        });
    }


    public LikedCitiesFragment() {
    }
}
