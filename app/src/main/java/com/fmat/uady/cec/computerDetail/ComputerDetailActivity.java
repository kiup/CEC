package com.fmat.uady.cec.computerDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.fmat.uady.cec.R;
import com.fmat.uady.cec.computerCenterDetail.ComputerCenterDetailAdapter;
import com.fmat.uady.cec.listComputerCenter.ComputerCenterAdapter;
import com.fmat.uady.cec.model.Computer;
import com.fmat.uady.cec.model.ComputerData;

import java.util.List;

public class ComputerDetailActivity extends AppCompatActivity {

    private String nameCenter;
    private String nameComputer;
    private Computer computerCurrent;
    private ImageView buttonPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_detail);
        computerCurrent = new Computer();
        getComputer();
        nameCenter = getIntent().getStringExtra(ComputerCenterDetailAdapter.NAME_CENTER);
        nameComputer = getIntent().getStringExtra(ComputerCenterDetailAdapter.NAME_COMPUTER);
        getSupportActionBar().setTitle(getIntent().getStringExtra(nameComputer));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Buttons
        buttonPower = (ImageView) findViewById(R.id.button_power);
        loadButtons();
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
        if(computerCurrent.isState()){
            buttonPower.setImageResource(R.mipmap.ic_on);
        }
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(computerCurrent.isState()){
                    Toast.makeText(ComputerDetailActivity.this,"APAGATE SESAMO!",Toast.LENGTH_LONG);
                    computerCurrent.setState(false);
                    buttonPower.setImageResource(R.mipmap.ic_off);
                }else{
                    Toast.makeText(ComputerDetailActivity.this,"LEVANTATE!",Toast.LENGTH_LONG);
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
