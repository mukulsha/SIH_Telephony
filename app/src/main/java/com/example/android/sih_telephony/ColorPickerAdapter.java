package com.example.android.sih_telephony;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by divya on 2018-03-21.
 */

public class ColorPickerAdapter extends RecyclerView.Adapter<ColorPickerAdapter.MyViewHolder> {

    private List<ColorPickerListItem> colorPickerListItem;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView percentagae, colorCode;

        public MyViewHolder(View itemView) {
            super(itemView);

            percentagae = (TextView) itemView.findViewById(R.id.percent);
            colorCode = (TextView) itemView.findViewById(R.id.colorcode);

        }
    }

    public ColorPickerAdapter(List<ColorPickerListItem> colorPickerListItem) {
        this.colorPickerListItem = colorPickerListItem;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ColorPickerListItem item = colorPickerListItem.get(position);
        holder.percentagae.setText(item.getPercentage());
        holder.colorCode.setText(item.getColorCode());

    }

    @Override
    public int getItemCount() {
        return colorPickerListItem.size();
    }

}
