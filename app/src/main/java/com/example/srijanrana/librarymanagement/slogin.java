package com.example.srijanrana.librarymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Srijan Rana on 10/22/2015.
 */
public class slogin extends Activity
{
    TextView tvslogin;
    TextView tvsusername;
    TextView tvspassword;
    Button bslogin;
    EditText etsusername;
    EditText etspassword;
    DBHandler mydb;
    Student s;

    public slogin() {
        //constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlogin);
        tvslogin=(TextView)findViewById(R.id.TVslogin);
        tvsusername=(TextView)findViewById(R.id.TVsusername);
        tvspassword=(TextView)findViewById(R.id.TVspassword);
        bslogin=(Button)findViewById(R.id.Bslogin);
        etsusername=(EditText)findViewById(R.id.ETsusername);
        etspassword=(EditText)findViewById(R.id.ETspassword);
        mydb=new DBHandler(this,null,null,1);
        s=new Student();

    }
    public void get_password(){
     //return etspassword.getText().toString();
        //Student s=new Student();
        s.set_reg(etspassword.getText().toString());
    }
    public void get_name()
    {
        s.set_name(etsusername.getText().toString());//return etsusername.getText().toString();
    }
    String username,password;
    public void onClicksLogin(View v)
    {
        if(v==bslogin){
            username=etsusername.getText().toString();
            password=etspassword.getText().toString();
            Log.d("Check2","entered log in");
            int r=mydb.checks(username,password);
            Log.d("Check2","entered log in");
            if(r==1)
            {
                Intent sl = new Intent(getBaseContext(),student1Activity.class);
                startActivity(sl);

            }
            else
            {
                etsusername.setText("Wrong Combination!");
                etspassword.setText("Wrong Combination!");
            }

        }
    }


}
