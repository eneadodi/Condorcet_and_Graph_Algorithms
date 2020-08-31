package com.example.eneadodi.condorcet_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eneadodi.condorcet_application.List_View_Classes.ChoiceInputListView;
import com.example.eneadodi.condorcet_application.List_View_Classes.ChoiceInputPollCreationLVInformation;

import java.util.ArrayList;

public class ChoiceInputActivity extends AppCompatActivity {

    ListView poll_options;

    private int[] counter = {1,2,3,4};
    private int[] value = {50,0,30,80};
    private String[] nameOfCategory = {"pinapple","apple","blueberry","strawberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice__input_);

        ArrayList<ChoiceInputPollCreationLVInformation> lv_information = fillListViewInformation();
        ChoiceInputListView poll_options_lv_adapter = new ChoiceInputListView(this, lv_information);

        poll_options = (ListView)findViewById(R.id.Condorcet_Choice_Input_List);
        poll_options.setAdapter(poll_options_lv_adapter);

        poll_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    /*
    fillListViewInformation
    primarily used for testing. Fills a directory arraylist to be used in list view
    */
    public ArrayList<ChoiceInputPollCreationLVInformation> fillListViewInformation(){
        ArrayList<ChoiceInputPollCreationLVInformation> info = new ArrayList<ChoiceInputPollCreationLVInformation>();

        for(int i = 0; i < counter.length;i++){
            info.add(new ChoiceInputPollCreationLVInformation(counter[i],value[i],nameOfCategory[i]));
        }
        return info;
    }
}
