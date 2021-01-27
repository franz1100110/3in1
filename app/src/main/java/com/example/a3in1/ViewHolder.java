package com.example.a3in1;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle,mDescription,mAmount;

    View mView;

    public ViewHolder(View itemView){
        super (itemView);
        mView=itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemCLick(v, getAdapterPosition());
            }
        });
        mTitle = itemView.findViewById(R.id.rTitle);
        mDescription = itemView.findViewById(R.id.rDescription);
        mAmount = itemView.findViewById(R.id.rAmount);
    }
    private ViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void onItemCLick(View view,int position);
    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener=clickListener;
    }
}
