package com.royettecamahalan.gatekeeper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RoyetteCamahalan on 1/17/2017.
 */

public class LoginActivity extends AppCompatActivity {


    TextView btnSignin;
    EditText txtUsername,txtPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        setContentView(R.layout.loginlayout);


        btnSignin=(TextView) findViewById(R.id.btnSignin);
        txtUsername=(EditText) findViewById(R.id.username);
        txtPassword= (EditText) findViewById(R.id.password);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,
                        "Username is "+txtUsername.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
