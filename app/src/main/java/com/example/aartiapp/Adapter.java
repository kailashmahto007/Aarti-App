package com.example.aartiapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List <ModelClass> modelClassList;

    String title; int image; Context mcontext;int song;
    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
       title=modelClassList.get(position).getTitle();
       image=modelClassList.get(position).getImage();
       mcontext=modelClassList.get(position).getContext();
song=modelClassList.get(position).getSong();
        Glide.with(mcontext)
                .asBitmap()
                .load(image)
                .into(viewHolder.imageView);

       viewHolder.setdata(title);

viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("clicked", modelClassList.get(position).getTitle());

        Toast.makeText(v.getContext(), ""+ modelClassList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(v.getContext(),GalleryShow.class);


        intent.putExtra("image",modelClassList.get(position).getImage());

        intent.putExtra("title",modelClassList.get(position).getTitle());
        intent.putExtra("song",modelClassList.get(position).getSong());
        v.getContext().startActivity(intent);

    }
});

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View parent_layout;
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.titletext);
            imageView=itemView.findViewById(R.id.image_item);
            parent_layout=itemView.findViewById(R.id.parent_layout);
        }



        private void setdata(String title)
        {       textView.setText(title);


        }



    }
    }



