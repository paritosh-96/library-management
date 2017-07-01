package com.example.srijanrana.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SProfile extends AppCompatActivity {

    TextView TVsdetails;
    TextView TVsinfo;
    DBHandler mydb;
    Button btback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprofile);
        TVsdetails=(TextView)findViewById(R.id.TVsDetails);
        TVsinfo=(TextView)findViewById(R.id.TVsinfo);
        mydb=new DBHandler(this,null,null,1);
        btback=(Button)findViewById(R.id.Bback);
        Student details=new Student();
        String name=details.get_name();
        String reg=details.get_reg();
        String blist=mydb.getsblist(reg);

        TVsdetails.setText("Name :"+name+"/nReg no.:"+reg+"/nBook Issued:/n"+blist);
    }

    public void onCLickBack(View v)
    {
        if(v==btback)
        {
            Intent sl = new Intent(getBaseContext(),student1Activity.class);
            startActivity(sl);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sprofile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
