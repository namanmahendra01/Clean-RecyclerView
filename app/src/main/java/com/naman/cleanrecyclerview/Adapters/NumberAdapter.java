package com.naman.cleanrecyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naman.cleanrecyclerview.R;
import com.naman.cleanrecyclerview.interfaces.onItemClickListener;

import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.viewHolder> {

    ArrayList<Integer> integerList;
    Context mContext;
    onItemClickListener onItemClickListener;

    public NumberAdapter(ArrayList<Integer> integerList, Context mContext, com.naman.cleanrecyclerview.interfaces.onItemClickListener onItemClickListener) {
        this.integerList = integerList;
        this.mContext = mContext;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberAdapter.viewHolder holder, int position) {

        holder.textView.setText(String.valueOf(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(v, position, holder.textView.getText().toString());
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onImageClicked();
            }
        });

    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);


        }
    }
}
