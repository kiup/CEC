package com.fmat.uady.cec.listComputerCenter;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.persistence.entities.Computer;
import com.fmat.uady.cec.persistence.entities.ComputerCenter;
import com.fmat.uady.cec.persistence.database.DataInitializer;
import com.fmat.uady.cec.persistence.database.AppData;

import java.util.List;

public class ComputerCenterActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView recyclerView;
    private ComputerCenterAdapter adapter;
    private List<ComputerCenter> computerCenters;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_computer_center);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.setDrawerListener(drawerToggle);

        drawerToggle.syncState();



        recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //inicializa el adapter con los datos que se crearan

        loadData();
        adapter = new ComputerCenterAdapter(computerCenters, getApplicationContext());


        recyclerView.setAdapter(adapter);


    }

    private void loadData(){

        computerCenters = AppData.getAppData(getApplicationContext()).computerCenterDao().getAll();
        checkComputersOn();

    }

    private void checkComputersOn() {

        for(ComputerCenter computerCenter :computerCenters ){
            List<Computer> computers = AppData.getAppData(getApplicationContext()).computerDao().
                    findByCenter(computerCenter.getName());
            for (Computer computer : computers ){
                if(computer.isTurnOn()){
                    computerCenter.setTurnOn(true);
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

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

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

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_profil:
                Toast.makeText(getApplicationContext(),"Perfil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_history:
                Toast.makeText(getApplicationContext(),"Historial", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {


        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

}
