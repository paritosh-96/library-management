package com.example.srijanrana.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FProfile extends AppCompatActivity {

    TextView Tvfinfo;
    TextView tvfdetails;
    Button btback;
    DBHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fprofile);
        Tvfinfo=(TextView)findViewById(R.id.TVfinfo);
        tvfdetails=(TextView)findViewById(R.id.TVfDetails);
        btback=(Button)findViewById(R.id.BBack);
        mydb=new DBHandler(this,null,null,1);

        flogin details=new flogin();
        String name=details.get_name();
        String id=details.get_password();
        String blist=mydb.getfblist(id);

        tvfdetails.setText("Name :"+name+"/nReg no.:"+id +"/nBook Issued:/n"+blist);

    }

    public void onClickback(View v)
    {
        Intent fl = new Intent(getBaseContext(),faculty1Activity.class);
        startActivity(fl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fprofile, menu);
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
