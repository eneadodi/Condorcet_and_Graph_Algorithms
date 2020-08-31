package com.example.eneadodi.condorcet_application.Condorcet_Tideman_Algorithms_and_Classes;

public class Option {

    private String optionName;
    private int optionScore;
    private boolean modified = false;
    private final static int MAX_SCORE = 100;
    private final static int MIN_SCORE  = 0;
    /*
    Default Constructor. Dummy Constructor that probably never will be used.
     */
    public Option(){
        optionName = "none";
        optionScore = 0;
    }

    /*
    Constructor
    Parameters: String optionName, int optionScore
    Sets the private variables optionName and optionScore to their corresponding parameters.
    */
    public Option(String optionName, int optionScore){
        this.optionName = optionName;
        this.optionScore = optionScore;
        this.modified = true;
    }

    //Getters and Setters for Option Class
    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionScore(){
        return optionScore;
    }

    public void setOptionScore(int optionScore) {
        this.optionScore = optionScore;
        this.modified = true;
    }
    //END Getters and Setters


}
