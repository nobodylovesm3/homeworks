package inc0n3ck.hw4_toolbarfragments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import inc0n3ck.hw4_toolbarfragments.fragments.MontanaFragment;
import inc0n3ck.hw4_toolbarfragments.fragments.SofiaFragment;
import inc0n3ck.hw4_toolbarfragments.fragments.VratsaFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                VratsaFragment vratsaFragment = new VratsaFragment();
                return vratsaFragment;
            case 1:
                SofiaFragment sofiaFragment = new SofiaFragment();
                return sofiaFragment;
            case 2:
                MontanaFragment montanaFragment = new MontanaFragment();
                return montanaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
