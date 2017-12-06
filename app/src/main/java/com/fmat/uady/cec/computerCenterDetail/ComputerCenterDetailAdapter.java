package com.fmat.uady.cec.computerCenterDetail;

import android.app.Dialog;
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
import com.fmat.uady.cec.computerDetail.ComputerDetailActivity;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerCenter;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerCenterDetailAdapter extends RecyclerView.Adapter<ComputerCenterDetailAdapter.ComputerViewHolder> {
    private ArrayList<Computer> computers;
    public static String NAME_COMPUTER = "com.fmat.uady.cec.computer.nameComputer";
    public static String NAME_CENTER = "com.fmat.uady.cec.computer.nameCenter";
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
        if(computers.get(position).isOn()){
            holder.image.setImageResource(R.drawable.ic_computer_green_24dp);
        }else{
            holder.image.setImageResource(R.drawable.ic_computer_black_24dp);
        }
        holder.computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.content_computer_detail);
                dialog.setTitle("This is my custom dialog box");
                dialog.setCancelable(true);
                //there are a lot of settings, for dialog, check them all out!

                //set up text
                /*TextView text = (TextView) dialog.findViewById(R.id.TextView01);
                text.setText(R.string.lots_of_text);

                //set up image view
                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
                img.setImageResource(R.drawable.nista_logo);

                //set up button
                Button button = (Button) dialog.findViewById(R.id.Button01);
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });*/
                //now that the dialog is set up, it's time to show it
                dialog.show();
                /*Intent computerDetail = new Intent(context, ComputerDetailActivity.class);
                computerDetail.putExtra(NAME_COMPUTER, computers.get(position).getNameComputer());
                computerDetail.putExtra(NAME_CENTER, computers.get(position).getIdComputerCenter());
                computerDetail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(computerDetail);*/
            }
        });

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
