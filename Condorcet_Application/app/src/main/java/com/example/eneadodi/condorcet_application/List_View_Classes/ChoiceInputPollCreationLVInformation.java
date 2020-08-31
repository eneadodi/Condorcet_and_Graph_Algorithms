package com.example.eneadodi.condorcet_application.List_View_Classes;

import java.util.Objects;

public class ChoiceInputPollCreationLVInformation {
    private Integer counter;
    private Integer choiceValue;
    private String choiceName;


    /*
    Default Constructor
     */
    public ChoiceInputPollCreationLVInformation(){

    }

    /*
    Constructor
    Parameters: int counter, int choiceValue, String choiceName
     */
    public ChoiceInputPollCreationLVInformation(int counter, int choiceValue, String choiceName){
        this.counter = counter;
        this.choiceValue = choiceValue;
        this.choiceName = choiceName;
    }



    //GETTERS AND SETTERS
    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getChoiceValue() {
        return choiceValue;
    }

    public void setChoiceValue(Integer choiceValue) {
        this.choiceValue = choiceValue;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }
    //END OF GETTERS AND SETTERS

    //TOSTRING, EQUALS, AND HASHCODE
    @Override
    public String toString() {
        return "ChoiceInputPollCreationLVInformation{" +
                "counter=" + counter +
                ", choiceValue=" + choiceValue +
                ", choiceName='" + choiceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceInputPollCreationLVInformation)) return false;
        ChoiceInputPollCreationLVInformation that = (ChoiceInputPollCreationLVInformation) o;
        return Objects.equals(getCounter(), that.getCounter()) &&
                Objects.equals(getChoiceValue(), that.getChoiceValue()) &&
                Objects.equals(getChoiceName(), that.getChoiceName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCounter(), getChoiceValue(), getChoiceName());
    }
    //END OF TOSTRING, EQUALS, AND HASHCODE
}
