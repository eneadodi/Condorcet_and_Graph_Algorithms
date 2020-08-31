package com.example.eneadodi.condorcet_application.Condorcet_Tideman_Algorithms_and_Classes;

public class EveryUserRanking {

    private AllOptions[] everyUserRank;//has the data about all
    private int size;//size of the everyUserRank
    private int currentIndex = 0;

    /*
    Default Constructor
    */
    public EveryUserRanking(){

    }

    /*
    Constructor
    Parameters: int size, int choosingMethod;
    sets private variable size to parameter size and
    sets size of everyUserRank to the private variable size;
     */
    public EveryUserRanking(int size){
        this.size = size;
        everyUserRank = new AllOptions[size];
    }

    /*
    Copy Constructor
    */
    public EveryUserRanking(EveryUserRanking other){
        everyUserRank = other.getEveryUserRank();
        size = other.getSize();
        currentIndex = other.getCurrentIndex();
    }

    //GETTERS AND SETTERS
    public AllOptions[] getEveryUserRank() {
        return everyUserRank;
    }

    public void setEveryUserRank(AllOptions[] everyUserRank) {
        this.everyUserRank = everyUserRank;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    //END OF GETTERS AND SETTERS
}
