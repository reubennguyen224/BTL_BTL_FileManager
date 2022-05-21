package com.btl.btl_filemanager;

import static android.app.ActionBar.NAVIGATION_MODE_TABS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.btl.btl_filemanager.fragments.ImageFragment;

import java.io.File;
import java.util.ArrayList;

public class ImageManage extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_manage);

        Toolbar toolbar = findViewById(R.id.toolbar_image);
        toolbar.setTitle("Hình ảnh");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //getSupportActionBar().newTab().setText("Download")

        /* ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Download").setTabListener(new TabListener<ImageFragment>(this, "Download", ImageFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Others").setTabListener(new TabListener<ImageFragment>(this, "Others", ImageFragment.class));
        actionBar.addTab(tab); */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.biggest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("biggest")).commit();
                break;
            case R.id.last:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("last")).commit();
                break;
            case R.id.oldest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("oldest")).commit();
                break;
            case R.id.smallest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("smallest")).commit();
                break;
            case R.id.atoz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("atoz")).commit();
                break;
            case R.id.ztoa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_image, new ImageFragment("ztoa")).commit();
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sort, menu);

        return true;
    }
}