package com.btl.btl_filemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.btl.btl_filemanager.fragments.DownloadFragment;
import com.btl.btl_filemanager.fragments.ImageFragment;

public class DownloadManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manage);

        Toolbar toolbar = findViewById(R.id.toolbar_download);
        toolbar.setTitle("Tải xuống");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.biggest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("biggest")).commit();
                break;
            case R.id.last:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("last")).commit();
                break;
            case R.id.oldest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("oldest")).commit();
                break;
            case R.id.smallest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("smallest")).commit();
                break;
            case R.id.atoz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("atoz")).commit();
                break;
            case R.id.ztoa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_download, new DownloadFragment("ztoa")).commit();
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