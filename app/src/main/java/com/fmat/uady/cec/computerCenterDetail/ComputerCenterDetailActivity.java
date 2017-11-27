package com.fmat.uady.cec.computerCenterDetail;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.listComputerCenter.ComputerCenterAdapter;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerData;

import java.util.ArrayList;

public class ComputerCenterDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ComputerCenterDetailAdapter adapter;
    private String nameCenter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_center_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_computer_center_detail);
        setSupportActionBar(toolbar);

        nameCenter = getIntent().getStringExtra(ComputerCenterAdapter.NAME_CENTER);


        getSupportActionBar().setTitle(nameCenter);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.list_computer);

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);

        ComputerData datos = new ComputerData();

        ArrayList<Computer> computers = datos.getComputersByCenter(nameCenter);

        adapter = new ComputerCenterDetailAdapter(computers, getApplicationContext());

        recyclerView.setAdapter(adapter);


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
