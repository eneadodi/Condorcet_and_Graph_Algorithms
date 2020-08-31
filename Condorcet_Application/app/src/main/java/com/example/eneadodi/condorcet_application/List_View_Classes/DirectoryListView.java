package com.example.eneadodi.condorcet_application.List_View_Classes;

import android.app.Activity;

import android.content.res.ColorStateList;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eneadodi.condorcet_application.R;

import java.util.ArrayList;
import java.util.List;

public class DirectoryListView extends ArrayAdapter<DirectoryLVInformation> {

    private Activity context;
    private List<DirectoryLVInformation> directoryList = new ArrayList<DirectoryLVInformation>();

    public DirectoryListView(@NonNull Activity context, @LayoutRes ArrayList<DirectoryLVInformation> directoryList){
        super(context, R.layout.directory_list_view, directoryList);
        this.context = context;
        this.directoryList = directoryList;
    }

    //GETTERS AND SETTERS
    public void setContext(Activity context) {
        this.context = context;
    }

    public List<DirectoryLVInformation> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<DirectoryLVInformation> directoryList) {
        this.directoryList = directoryList;
    }
    //END OF GETTERS AND SETTERS

    //Overall form was taught by: https://medium.com/mindorks/custom-array-adapters-made-easy-b6c4930560dd
    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {

        View rowView = view;
        if(rowView == null){
            rowView = LayoutInflater.from(context).inflate(R.layout.directory_list_view,parent,false);
        }

        DirectoryLVInformation currentInformation = directoryList.get(position);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        titleText.setText(currentInformation.getMain_title());

        TextView created_by_text = (TextView) rowView.findViewById(R.id.subtitle1_Created_By);
        created_by_text.setText(currentInformation.getCreated_by());

        TextView categories_text = (TextView) rowView.findViewById(R.id.subtitle2_Categories);
        categories_text.setText(Integer.toString(currentInformation.getCategories()));

        TextView shared_with_text = (TextView) rowView.findViewById(R.id.subtitle3_Shared_With);
        shared_with_text.setText(currentInformation.getShared_with());

        ImageView barView = (ImageView) rowView.findViewById(R.id.bar);
        barView.setImageResource(currentInformation.getBar());

        return rowView;

    };

}
