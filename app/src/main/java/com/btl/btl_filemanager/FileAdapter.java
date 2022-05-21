package com.btl.btl_filemanager;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> implements Filterable {

    private Context context;
    private List<File> file;
    private List<File> arrayList = new ArrayList<>();
    private OnFileSelectedListener listener;

    public FileAdapter(Context context, List<File> file, OnFileSelectedListener listener) {
        this.context = context;
        this.file = file;
        this.listener = listener;
        this.arrayList = new ArrayList<>(file);
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FileViewHolder(LayoutInflater.from(context).inflate(R.layout.file_container_small, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        holder.tvName.setText(file.get(position).getName());
        holder.tvName.setSelected(true);

        int items = 0; //dem file
        if (file.get(position).isDirectory()){
            File[] files = file.get(position).listFiles();
            for (File singleFile : files){
                if (!singleFile.isHidden()){ //dem file ko bi an
                    items += 1;
                }
            }
            holder.tvSize.setText(String.valueOf(items) + " Files");
        } else {
            holder.tvSize.setText(Formatter.formatShortFileSize(context, file.get(position).length()));
        }
        if (file.get(position).getName().toLowerCase().endsWith(".jpeg")){
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".jpg")){
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".png")){
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".pdf")){
            holder.imgFile.setImageResource(R.drawable.ic_pdf);
        } else if (file.get(position).getName().toLowerCase().endsWith(".doc")){
            holder.imgFile.setImageResource(R.drawable.ic_file);
        } else if (file.get(position).getName().toLowerCase().endsWith(".txt")){
            holder.imgFile.setImageResource(R.drawable.ic_file);
        } else if (file.get(position).getName().toLowerCase().endsWith(".mp3")){
            holder.imgFile.setImageResource(R.drawable.ic_music);
        } else if (file.get(position).getName().toLowerCase().endsWith(".mp4")) {
            holder.imgFile.setImageResource(R.drawable.ic_music);
        } else if (file.get(position).getName().toLowerCase().endsWith(".apk")){
            holder.imgFile.setImageResource(R.drawable.ic_android);
        } else {
            holder.imgFile.setImageResource(R.drawable.folder);
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFileClicked(file.get(position));
            }
        });

        holder.container.setOnLongClickListener(new View.OnLongClickListener() {
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

    /*public Filter filter(String query){
        query = query.toLowerCase();
        //Collections.copy(arrayList, file);
        //file.clear();
        if (query.length() == 0){
            arrayList.addAll(file);
        } else {
            arrayList = new ArrayList<>();
            for (File singleFile: file){
                if (singleFile.getName().toLowerCase().contains(query)) {
                    arrayList.add(singleFile);
                }
            }
        }
        notifyDataSetChanged();
    }*/

    Filter filter = new Filter() {

        //run on background
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<File> filteredList = new ArrayList<>();
            if (charSequence.toString().isEmpty()){
                filteredList.addAll(arrayList);
            } else {
                for (File singleFile : arrayList){
                    if (singleFile.getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(singleFile);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }
        //run on ui
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            file.clear();
            file.addAll((Collection<? extends File>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }
}
