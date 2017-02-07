package com.royettecamahalan.eventsamples;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText ETfirst,ETSecond;

    Button btnAdd,btnSubtract;

    TextView TVaNSWER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETfirst=(EditText) findViewById(R.id.etFirstNo);
        ETSecond=(EditText) findViewById(R.id.etSecondNo);
        TVaNSWER= (TextView) findViewById(R.id.answer);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnSubtract= (Button) findViewById(R.id.Subtract);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final Dialog dialogconfirm=new Dialog(this);
        dialogconfirm.setContentView(R.layout.dialogconfirmation);

        Button btnno=(Button) dialogconfirm.findViewById(R.id.btnno);
        Button btnyes= (Button) dialogconfirm.findViewById(R.id.btnyes);

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                dialogconfirm.dismiss();
            }
        });

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first=Integer.parseInt(ETfirst.getText().toString());
                int second=Integer.parseInt(ETSecond.getText().toString());
                int answer=0;
                answer=first+second;
                TVaNSWER.setText(String.valueOf(answer));
                dialogconfirm.dismiss();
            }
        });

        dialogconfirm.show();

        //ALERT DIALOG
        /*AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("Confirmation");
        builder.setMessage("Do you want to add this numbers?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int first=Integer.parseInt(ETfirst.getText().toString());
                int second=Integer.parseInt(ETSecond.getText().toString());
                int answer=0;
                answer=first+second;
                TVaNSWER.setText(String.valueOf(answer));
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
            }
        });


        builder.create().show();*/



        /*int first=Integer.parseInt(ETfirst.getText().toString());
        int second=Integer.parseInt(ETSecond.getText().toString());

        int answer=0;
        if(v.getId()==R.id.btnAdd){
            answer=first+second;
        }
        else if(v.getId()==R.id.Subtract){
            answer=first-second;
        }
        TVaNSWER.setText(String.valueOf(answer));*/
    }
}
