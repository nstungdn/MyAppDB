package com.vdc.myappdb;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;


public class MainActivity extends ActionBarActivity {
    public DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*/--- thêm một bản ghi ---
        db.open();
        long id = db.insertContact("Wei-Meng Lee", "weimenglee@learn2develop.net");
        id = db.insertContact("Mary Jackson", "mary@jackson.com");
        db.close();

//-- lấy danh sách tất cả bản ghi ---
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();

//--- lấy một bản ghi theo id ---
        db.open();
        c = db.getContact(2);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();

//--- cập nhật bản ghi ---
        db.open();
        if (db.updateContact(1, "Wei-Meng Lee", "weimenglee@gmail.com"))
            Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
        db.close();

//--- xóa bản ghi ---
        db.open();
        if (db.deleteContact(1))
            Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
        db.close();
    }
*/
    //--- thêm một bản ghi ---
    public void ThemBanGhi(View view)
    {

//            DBAdapter db = new DBAdapter(this);
            db.open();
            long id = db.insertContact("Wei-Meng Lee", "weimenglee@learn2develop.net");
            id = db.insertContact("Mary Jackson", "mary@jackson.com");
            db.close();

    }

    //-- lấy danh sách tất cả bản ghi ---
    public void getAllRecord()
    {
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst()) {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }

    //--- lấy một bản ghi theo id ---
    public void getRecord(View view)
    {
        db.open();
        EditText mdulieu = (EditText) findViewById(R.id.dulieu);
        String banghi = mdulieu.getText().toString();
        long sooo = parseInt(banghi);
        Cursor c = db.getContact(sooo);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

//--- cập nhật bản ghi ---
    public void UpdateRecord(DBAdapter db, int bangghi)
    {
        db.open();
        if (db.updateContact(bangghi, "Wei-Meng Lee", "weimenglee@gmail.com"))
            Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
        db.close();
    }

    //--- xóa bản ghi ---
    public void DeleteRecord(View view)
    {
        EditText mdulieu = (EditText) findViewById(R.id.dulieu);
        String banghi = mdulieu.getText().toString();
        long sooo = parseInt(banghi);
        db.open();
        if (db.deleteContact(sooo))
            Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email:  " + c.getString(2),
                Toast.LENGTH_LONG).show();
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
