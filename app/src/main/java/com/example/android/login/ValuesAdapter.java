package com.example.android.login;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by medha on 18/11/15.
 */
public  class ValuesAdapter  extends RecyclerView.Adapter<ValuesAdapter.viewHolder> {

    public Context context1;
    List<String> list = new ArrayList<>();
    int position;

    LayoutInflater inflater;

    public ValuesAdapter(Context context) {
        context1 = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = inflater.inflate(R.layout.balence_line, parent, false);
        viewHolder vHolder = new viewHolder(view);
        Log.e("create", position + "");
        return vHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        Log.e("bind", position + "");

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        setList();
        Log.e("pos4", position + "");
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setList() {

    }

    class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        public viewHolder(View itemView) {


            super(itemView);


        }

        @Override
        public void onClick(View v) {

        }
    }
}