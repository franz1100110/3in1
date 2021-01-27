package com.example.a3in1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivity listActivity;
    List<Model> modelList;
    Context context;

    public CustomAdapter(ListActivity listActivity, List<Model> modelList) {
        this.listActivity = listActivity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemCLick(View view, final int position) {
                String title = modelList.get(position).getId();
                String mount  =modelList.get(position).getJum();
                String desc = modelList.get(position).getTak();
                Toast.makeText(listActivity, title+"\n"+desc+"\n"+mount, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(listActivity,Edit.class);
                intent.putExtra("pTitle",title);
                intent.putExtra("pAmount",mount);
                intent.putExtra("pDesc",desc);
                listActivity.startActivity(intent);
            }

        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int i) {
        //bind views /  set data
        viewholder.mTitle.setText(modelList.get(i).getId());
        viewholder.mAmount.setText(modelList.get(i).getJum());
        viewholder.mDescription.setText(modelList.get(i).getTak());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
