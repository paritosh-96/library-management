package com.example.srijanrana.librarymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import java.util.zip.CheckedInputStream;

public class BookList extends AppCompatActivity {

    CheckBox cbx1;
    CheckBox cbx2;
    CheckBox cbx3;
    CheckBox cbx4;
    CheckBox cbx5;
    CheckBox cbx6;
    CheckBox cbx7;
    CheckBox cbx8;
    CheckBox cbx9;
    CheckBox cbx0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        cbx1=(CheckBox)findViewById(R.id.checkBox1);
        cbx2=(CheckBox)findViewById(R.id.checkBox2);
        cbx3=(CheckBox)findViewById(R.id.checkBox3);
        cbx4=(CheckBox)findViewById(R.id.checkBox4);
        cbx5=(CheckBox)findViewById(R.id.checkBox5);
        cbx6=(CheckBox)findViewById(R.id.checkBox6);
        cbx7=(CheckBox)findViewById(R.id.checkBox7);
        cbx8=(CheckBox)findViewById(R.id.checkBox8);
        cbx9=(CheckBox)findViewById(R.id.checkBox9);
        cbx0=(CheckBox)findViewById(R.id.checkBox10);

        Book b=new Book();
        cbx1.setText("");
        cbx2.setText("");
        cbx3.setText("");
        cbx4.setText("");
        cbx5.setText("");
        cbx6.setText("");
        cbx7.setText("");
        cbx8.setText("");
        cbx9.setText("");
        cbx0.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
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
