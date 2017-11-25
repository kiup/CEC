package com.fmat.uady.cec.listComputerCenter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.model.ComputerCenter;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerCenterAdapter extends RecyclerView.Adapter<ComputerCenterAdapter.ComputerCenterViewHolder>{
    private ArrayList<ComputerCenter> computerCenters;

    public ComputerCenterAdapter(ArrayList<ComputerCenter> computerCenters) {
        this.computerCenters = computerCenters;
    }

    @Override
    public ComputerCenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computer_center, parent, false);
        return new ComputerCenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComputerCenterViewHolder holder, int position) {
        holder.name.setText(computerCenters.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return computerCenters.size();
    }

    protected class ComputerCenterViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ComputerCenterViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_center);
            name = (TextView) itemView.findViewById(R.id.text_name_center);

        }
    }
}
