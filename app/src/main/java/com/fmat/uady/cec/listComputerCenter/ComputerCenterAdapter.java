package com.fmat.uady.cec.listComputerCenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.computerCenterDetail.ComputerCenterDetailActivity;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerCenter;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerCenterAdapter extends RecyclerView.Adapter<ComputerCenterAdapter.ComputerCenterViewHolder> implements Filterable{
    private ArrayList<ComputerCenter> computerCenters;
    private ArrayList<ComputerCenter> filteredComputerCenters;
    public static String NAME_CENTER = "com.fmat.uady.cec.computerCenter.nameCenter";
    private Context context;

    public ComputerCenterAdapter(ArrayList<ComputerCenter> computerCenters, Context context) {
        this.computerCenters = computerCenters;
        this.filteredComputerCenters = computerCenters;
        this.context = context;
    }

    @Override
    public ComputerCenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computer_center, parent, false);
        return new ComputerCenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComputerCenterViewHolder holder, final int position) {
        holder.name.setText(filteredComputerCenters.get(position).getName());

        if(filteredComputerCenters.get(position).getOn()){
            holder.image.setImageResource(R.mipmap.ic_group_on);
        }else{
            holder.image.setImageResource(R.mipmap.ic_group_off);
        }

        holder.center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent computerCenterDetail = new Intent(context, ComputerCenterDetailActivity.class);
                computerCenterDetail.putExtra(NAME_CENTER,computerCenters.get(position).getName() );
                computerCenterDetail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(computerCenterDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredComputerCenters.size();
    }

    @Override
    public Filter getFilter() {


        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    filteredComputerCenters = computerCenters;
                }else {

                    ArrayList<ComputerCenter> filteredList = new ArrayList<>();
                    for(ComputerCenter computerCenter : computerCenters){
                        if(computerCenter.getName().contains(charString.toUpperCase())){
                            filteredList.add(computerCenter);
                        }
                    }

                    filteredComputerCenters = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredComputerCenters;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredComputerCenters = (ArrayList<ComputerCenter>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    protected class ComputerCenterViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        CardView center;

        public ComputerCenterViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_center);
            name = (TextView) itemView.findViewById(R.id.text_name_center);
            center = (CardView) itemView.findViewById(R.id.item_center);

        }
    }
}
