package com.example.kartheek.dbexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.kartheek.dbexample.DatabaseHelper.TABLE_NAME;

public class ListViewActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper helper;
    Cursor cursor;

    String name,pass,email,mobile;

    ListView listView;
    List<String> names = new ArrayList<String>();
    List<String> passwords =  new ArrayList<String>();
    List<String> emails = new ArrayList<String>();
    List<String> mobiles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);
        helper = new DatabaseHelper(this);
        sqLiteDatabase = helper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT "+DatabaseHelper.COL2+","+DatabaseHelper.COL3+","+DatabaseHelper.COL4+","+DatabaseHelper.COL5+" FROM "+ TABLE_NAME,null);

        if(cursor!=null && cursor.getColumnCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do {
                    names.add(cursor.getString(0));
                    passwords.add(cursor.getString(1));
                    emails.add(cursor.getString(2));
                    mobiles.add(cursor.getString(3));
                }while(cursor.moveToNext());
            }
            else{
                Toast.makeText(this, "no data in cursor", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "not able to get data", Toast.LENGTH_SHORT).show();
        }


        //sqLiteDatabase.execSQL("SELECT "+DatabaseHelper.COL2+","+DatabaseHelper.COL3+","+DatabaseHelper.COL4+","+DatabaseHelper.COL5+" FROM "+ TABLE_NAME);
        CustomAdapter adapter = new CustomAdapter(this,names,passwords,emails,mobiles);
        listView.setAdapter(adapter);

    }

}
