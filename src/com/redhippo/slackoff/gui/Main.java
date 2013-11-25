package com.redhippo.slackoff.gui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.redhippo.slackoff.R;
import com.redhippo.slackoff.module.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Activity implements DialogInterface.OnClickListener  {

    private ListView listView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Database.load();

        listView = (ListView)findViewById(R.id.yearListView);

        List<String> years = new ArrayList<String>();
        for (int i = 0; i < Database.getYears().size(); i++)
            years.add("Year " + Database.getYears().get(i).getYear());


        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.yearlistviewitemlayout, years);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                //Or do whatever you need.
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        //Leave blank
    }
}
