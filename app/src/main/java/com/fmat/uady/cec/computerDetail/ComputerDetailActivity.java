package com.fmat.uady.cec.computerDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.computerCenterDetail.ComputerCenterDetailAdapter;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerData;
import com.fmat.uady.cec.service.Service;

import java.util.List;

public class ComputerDetailActivity extends AppCompatActivity {

    private String nameCenter;
    private String nameComputer;
    private Computer computerCurrent;
    private ImageView buttonPower;
    private TextView tcomputer;
    private TextView tcenter;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.service = new Service(this);
        setContentView(R.layout.activity_computer_detail);
        computerCurrent = new Computer();

        nameCenter = getIntent().getStringExtra(ComputerCenterDetailAdapter.NAME_CENTER);
        nameComputer = getIntent().getStringExtra(ComputerCenterDetailAdapter.NAME_COMPUTER);
        getComputer();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_computer_center_detail);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(nameComputer);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Data
        loadData();
        //Buttons
        buttonPower = (ImageView) findViewById(R.id.button_power);
        loadButtons();
    }

    private void loadData() {
        this.tcomputer = (TextView) findViewById(R.id.id_computer);
        tcomputer.setText(computerCurrent.getNameComputer());
        this.tcenter = (TextView) findViewById(R.id.id_center);
        tcenter.setText(computerCurrent.getIdComputerCenter());
    }
    @Override
    public void onResume() {
        super.onResume();
        getComputer();
    }

    public void getComputer(){
        ComputerData datos = ComputerData.getInstance();
        List<Computer> computers = datos.getComputersByCenter(nameCenter);
        for (Computer icomputer: computers){
            if (icomputer.getNameComputer().equals(nameComputer)){
                computerCurrent = icomputer;
            }
        }
    }

    public void loadButtons(){
        if(computerCurrent.isOn()){
            buttonPower.setImageResource(R.drawable.ic_power_button_off);
        }
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(computerCurrent.isOn()){
                    ComputerDetailActivity.this.service.turnOff(computerCurrent.getNameComputer());
                    computerCurrent.setOn(false);
                    ComputerData.getInstance().updateComputer(computerCurrent);
                    buttonPower.setImageResource(R.drawable.ic_power_button_on);
                }else{
                    ComputerDetailActivity.this.service.turnOn(computerCurrent.getNameComputer());
                    computerCurrent.setOn(true);
                    ComputerData.getInstance().updateComputer(computerCurrent);
                    buttonPower.setImageResource(R.drawable.ic_power_button_off);
                }

            }
        });
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
