package com.fmat.uady.cec.computerDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.listComputerCenter.ComputerCenterAdapter;

public class ComputerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_detail);

        //getSupportActionBar().setTitle(getIntent().getStringExtra(ComputerCenterAdapter.NAME_CENTER));
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
