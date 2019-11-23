package com.example.superbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChoosingActivity extends AppCompatActivity{
    private ListView listView;
    private ArrayAdapter adapter;
    String[] saloonsArray = {"mohammad","ahmad","adnan","zaher",
            "younes","ibraheem","luay","mazen"};

    String[][] availableTime = {{"10:30","11:00","11:30"},{"12:30","13:00","13:30"},{"14:30","15:00","15:30"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);

        adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, this.saloonsArray);

        listView = (ListView) findViewById(R.id.barbarlist);
        listView.setAdapter(adapter);


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
        // TODO Auto-generated method stub
        Toast.makeText(ChoosingActivity.this, availableTime[position%3][0] + ", " + availableTime[position%3][1], Toast.LENGTH_SHORT).show();
    }
    });
    }

}
