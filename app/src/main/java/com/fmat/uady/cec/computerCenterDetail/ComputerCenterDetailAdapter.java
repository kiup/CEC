package com.fmat.uady.cec.computerCenterDetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerCenter;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerCenterDetailAdapter extends RecyclerView.Adapter<ComputerCenterDetailAdapter.ComputerViewHolder> {
    private ArrayList<Computer> computers;
    public static String NAME_COMPUTER = "com.fmat.uady.cec.computerCenter.nameComputer";
    private Context context;

    public ComputerCenterDetailAdapter(ArrayList<Computer> computers, Context context) {
        this.computers = computers;
        this.context = context;
    }

    @Override
    public ComputerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computer, parent, false);
        return new ComputerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComputerViewHolder holder, final int position) {
        holder.name.setText(computers.get(position).getNameComputer());
       /* holder.center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent computerCenterDetail = new Intent(context, ComputerCenterDetailActivity.class);
                computerCenterDetail.putExtra(NAME_CENTER, computers.get(position).getName() );
                computerCenterDetail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(computerCenterDetail);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return computers.size();
    }


    protected class ComputerViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        CardView computer;

        public ComputerViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_computer);
            name = (TextView) itemView.findViewById(R.id.text_name_computer);
            computer= (CardView) itemView.findViewById(R.id.item_computer);

        }
    }
}
