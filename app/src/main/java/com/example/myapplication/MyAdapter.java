package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRow> {

    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        holder.tv.setText(this.arrayList.get(position).getName() + "; "+this.arrayList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    class MyRow extends RecyclerView.ViewHolder {
        TextView tv;
        public MyRow(@NonNull View itemView) {
            super(itemView);
            this.tv = itemView.findViewById(R.id.textView);
        }
    }


    public ArrayList<User> arrayList;

    public MyAdapter(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }
}
