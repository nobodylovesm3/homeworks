package definitely.hw7_exercise.adapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import definitely.hw7_exercise.R;

import definitely.hw7_exercise.database.CitiesViewModel;
import definitely.hw7_exercise.ui.Cities;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Cities> citiesArrayList;

    private CitiesViewModel citiesViewModel;


    public RecyclerViewAdapter(CitiesViewModel citiesViewModel) {
        this.citiesArrayList = new ArrayList<>();
        this.citiesViewModel = citiesViewModel;
    }

    public void addItems(ArrayList<Cities> cities) {
        this.citiesArrayList = cities;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cities_ui, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Cities currentCity = citiesArrayList.get(position);

        holder.imageView.setImageResource(citiesArrayList.get(position).getPicture());
        holder.textView.setText(citiesArrayList.get(position).getAdditInfo());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!currentCity.isLiked()) {
                    currentCity.setIsLiked(true);
                    holder.button.setText("Unlike");

                    citiesViewModel.insert(currentCity, 5);


                } else if (currentCity.isLiked()) {
                    currentCity.setIsLiked(false);
                    holder.button.setText("Like");

                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return citiesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        Button button;


        public ViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.img_city);
            textView = itemView.findViewById(R.id.txt_useful_info);
            button = itemView.findViewById(R.id.btn_like);
        }
    }
}
