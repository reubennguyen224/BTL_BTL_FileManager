package com.btl.btl_filemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.btl.btl_filemanager.fragments.DocFragment;
import com.btl.btl_filemanager.fragments.ImageFragment;
import com.btl.btl_filemanager.fragments.VideoFragment;

public class DocManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_manage);

        Toolbar toolbar = findViewById(R.id.toolbar_doc);
        toolbar.setTitle("Tài liệu và các mục khác");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } // đặt nút quay lại

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.biggest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("biggest")).commit();
                break;
            case R.id.last:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("last")).commit();
                break;
            case R.id.oldest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("oldest")).commit();
                break;
            case R.id.smallest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("smallest")).commit();
                break;
            case R.id.atoz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("atoz")).commit();
                break;
            case R.id.ztoa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_doc, new DocFragment("ztoa")).commit();
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