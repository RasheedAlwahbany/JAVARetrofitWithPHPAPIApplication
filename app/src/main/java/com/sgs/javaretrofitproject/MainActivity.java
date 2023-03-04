package com.sgs.javaretrofitproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.sgs.javaretrofitproject.API.APIClient;
import com.sgs.javaretrofitproject.API.DataServiceRow;
import com.sgs.javaretrofitproject.API.RetrofitClass;
import com.sgs.javaretrofitproject.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RecyclerView list;
    APIClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NewsManager.class));
            }
        });

        client=RetrofitClass.getInstance().create(APIClient.class);
        DataServiceRow row=new DataServiceRow("all");
        Call<DataServiceRow> data=client.getData("all");
        data.enqueue(new Callback<DataServiceRow>() {
            @Override
            public void onResponse(Call<DataServiceRow> call, Response<DataServiceRow> response) {
                if(response.body().getData().size()>0)
                    fillRecyclerData(response.body().getData());
                else
                    Log.e("ResponseOfAPI","There is no data in array");
            }

            @Override
            public void onFailure(Call<DataServiceRow> call, Throwable t) {
                Log.e("ResponseOfAPI",t.getCause().toString());

            }
        });
    }

    public void fillRecyclerData(List<DataServiceRow> listArray){
        list=findViewById(R.id.rview_list);
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(MainActivity.this,listArray);
        list.setAdapter(adapter);
    }
}