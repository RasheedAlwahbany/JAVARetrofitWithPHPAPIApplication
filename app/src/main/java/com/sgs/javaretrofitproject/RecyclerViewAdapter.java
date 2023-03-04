package com.sgs.javaretrofitproject;

import android.content.Context;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sgs.javaretrofitproject.API.DataServiceRow;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    Context context;
    List<DataServiceRow> list;
    public RecyclerViewAdapter(Context context1,List<DataServiceRow> list1){
    context=context1;
    list=list1;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.id.setText(""+list.get(position).getId());
    holder.name.setText(list.get(position).getName());
    holder.description.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name,description,id;

        public Holder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.txtv_row_id);
            name=itemView.findViewById(R.id.txtv_row_name);
            description=itemView.findViewById(R.id.txtv_row_description);
        }
    }
}
