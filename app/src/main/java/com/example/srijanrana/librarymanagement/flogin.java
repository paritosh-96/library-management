package com.example.srijanrana.librarymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Srijan Rana on 10/22/2015.
 */
public class flogin extends Activity {

    TextView tvflogin;
    TextView tvfusername;
    TextView tvfpassword;
    Button bflogin;
    EditText etfusername;
    EditText etfpassword;
    DBHandler mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facultytlogin);
        tvflogin=(TextView)findViewById(R.id.TVflogin);
        tvfusername=(TextView)findViewById(R.id.SUusername);
        tvfpassword=(TextView)findViewById(R.id.TVfpassword);
        bflogin=(Button)findViewById(R.id.Bflogin);
        etfpassword=(EditText)findViewById(R.id.ETfpassword);
        etfusername=(EditText)findViewById(R.id.ETfusername);
        mydb=new DBHandler(this,null,null,1);

    }
    public String get_password(){  return etfpassword.getText().toString();}
    public String get_name() {  return etfusername.getText().toString();}
    String username,password;
    public void onClicksLogin(View v)
    {
        if(v==bflogin){
            username=etfusername.getText().toString();
            password=etfpassword.getText().toString();

            int r=mydb.checkf(username, password);
            if(r==1)
            {
                Intent fl = new Intent(getBaseContext(),faculty1Activity.class);
                startActivity(fl);
            }
            else
            {
                etfusername.setText("Wrong Combination!");
                etfpassword.setText("Wrong Combination!");
            }
        }
    }
}
