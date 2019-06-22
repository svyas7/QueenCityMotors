package com.uncc.sharat.model;

public class UserOption{
    public enum UserSelection {SALES,SERVICING}
    public enum UserType {CUSTOMER,EMPLOYEE}
    private static UserType type;
    private static UserSelection selection;
    public UserOption(String userSelection, String userType){
        type = UserType.valueOf(userType.toUpperCase());
        selection = UserSelection.valueOf(userSelection.toUpperCase());
    }
    public UserType getType(){ return type;}
    public UserSelection getSelection() {return selection;}
}
