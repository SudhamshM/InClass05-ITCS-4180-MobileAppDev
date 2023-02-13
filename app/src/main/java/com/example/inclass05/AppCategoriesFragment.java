package com.example.inclass05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inclass05.databinding.FragmentAppCategoriesBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppCategoriesFragment extends Fragment
{
    FragmentAppCategoriesBinding binder;
    CategoryAdapter categoryAdapter;
    ArrayList<String> categories = DataServices.getAppCategories();

    public AppCategoriesFragment()
    {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binder = FragmentAppCategoriesBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        categoryAdapter = new CategoryAdapter(getContext(), R.layout.category_row, categories);
        binder.listView.setAdapter(categoryAdapter);
    }
}