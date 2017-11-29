package com.fmat.uady.cec.history;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.model.ComputerData;
import com.fmat.uady.cec.model.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by M on 28/11/2017.
 */

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_computer_center_detail);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("Historial");

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.list_history);

        adapter = new HistoryAdapter(loadData());
        recyclerView.setAdapter(adapter);


    }

    public List<History> loadData(){
        List<History> list = new ArrayList();
        list.add(new History("C5", "CC1", "Milka", "APAGAR", new Date()));
        list.add(new History("C6", "CC1", "Milka", "ENCENDER", new Date()));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
