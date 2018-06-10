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

public class SofiaFragment extends Fragment {
    private TextView additionalInfo;
    private TextView moreAddInfo;
    private TextView usefulInfo;
    private ImageView picture;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        picture.setImageResource(R.drawable.sofia);
        usefulInfo.setText(R.string.additional_information_sofia);
        additionalInfo.setText(R.string.useful_information_sofia);
        moreAddInfo.setText(R.string.more_add_info_sofia);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_sofia_fragment, container, false);

        additionalInfo = view.findViewById(R.id.txt_additional_info_sf);
        usefulInfo = view.findViewById(R.id.txt_useful_info_sf);
        moreAddInfo = view.findViewById(R.id.txt_more_add_info_sf);

        picture = view.findViewById(R.id.img_city_sf);

        return view;
    }
}
