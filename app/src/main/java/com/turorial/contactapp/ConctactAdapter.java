package com.turorial.contactapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ConctactAdapter extends BaseAdapter {
    private Context mcontext ;
    private ArrayList<Personnes> mPersonnes ;

    public ConctactAdapter(Context mcontext, ArrayList<Personnes> mPersonnes) {
        this.mcontext = mcontext;
        this.mPersonnes = mPersonnes;
    }

    @Override
    public int getCount() {

        return mPersonnes.size();
    }

    @Override
    public Object getItem(int i) {
        return mPersonnes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(mcontext,R.layout.contats,null);
        TextView tvname = (TextView)v.findViewById(R.id.text1);
        TextView tvemail=(TextView)v.findViewById(R.id.text22);
        TextView tvstreet=(TextView)v.findViewById(R.id.text5);
        TextView tvcity=(TextView)v.findViewById(R.id.text4);
        TextView tvphone=(TextView)v.findViewById(R.id.text3);



        tvname.setText(mPersonnes.get(i).getName());
        tvemail.setText(mPersonnes.get(i).getEmail());
        tvstreet.setText(mPersonnes.get(i).getStreet());
        tvcity.setText(mPersonnes.get(i).getCity());
        tvphone.setText(mPersonnes.get(i).getPhone());

      //  v.setTag(mPersonnes.get(i).getId());
        return v;
    }
}
