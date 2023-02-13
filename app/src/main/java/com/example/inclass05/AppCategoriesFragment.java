package com.example.inclass05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.inclass05.databinding.FragmentAppCategoriesBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        getActivity().setTitle(R.string.categories_screen);

        binder.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                mListener.goToCategoryAppList(categories.get(position));
            }
        });
    }
    AppsCategoriesListener mListener;
    public interface AppsCategoriesListener
    {
        void goToCategoryAppList(String category);
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        mListener = (AppsCategoriesListener) context;
    }
}