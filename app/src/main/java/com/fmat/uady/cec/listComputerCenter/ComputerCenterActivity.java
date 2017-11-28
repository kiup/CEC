package com.fmat.uady.cec.listComputerCenter;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerCenter;
import com.fmat.uady.cec.model.ComputerData;

import java.util.ArrayList;

public class ComputerCenterActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView recyclerView;
    private ComputerCenterAdapter adapter;
    private ArrayList<ComputerCenter> computerCenters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_computer_center);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);



        recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //inicializa el adapter con los datos que se crearan


        checkComputersOn();
        adapter = new ComputerCenterAdapter(computerCenters, getApplicationContext());


        recyclerView.setAdapter(adapter);


    }

    private void checkComputersOn() {
        ComputerData datos = new ComputerData();

        computerCenters = datos.getComputerCenters();
        for(ComputerCenter computerCenter :computerCenters ){
            ArrayList<Computer> computers = datos.getComputersByCenter(computerCenter.getName());
            for (Computer computer : computers ){
                if(computer.isOn()){
                    computerCenter.setOn(true);
                    break;
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_computer_center, menu);

        MenuItem search = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }
}
