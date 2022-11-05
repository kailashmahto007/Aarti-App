package com.example.aartiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        List <ModelClass> modelClassList=new ArrayList<>();

        modelClassList.add(new ModelClass(this, R.drawable.ganesh, "Ganesh", R.raw.ganesh));
        modelClassList.add(new ModelClass(this,R.drawable.laxmi,"Laxmi",R.raw.omjailaxmi));
        modelClassList.add(new ModelClass(this,R.drawable.saraswati,"Saraswati",R.raw.jaisaraswatimata));
        modelClassList.add(new ModelClass(this,R.drawable.shiv,"Shiv",R.raw.omjaishiv));
        modelClassList.add(new ModelClass(this,R.drawable.santoshimaa,"Santoshi",R.raw.santoshimata));
        modelClassList.add(new ModelClass(this,R.drawable.hanuman,"Hanuman",R.raw.hanuman));
        modelClassList.add(new ModelClass(this,R.drawable.suryadev,"Suryadev",R.raw.surya));
        modelClassList.add(new ModelClass(this,R.drawable.ram,"Ram",R.raw.ram));

        Adapter adapter=new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);


    }
}