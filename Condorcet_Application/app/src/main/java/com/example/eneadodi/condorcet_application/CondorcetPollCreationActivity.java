package com.example.eneadodi.condorcet_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eneadodi.condorcet_application.List_View_Classes.ChoiceInputListView;
import com.example.eneadodi.condorcet_application.List_View_Classes.ChoiceInputPollCreationLVInformation;
import com.example.eneadodi.condorcet_application.List_View_Classes.DirectoryLVInformation;
import com.example.eneadodi.condorcet_application.List_View_Classes.PollCreationListView;

import java.util.ArrayList;

public class CondorcetPollCreationActivity extends AppCompatActivity {

    private ImageButton view_recipients;
    private ImageButton add_recipients;
    private Button finish;
    private ImageButton add_option;

    private ListView options_created;
    private EditText title_name;

    private int[] counter = {1,2,3,4};
    private int[] value = {50,50,50,50};
    private String[] nameOfCategory = {"","","",""};

    private PollCreationListView poll_options_lv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condorcet__poll__creation_);
        ArrayList<ChoiceInputPollCreationLVInformation> lv_information = fillListViewInformation();
        poll_options_lv_adapter = new PollCreationListView(this, lv_information);
        view_recipients = (ImageButton) findViewById(R.id.view_Recipients_Button);
        add_recipients = (ImageButton) findViewById(R.id.add_Recipients_Button);
        finish = (Button) findViewById(R.id.finish_Button);

        add_option = (ImageButton) findViewById(R.id.Poll_Creation_add_another_option);
        add_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poll_options_lv_adapter.addOption();
                poll_options_lv_adapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(getApplicationContext(),"hellp",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //List view related

        options_created = (ListView)findViewById(R.id.Poll_Creation_Created_Options);
        options_created.setAdapter(poll_options_lv_adapter);
        //ObjectMapper mapper = new ObjectMapper();
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
