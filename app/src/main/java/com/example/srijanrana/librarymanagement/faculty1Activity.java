package com.example.srijanrana.librarymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class faculty1Activity extends Activity
{
    TextView tvfwelcome;
    Button bfprofile;
    Button bfissue;
    Button bfreturn;
    Button bflogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty1);
        tvfwelcome=(TextView)findViewById(R.id.TVfwelcome);
        bfissue=(Button)findViewById(R.id.Bfissue);
        bfreturn=(Button)findViewById(R.id.Bfreturn);
        bflogout=(Button)findViewById(R.id.Bflogout);
        flogin n=new flogin();
        tvfwelcome.setText("Welcome, "+n.get_name());
    }
    public void logout(View v) {
        if (v == bflogout) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
        }
    }
    public void onClickLogin(View v)
    {
        if(v==bfprofile)
        {
            Intent i=new Intent(getBaseContext(),flogin.class);
            startActivity(i);
        }
    }
    public void bookList(View v)
    {
        if(v==bfissue)
        {
            Intent i=new Intent(getBaseContext(),Book.class);
            startActivity(i);
        }
    }
    public void returnBook(View v)
    {
        if(v==bfreturn)
        {
            Intent i=new Intent(getBaseContext(),ReturnList.class);
            startActivity(i);
        }
    }
}