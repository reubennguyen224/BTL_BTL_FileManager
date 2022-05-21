package com.btl.btl_filemanager;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class FileAdapterBig extends RecyclerView.Adapter<FileViewHolder> {

    private Context context;
    private List<File> file;
    private OnFileSelectedListener listener;

    public FileAdapterBig(Context context, List<File> file, OnFileSelectedListener listener) {
        this.context = context;
        this.file = file;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FileViewHolder(LayoutInflater.from(context).inflate(R.layout.file_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {


        int items = 0; //dem file
        if (file.get(position).isDirectory()){
            File[] files = file.get(position).listFiles();
            for (File singleFile : files){
                if (!singleFile.isHidden()){ //dem file ko bi an
                    items += 1;
                }
            }
        }
        if (file.get(position).getName().toLowerCase().endsWith(".jpeg")){
            holder.imgFileBig.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".jpg")){
            holder.imgFileBig.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".png")){
            holder.imgFileBig.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".pdf")){
            holder.imgFileBig.setImageResource(R.drawable.ic_pdf);
        } else if (file.get(position).getName().toLowerCase().endsWith(".doc")){
            holder.imgFileBig.setImageResource(R.drawable.ic_file);
        } else if (file.get(position).getName().toLowerCase().endsWith(".mp3")){
            holder.imgFileBig.setImageResource(R.drawable.ic_music);
        } else if (file.get(position).getName().toLowerCase().endsWith(".mp4")) {
            holder.imgFileBig.setImageResource(R.drawable.ic_music);
        } else if (file.get(position).getName().toLowerCase().endsWith(".apk")){
            holder.imgFileBig.setImageResource(R.drawable.ic_android);
        } else {
            holder.imgFileBig.setImageResource(R.drawable.folder);
        }

        holder.containerBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFileClicked(file.get(position));
            }
        });

        holder.containerBig.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onFileLongClicked(file.get(position), position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return file.size();
    }
}
