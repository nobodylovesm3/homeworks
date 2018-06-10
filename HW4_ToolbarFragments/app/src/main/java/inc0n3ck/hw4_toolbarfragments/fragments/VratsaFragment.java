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


public class VratsaFragment extends Fragment {
    private TextView additionalInfo;
    private TextView moreAddInfo;
    private TextView usefulInfo;
    private ImageView picture;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        picture.setImageResource(R.drawable.vratsa);
        usefulInfo.setText(R.string.additional_information_vratsa);
        additionalInfo.setText(R.string.useful_information_vratsa);
        moreAddInfo.setText(R.string.more_add_info_vratsa);


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_vratsa_fragment, container, false);

        additionalInfo = view.findViewById(R.id.txt_additional_info_vr);
        usefulInfo = view.findViewById(R.id.txt_useful_info_vr);
        moreAddInfo = view.findViewById(R.id.txt_more_add_info_vr);

        picture = view.findViewById(R.id.img_city_vr);
        return view;
    }
}
