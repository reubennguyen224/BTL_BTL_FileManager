package com.btl.btl_filemanager;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TabListener<T extends Fragment> implements ActionBar.TabListener {

    private Fragment imageFragment;
    private final Activity imageManage;
    private final String mtag;
    private final Class<T> mClass;

    public TabListener(Activity imageManage, String mtag, Class<T> mClass) {
        this.imageManage = imageManage;
        this.mtag = mtag;
        this.mClass = mClass;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (imageFragment == null){
            imageFragment = Fragment.instantiate(imageManage, mClass.getName());
            ft.add(android.R.id.content, imageFragment, mtag);
        } else {
            ft.attach(imageFragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        if (imageFragment != null){
            ft.detach(imageFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
