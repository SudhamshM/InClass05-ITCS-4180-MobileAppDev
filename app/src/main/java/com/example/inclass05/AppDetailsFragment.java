package com.example.inclass05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inclass05.databinding.FragmentAppDetailsBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppDetailsFragment extends Fragment
{

    public static final String ARG_APP = "APP";
    private DataServices.App mApp;
    FragmentAppDetailsBinding binder;
    AppGenreAdapter adapter;
    ArrayList<String> genreList;

    public AppDetailsFragment()
    {
        // Required empty public constructor
    }

    public static AppDetailsFragment newInstance(DataServices.App param1)
    {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_APP, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mApp = (DataServices.App) getArguments().getSerializable(ARG_APP);
            genreList = mApp.genres;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binder = FragmentAppDetailsBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("App Details");
        binder.textViewDetailsName.setText(mApp.name);
        binder.textViewDetailsArtist.setText(mApp.artistName);
        binder.textViewDetailsRelease.setText(mApp.releaseDate);
        adapter = new AppGenreAdapter(getActivity(), R.layout.genre_row, genreList);

        binder.listViewGenre.setAdapter(adapter);


    }

    public static class AppGenreAdapter extends ArrayAdapter<String>
    {

        public AppGenreAdapter(@NonNull Context context, int resource, @NonNull List<String> objects)
        {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.genre_row, parent, false);
                GenreViewHolder viewHolder = new GenreViewHolder();
                viewHolder.genre = convertView.findViewById(R.id.textViewGenre);
                convertView.setTag(viewHolder);
            }
            String genre = getItem(position);
            GenreViewHolder viewHolder = (GenreViewHolder) convertView.getTag();
            viewHolder.genre.setText(genre);
            return convertView;
        }
    }

    public static class GenreViewHolder
    {
        TextView genre;
    }
}