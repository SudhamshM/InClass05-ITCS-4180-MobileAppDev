package com.example.inclass05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<String>
{

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<String> objects)
    {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_row, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.categoryName = convertView.findViewById(R.id.textViewCategoryName);
            convertView.setTag(viewHolder);
        }
        String category = getItem(position);

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.categoryName.setText(category);
        return convertView;
    }

    private static class ViewHolder
    {
        TextView categoryName;
    }
}
