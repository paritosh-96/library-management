package com.example.srijanrana.librarymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Srijan Rana on 10/21/2015.
 */
public class student1Activity extends Activity
{
    TextView tvswelcome;
    Button bsprofile;
    Button bsissue;
    Button bsreturn;
    Button bslogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student1);
        tvswelcome=(TextView)findViewById(R.id.TVswelcome);
        bsprofile=(Button)findViewById(R.id.Bsprofile);
        bsissue=(Button)findViewById(R.id.Bsissue);
        bsreturn=(Button)findViewById(R.id.Bsreturn);
        bslogout=(Button)findViewById(R.id.Bslogout);
        Student s=new Student();
        tvswelcome.setText("Welcome, "+s.get_name());
    }
    public void logout(View v) {
        if (v == bslogout) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
        }
    }

    public void profile(View v)
    {
        if(v==bsprofile)
        {
            Intent i=new Intent(getBaseContext(),SProfile.class);
            startActivity(i);
        }
    }

    public void bookList(View v)
    {
        if(v==bsissue)
        {
            Intent i=new Intent(getBaseContext(),BookList.class);
            startActivity(i);
        }
    }
    public void returnBook(View v)
    {
        if(v==bsreturn)
        {
            Intent i=new Intent(getBaseContext(),ReturnList.class);
            startActivity(i);
        }
    }









}

