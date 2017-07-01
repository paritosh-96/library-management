package com.example.srijanrana.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView Imageview;
    Button btfl;
    Button btsl;
    Button btsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btfl=(Button)findViewById(R.id.BTfl);
        btsl=(Button)findViewById(R.id.BTsl);
        Imageview=(ImageView)findViewById(R.id.imageView);
        btsignup=(Button)findViewById(R.id.BTsignup);
    }
    public void onClicklogin(View v)
    {
        if (v==btsl)
        {
            Intent sl = new Intent(getBaseContext(),slogin.class);
            startActivity(sl);
        }
        else if(v==btfl){
            Intent fl = new Intent(getBaseContext(),flogin.class);
            startActivity(fl);
        }
        else if(v==btsignup){
            Intent su = new Intent(getBaseContext(),signup.class);
            startActivity(su);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
