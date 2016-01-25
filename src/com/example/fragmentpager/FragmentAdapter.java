package com.example.fragmentpager;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<ResourceDto> _resources;

    private String[] titles = {};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void destroyAllItem(ViewPager pager) {
        // -1が正しいかは要チェックです
        for (int i = 0; i < getCount() - 1; i++) {
            try {
                Object objectobject = this.instantiateItem(pager, i);
                if (objectobject != null)
                    destroyItem(pager, i, objectobject);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

        if (position <= getCount()) {
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();
        }
    }

    @Override
    public Fragment getItem(int index) {
        Bundle args = new Bundle();
        args.putSerializable(SampleFragment.ARGS_RESOURCE, _resources.get(index));
        args.putInt(SampleFragment.ARGS_INDEX, index);
        Fragment fragment = new SampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return this._resources.size();
    }

    public void setResource(List<ResourceDto> resources) {
        this._resources = resources;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
