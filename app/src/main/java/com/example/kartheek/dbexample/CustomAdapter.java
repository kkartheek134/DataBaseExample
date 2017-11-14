package com.example.kartheek.dbexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kartheek on 11/14/2017.
 */

class CustomAdapter extends BaseAdapter{
    Context context;
    TextView uname,upass,uemail,umobile;
   List<String> names = new ArrayList<String>();
    List<String> passwords =  new ArrayList<String>();
    List<String> emails = new ArrayList<String>();
    List<String> mobiles = new ArrayList<String>();

    public CustomAdapter(Context context,List names, List passwords, List emails, List mobiles) {
        this.context = context;
        this.names = names;
        this.passwords = passwords;
        this.emails = emails;
        this.mobiles = mobiles;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlistview,parent,false);

        uname = (TextView)convertView.findViewById(R.id.textView6);
        upass = (TextView)convertView.findViewById(R.id.textView7);
        uemail = (TextView)convertView.findViewById(R.id.textView8);
        umobile = (TextView)convertView.findViewById(R.id.textView9);


        uname.setText(names.get(position));
        upass.setText(passwords.get(position));
        uemail.setText(emails.get(position));
        umobile.setText(mobiles.get(position));

        return convertView;
    }
}