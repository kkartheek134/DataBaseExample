package com.example.kartheek.dbexample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,email,mobile;

    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper helper;
    long id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        email = (EditText)findViewById(R.id.editText3);
        mobile = (EditText)findViewById(R.id.editText4);
        helper =  new DatabaseHelper(this);

    }

    public void saveDataIntoDatabase(View view) {

        String name = username.getText().toString().trim();
        String pass =  password.getText().toString().trim();
        String emailid =  email.getText().toString().trim();
        String mobilenumber = mobile.getText().toString().trim();

        if((!name.equals("")&& name!=null) && (!pass.equals("")&& pass!=null)&&(!emailid.equals("")&& emailid!=null)&&(!mobilenumber.equals("")&& mobilenumber!=null)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COL2, name);
            contentValues.put(DatabaseHelper.COL3, pass);
            contentValues.put(DatabaseHelper.COL4, emailid);
            contentValues.put(DatabaseHelper.COL5, mobilenumber);

            sqLiteDatabase = helper.getWritableDatabase();
            id = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        }
        else{
            username.setError("Enter something");
            password.setError("Enter something");
            email.setError("Enter something");
            mobile.setError("Enter something");
        }
        if(id>0)
        {
            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDataIntoListView(View view) {
        startActivity(new Intent(this,ListViewActivity.class));
    }
}
