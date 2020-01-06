package com.turorial.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler mydb ;
    private ListView objt ;
    ConctactAdapter adapter ;
    public ArrayList<Personnes> arrayList ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        objt = findViewById(R.id.list);

        mydb = new DatabaseHandler(getApplicationContext());



        try {
            arrayList = mydb.getAllContacts();
        }catch (NullPointerException e){

        }


      /*  for (Personnes per: arrayList
             ) {
            if(per==null){
                arrayList.remove(per);
            }
        }*/









     /*   new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList = mydb.getAllContacts();
            }
        }).start(); */



        /*arrayList = new ArrayList<>() ;
        arrayList.add(new Personnes(1,  "ayisp","@jd","moliko","buea","5444"));
        arrayList.add(new Personnes(1,  "nke","joel@","serba","temba","5444"));*/

      adapter = new ConctactAdapter(getApplicationContext(),arrayList);
        adapter.notifyDataSetChanged();
        objt.setAdapter(adapter);
        objt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             /*  int id_To_Search = i + 1 ;
                Bundle databundle = new Bundle() ;
                databundle.putInt("id",id_To_Search);*/
                Intent intent = new Intent(getApplicationContext(),Modified.class);
                //intent.putExtra("databundle",databundle);
                intent.putExtra("ca",arrayList.get(i)) ;
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        // getMenuInflater().inflate(R.menu.menu_main,menu);

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){

            case R.id.item1: Bundle dataBundle = new Bundle() ;
                dataBundle.putInt("id",0);

                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
                intent.putExtra("bundle",dataBundle);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }
}
