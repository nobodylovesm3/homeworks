package inc0n3ck.hw4_toolbarfragments.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import inc0n3ck.hw4_toolbarfragments.R;

public class MontanaFragment extends Fragment {
    private TextView additionalInfo;
    private TextView moreAddInfo;
    private TextView usefulInfo;
    private ImageView picture;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        picture.setImageResource(R.drawable.montana);
        usefulInfo.setText(R.string.additional_info_montana);
        additionalInfo.setText(R.string.useful_information_montana);
        moreAddInfo.setText(R.string.more_add_info_montana);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_montana_fragment, container, false);
        additionalInfo = view.findViewById(R.id.txt_additional_info_mn);
        usefulInfo = view.findViewById(R.id.txt_useful_info_mn);
        moreAddInfo = view.findViewById(R.id.txt_more_add_info_mn);

        picture = view.findViewById(R.id.img_city_mn);

        return view;
    }
}
