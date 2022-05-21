package com.btl.btl_filemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.btl.btl_filemanager.fragments.ImageFragment;
import com.btl.btl_filemanager.fragments.MusicFragment;
import com.btl.btl_filemanager.fragments.VideoFragment;

public class MusicManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_manage);

        Toolbar toolbar = findViewById(R.id.toolbar_music);
        toolbar.setTitle("Âm thanh");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.biggest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("biggest")).commit();
                break;
            case R.id.last:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("last")).commit();
                break;
            case R.id.oldest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("oldest")).commit();
                break;
            case R.id.smallest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("smallest")).commit();
                break;
            case R.id.atoz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("atoz")).commit();
                break;
            case R.id.ztoa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_music, new MusicFragment("ztoa")).commit();
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