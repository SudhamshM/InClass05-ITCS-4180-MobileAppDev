package com.example.inclass05;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.inclass05.DataServices.App;

import java.util.ArrayList;

public class AppsRecyclerViewAdapter extends RecyclerView.Adapter<AppsRecyclerViewAdapter.AppViewHolder>
{
    ArrayList<App> appsList;
    IAppViewer mListener;
    public AppsRecyclerViewAdapter(ArrayList<App> appsList, IAppViewer mListener)
    {
        this.appsList = appsList;
        this.mListener =  mListener;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_short_row, parent, false);
        AppViewHolder appViewHolder = new AppViewHolder(view, mListener);
        return appViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position)
    {
        App app = appsList.get(position);
        holder.position = position;
        holder.appName.setText(app.name);
        holder.artistName.setText(app.artistName);
        holder.releaseDate.setText(app.releaseDate);
        holder.app = app;
    }

    @Override
    public int getItemCount()
    {
        return appsList.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder
    {
        TextView appName, artistName, releaseDate;
        int position;
        App app;
        View rootView;
        IAppViewer mListener;
        public AppViewHolder(@NonNull View itemView, IAppViewer mListener)
        {
            super(itemView);
            appName = itemView.findViewById(R.id.textViewAppName);
            artistName = itemView.findViewById(R.id.textViewArtistName);
            releaseDate = itemView.findViewById(R.id.textViewReleaseDate);
            rootView = itemView;
            this.mListener = (IAppViewer) mListener;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Log.d("inclass05", "onClick: clicked app " + app.name);
                    mListener.goToApp(app);
                }
            });
        }


    }

    interface IAppViewer
    {
        void goToApp(App app);
    }
}
