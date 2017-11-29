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
import com.fmat.uady.cec.service.WakeOnLan;
import com.fmat.uady.cec.computerCenterDetail.ComputerCenterDetailAdapter;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerData;

import java.util.List;

public class ComputerDetailActivity extends AppCompatActivity {

    private String nameCenter;
    private String nameComputer;
    private Computer computerCurrent;
    private ImageView buttonPower;
    private TextView tcomputer;
    private TextView tmacaddress;
    private TextView tcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        this.tmacaddress = (TextView) findViewById(R.id.macaddress);
        tmacaddress.setText(computerCurrent.getMacAddress());
    }

    public void getComputer(){
        ComputerData datos = new ComputerData();
        List<Computer> computers = datos.getComputersByCenter(nameCenter);
        for (Computer icomputer: computers){
            if (icomputer.getNameComputer().equals(nameComputer)){
                computerCurrent = icomputer;
            }
        }
    }

    public void loadButtons(){
        if(computerCurrent.isOn()){
            buttonPower.setImageResource(R.mipmap.ic_on);
        }
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(computerCurrent.isOn()){
                    Toast.makeText(ComputerDetailActivity.this,"APAGATE SESAMO!",Toast.LENGTH_SHORT).show();
                    computerCurrent.setOn(false);
                    buttonPower.setImageResource(R.mipmap.ic_off);
                }else{
                    Toast.makeText(ComputerDetailActivity.this,"LEVANTATE!",Toast.LENGTH_SHORT).show();
                    computerCurrent.setOn(true);
                    buttonPower.setImageResource(R.mipmap.ic_on);
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
