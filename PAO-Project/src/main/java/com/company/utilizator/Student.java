package com.company.utilizator;

public class Student extends Utilizator{
    private int anStudiu;
    private String specializare;

    public Student(){}
    public Student(int id, String nume, Contact info, Adresa adresa, int anStudiu, String specializare)
    {
        super(id,nume,info,adresa);
        this.anStudiu = anStudiu;
        this.specializare = specializare;

    }

    @Override
    public void Date_Utilizator()
    {
        System.out.println("Nume Student: " + get_Nume());
        System.out.println("An de Studiu: " + get_An());
        System.out.println("Specializare: " + get_Specializare());
        System.out.println("Contact Info: " + get_Contact());
        System.out.println("Adresa: " + get_Adresa());
    }

    public int get_An() { return anStudiu;}
    public void set_An(int an) { this.anStudiu = an;}

    public String get_Specializare() { return specializare;}
    public void set_Specializare(String specializare) { this.specializare = specializare;}
}
