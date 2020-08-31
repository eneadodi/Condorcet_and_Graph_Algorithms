package com.example.eneadodi.condorcet_application.List_View_Classes;

import java.util.Objects;

public class DirectoryLVInformation {

    private String main_title;
    private String created_by;
    private String shared_with;
    private Integer categories;
    private Integer bar;

    public DirectoryLVInformation(){

    }

    public DirectoryLVInformation(String main_title, String created_by, String shared_with,int categories, int bar){
        this.main_title = main_title;
        this.created_by = created_by;
        this.shared_with = shared_with;
        this.categories = new Integer(categories);
        this.bar = new Integer(bar);
    }

    //GETTERS AND SETTERS
    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getShared_with() {
        return shared_with;
    }

    public void setShared_with(String shared_with) {
        this.shared_with = shared_with;
    }

    public Integer getCategories() {
        return categories;
    }

    public void setCategories(Integer categories) {
        this.categories = categories;
    }

    public Integer getBar() {
        return bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar;
    }
    //END OF GETTERS AND SETTERS

    //TOSTRING,EQUALS AND HASH CODE

    @Override
    public String toString() {
        return "DirectoryLVInformation{" +
                "main_title='" + main_title + '\'' +
                ", created_by='" + created_by + '\'' +
                ", shared_with='" + shared_with + '\'' +
                ", categories=" + categories +
                ", bar=" + bar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectoryLVInformation)) return false;
        DirectoryLVInformation that = (DirectoryLVInformation) o;
        return Objects.equals(getMain_title(), that.getMain_title()) &&
                Objects.equals(getCreated_by(), that.getCreated_by()) &&
                Objects.equals(getShared_with(), that.getShared_with()) &&
                Objects.equals(getCategories(), that.getCategories()) &&
                Objects.equals(getBar(), that.getBar());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMain_title(), getCreated_by(), getShared_with(), getCategories(), getBar());
    }

    //END OF TOSTRING,EQUALS AND HASH CODE


}
