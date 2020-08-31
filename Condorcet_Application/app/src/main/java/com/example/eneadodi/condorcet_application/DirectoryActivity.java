package com.example.eneadodi.condorcet_application;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eneadodi.condorcet_application.List_View_Classes.DirectoryLVInformation;
import com.example.eneadodi.condorcet_application.List_View_Classes.DirectoryListView;

import java.util.ArrayList;

public class DirectoryActivity extends AppCompatActivity {
    private FloatingActionButton create_poll;
    private ListView polls_involved_with;

    private String[] mainTitle ={"Food","President","Digitiation","Which dress?"};
    private String[] createdBy = {"John","Dillon","Emmanuel","Enea"};
    private int[] categories_amount = {14,255,24,12};
    private String[] sharedWith = {"Bla bla bla, bla, bal,bla bla, and 124 other..","Bla bla bla, bla, bal,bla bla, and 12 other.."
            ,"Bla bla bla, bla, bal,bla bla, and 14 other..","Bla bla bla, bla, bal,bla bla, and 5 other.."};
    private Integer[] color = {R.color.green,R.color.yellow,R.color.green,R.color.red};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_);

        create_poll = (FloatingActionButton) findViewById(R.id.Create_Poll_Button);
        create_poll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPollCreationActivity();
            }
        });

        ArrayList<DirectoryLVInformation> lv_information = fillListViewInformation();
        DirectoryListView directory_list_adapter = new DirectoryListView(this,lv_information);
        polls_involved_with = (ListView)findViewById(R.id.List_Directory);
        polls_involved_with.setAdapter(directory_list_adapter);

        polls_involved_with.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void startChoiceInputActivity(){
        Intent i = new Intent(this, ChoiceInputActivity.class);
        startActivity(i);
    }

    public void startPollCreationActivity(){
        Intent i = new Intent(this, CondorcetPollCreationActivity.class);
        startActivity(i);
    }

    /*
    fillListViewInformation
    primarily used for testing. Fills a directory arraylist to be used in list view
     */
    public ArrayList<DirectoryLVInformation> fillListViewInformation(){
        ArrayList<DirectoryLVInformation> info = new ArrayList<DirectoryLVInformation>();

        for(int i = 0; i < createdBy.length;i++){
            info.add(new DirectoryLVInformation(mainTitle[i],createdBy[i],sharedWith[i],categories_amount[i],color[i]));
        }
        return info;
    }

}
