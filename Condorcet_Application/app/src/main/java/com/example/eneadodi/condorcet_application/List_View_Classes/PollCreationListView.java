package com.example.eneadodi.condorcet_application.List_View_Classes;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.eneadodi.condorcet_application.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PollCreationListView extends ArrayAdapter<ChoiceInputPollCreationLVInformation> {
    private Activity context;
    private List<ChoiceInputPollCreationLVInformation> choice_information = new ArrayList<ChoiceInputPollCreationLVInformation>();

    /*
    Constructor for when the user inputs ArrayLists
     */
    public PollCreationListView(@NonNull Activity context, ArrayList<ChoiceInputPollCreationLVInformation> list){
        super(context,R.layout.poll_creation_list_view, list);
        this.context = context;
        choice_information = list;
    }

    //GETTERS AND SETTERS
    public List<ChoiceInputPollCreationLVInformation> getChoice_information() {
        return choice_information;
    }

    public void setChoice_information(List<ChoiceInputPollCreationLVInformation> choice_information) {
        this.choice_information = choice_information;
    }
    //END OF GETTERS AND SETTERS

    public void addOption(){

    }

    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        if(rowView == null)
            rowView = LayoutInflater.from(context).inflate(R.layout.poll_creation_list_view,parent,false);

        ChoiceInputPollCreationLVInformation current_info = choice_information.get(position);

        TextView choiceName_textview = (EditText) rowView.findViewById(R.id.Title_Of_Choice_PCLV);
        choiceName_textview.setText(current_info.getChoiceName());

        TextView counter_textview = (EditText) rowView.findViewById(R.id.index_choice_input_PCLV);
        counter_textview.setText(Integer.toString(current_info.getCounter()));

        EditText rankValue_edittext = (EditText) rowView.findViewById(R.id.value_preference_ET_PCLV);
        rankValue_edittext.setText(Integer.toString(current_info.getChoiceValue()));

        SeekBar rankValue_seekBar = (SeekBar) rowView.findViewById(R.id.value_preference_seekbar_PCLV);
        rankValue_seekBar.setProgress(current_info.getChoiceValue());

        rankValue_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //String.format("%02d", String.valueOf(progress))
                rankValue_edittext.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rowView;
    };
}
