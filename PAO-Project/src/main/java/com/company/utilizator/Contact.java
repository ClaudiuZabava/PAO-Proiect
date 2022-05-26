package com.company.utilizator;

public class Contact {
    private int id;
    private String emailPersonal;
    private String emailInstitutional;
    private int telefon;

    public Contact(){}
    public Contact(int id, String e1, String e2, int tel)
    {
        this.id = id;
        this.emailPersonal = e1;
        this.emailInstitutional = e2;
        this.telefon = tel;
    }

    public int get_id(){return id;}
    public void set_id(int id) {this.id = id;}

    public String get_email1(){ return emailPersonal;}
    public void set_email1(String e1){ this.emailPersonal = e1;}

    public String get_email2(){ return emailInstitutional;}
    public void set_email2(String e2){ this.emailInstitutional = e2;}

    public int get_tel(){ return telefon;}
    public void set_tel(int nr){ this.telefon = nr;}

    public String toString() {
        return "< email personal: " + this.emailPersonal + " ; email institutional: " + this.emailInstitutional + " ; telefon: " + this.telefon + " >";
    }
}
