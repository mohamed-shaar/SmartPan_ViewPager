package com.example.smartpan_2_11.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpan_2_11.R;
import com.example.smartpan_2_11.model.ResponseEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private Context context;
    private ArrayList<ResponseEntity> entities;

    public SearchAdapter(Context context, ArrayList<ResponseEntity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        ResponseEntity responseEntity = entities.get(position);
        String title = responseEntity.getTitle();
        String url = responseEntity.getUrl();

        holder.tv_search.setText(title);
        if (TextUtils.isEmpty(url)){
            Picasso.get().load(R.drawable.ic_launcher_background).fit().centerCrop().into(holder.iv_search);
        }
        else {
            Picasso.get().load(url).fit().centerCrop().placeholder(R.drawable.ic_launcher_background).into(holder.iv_search);
        }
    }

    public void filterList(ArrayList<ResponseEntity> filterList){
        entities = filterList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_search;
        public TextView tv_search;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_search = itemView.findViewById(R.id.iv_search);
            tv_search = itemView.findViewById(R.id.tv_search);
        }
    }
}
