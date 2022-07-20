package com.example.mymobileapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    LayoutInflater mInFlater;
    ArrayList<Ingredient> ingredientArrayList;
    Context context;
    public CustomAdapter(Context c, ArrayList<Ingredient> i) {
        context = c;
        ingredientArrayList=i;
        mInFlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return ingredientArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return ingredientArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = mInFlater.inflate(R.layout.my_detailed_list_ingredients_preview, null);
        }
        TextView ingredientInfo = (TextView) v.findViewById(R.id.ingredientsTextView);
        Button removeInfoBtn = (Button) v.findViewById(R.id.removeInfoBtn);
        removeInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientArrayList.remove(i);
                ingredientInfo.setText("");
            }
        });
        ingredientInfo.setText(ingredientArrayList.get(i).getAmount() + " " + ingredientArrayList.get(i).getName());
        return v;
    }
}
