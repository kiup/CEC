package com.fmat.uady.cec.computerCenterDetail;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.listComputerCenter.ComputerCenterAdapter;

public class ComputerCenterDetailActivity extends AppCompatActivity {

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
