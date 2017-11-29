package com.fmat.uady.cec.history;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.model.History;

import java.util.List;

/**
 * Created by M on 28/11/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    private List<History> list;

    public  HistoryAdapter(List<History> list){
        this.list = list;
    }

    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.text.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text_history);
        }
    }

}
