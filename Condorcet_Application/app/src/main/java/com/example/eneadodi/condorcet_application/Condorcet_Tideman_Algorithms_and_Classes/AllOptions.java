package com.example.eneadodi.condorcet_application.Condorcet_Tideman_Algorithms_and_Classes;

import java.util.ArrayList;

public class AllOptions {
    private ArrayList<Option> allOptions = new ArrayList<Option>();


    /*
    Default Constructor:
    Will mostly be the one called.
     */
    public AllOptions(){

    }

    /*
    Constructor
    Parameter: ArrayList<Option> auc
    starts off the arrayList in this AllOptions with a inital state.
     */
    public AllOptions(ArrayList<Option> auc){
        for(int i = 0; i < auc.size(); i++){
            addOption(auc.get(i));
        }
    }

    /*
    Copy Constructor
     */
    public AllOptions(AllOptions other){
        allOptions = other.getAllOptions();
    }

    /*
    addOption method.
    Parameter: Option o - option to be added
    adds Option to ArrayList and orders the arrayList after.
     */
    public void addOption(Option o){
        allOptions.add(o);
    }

    //Getters and Setters
    public ArrayList<Option> getAllOptions() {
        return allOptions;
    }

    public void setallOptions(ArrayList<Option> allOptions) {
        this.allOptions = allOptions;
    }
    //END GETTERS AND SETTERS

}
