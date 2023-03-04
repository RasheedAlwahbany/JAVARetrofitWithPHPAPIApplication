package com.sgs.javaretrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sgs.javaretrofitproject.API.APIClient;
import com.sgs.javaretrofitproject.API.DataServiceRow;
import com.sgs.javaretrofitproject.API.RetrofitClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsManager extends AppCompatActivity {
    public TextView id,name,description;
    RadioButton add,update;
    ImageView save;
    APIClient client;
    String manager,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_manager);
        id=findViewById(R.id.txtv_news_id);
        name=findViewById(R.id.txtv_news_name);
        description=findViewById(R.id.txtv_news_description);
        add=findViewById(R.id.rdbtn_news_add);
        update=findViewById(R.id.rdbtn_news_update);
        save=findViewById(R.id.imgv_news_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add.isChecked())
                    manager="add";
                else if(update.isChecked())
                    manager="update";
                else
                    manager="add";
                if(!manager.trim().equals("")&&!manager.trim().matches("")) {
                    if(!name.getText().toString().trim().equals("")&&!name.getText().toString().trim().matches("")&&!description.getText().toString().trim().equals("")&&!description.getText().toString().trim().matches("")){
                        if(manager.equals("add"))
                            SaveData(manager,0,name.getText().toString(),description.getText().toString());
                        else{
                            if(!id.getText().toString().trim().equals("")&&!id.getText().toString().trim().matches(""))
                            SaveData(manager,Integer.parseInt(id.getText().toString()),name.getText().toString(),description.getText().toString());
                        }
                    }
                }
            }
        });
    }

    public void SaveData(String type,Integer id,String name,String description){
        client= RetrofitClass.getInstance().create(APIClient.class);
        Call<DataServiceRow> data =client.ManageNews(type,id,name,description);
        ProgressDialog dialog=new ProgressDialog(NewsManager.this);
        dialog.setTitle("Operation on progress");
        dialog.setMessage("Your operation under process...");
        dialog.setCancelable(false);
        dialog.show();
        data.enqueue(new Callback<DataServiceRow>() {
            @Override
            public void onResponse(Call<DataServiceRow> call, Response<DataServiceRow> response) {
                dialog.dismiss();
                if(response.body()!=null) {
                    message = response.body().getResponse();
                    NewsManager.this.id.setText("");
                    NewsManager.this.name.setText("");
                    NewsManager.this.description.setText("");
                }else
                    message="Operation error";
                Log.e("ResponceOFManager",message);
                Toast.makeText(NewsManager.this, ""+message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DataServiceRow> call, Throwable t) {
                dialog.dismiss();
                Log.e("ResponceOFManager",t.getCause().toString());
                Toast.makeText(NewsManager.this, ""+t.getCause().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}