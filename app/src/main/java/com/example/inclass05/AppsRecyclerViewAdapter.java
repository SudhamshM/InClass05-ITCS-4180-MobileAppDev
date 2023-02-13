package com.example.inclass05;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppsRecyclerViewAdapter extends RecyclerView.Adapter<AppsRecyclerViewAdapter.AppViewHolder>
{
    ArrayList<DataServices.App> appsList;
    public AppsRecyclerViewAdapter(ArrayList<DataServices.App> appsList)
    {
        this.appsList = appsList;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder
    {
        TextView appName, artistName;
        int position;
        DataServices.App app;
        View rootView;
        public AppViewHolder(@NonNull View itemView)
        {
            super(itemView);
            appName = itemView.findViewById(R.id.textViewAppName);
            artistName = itemView.findViewById(R.id.textViewArtistName);
            rootView = itemView;
        }


    }
}
