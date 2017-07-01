package com.example.srijanrana.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    TextView TVSUNAME;
    TextView TVSUid;
    Button BTSU;
    EditText ETSUname;
    EditText ETSUid;
    RadioButton RDfac;
    RadioButton RDstu;
    DBHandler mydb;
    RadioGroup rgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TVSUNAME=(TextView)findViewById(R.id.SUTVname);
        TVSUid=(TextView)findViewById(R.id.SUTVid);
        BTSU=(Button)findViewById(R.id.signup);
        ETSUid=(EditText)findViewById(R.id.ETSUid);
        ETSUname=(EditText)findViewById(R.id.ETSUname);
        RDfac=(RadioButton)findViewById(R.id.RBfac);
        RDstu=(RadioButton)findViewById(R.id.RBstu);
        rgroup=(RadioGroup)findViewById(R.id.RGroup);
        mydb=new DBHandler(this,null,null,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
        return true;


    }

    public void finalsignup(View v)
    {

        if((ETSUname.getText()!=null)&&(ETSUid.getText()!=null))
        {
            Log.d("check", "test");
            if(RDstu.isSelected())
            Toast.makeText(this, "test",
                    Toast.LENGTH_LONG).show();
            if(rgroup.getCheckedRadioButtonId()==RDstu.getId())
            {
                Log.d("check","test");
                Toast.makeText(this, "testing",
                        Toast.LENGTH_LONG).show();
                String name=ETSUname.getText().toString();
                String id=ETSUid.getText().toString();
                Student stud=new Student(id,name);
                mydb.sadd(stud);

            }

            else if(rgroup.getCheckedRadioButtonId()==RDfac.getId())
            {
                String name=ETSUname.getText().toString();
                int id=Integer.parseInt(ETSUid.getText().toString());
                Faculty fac=new Faculty(id,name);
                mydb.fadd(fac);
            }
            Intent sl = new Intent(getBaseContext(),MainActivity.class);
            startActivity(sl);
        }
        else
        {
            ETSUid.setText("Enter ID");
            ETSUname.setText("Enter Name");
        }
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
