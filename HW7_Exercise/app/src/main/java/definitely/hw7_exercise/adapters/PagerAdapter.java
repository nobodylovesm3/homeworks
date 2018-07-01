package definitely.hw7_exercise.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import definitely.hw7_exercise.fragments.AllCitiesFragment;
import definitely.hw7_exercise.fragments.LikedCitiesFragment;
import definitely.hw7_exercise.ui.Cities;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;
    private AllCitiesFragment allCitiesFragment;
    private LikedCitiesFragment likedCitiesFragment;


    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        allCitiesFragment = new AllCitiesFragment();
        likedCitiesFragment = new LikedCitiesFragment();


    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return getAllCitiesFragment();
            case 1:

                return getLikedCitiesFragment();
            default:

                return null;
        }
    }

    public Fragment getAllCitiesFragment() {
        if (allCitiesFragment == null) {
            allCitiesFragment = new AllCitiesFragment();

        }
        return allCitiesFragment;
    }

    public Fragment getLikedCitiesFragment() {
        if (likedCitiesFragment == null) {
            likedCitiesFragment = new LikedCitiesFragment();
        }
        return likedCitiesFragment;
    }


    @Override
    public int getCount() {
        return numberOfTabs;
    }

    public void setCities(ArrayList<Cities> cities) {
        if (allCitiesFragment != null) {
            allCitiesFragment.setCities(cities);
        }

        if (likedCitiesFragment != null) {
            likedCitiesFragment.setCities(cities);
        }
    }

}
