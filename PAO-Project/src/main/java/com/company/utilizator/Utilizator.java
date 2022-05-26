package com.company.utilizator;

public abstract class Utilizator
{
    private int id;
    private String nume;
    private Contact info;
    private Adresa adresa;

    public Utilizator(){}

    public Utilizator(int id, String nume, Contact info, Adresa adresa) {
        this.id = id;
        this.nume = nume;
        this.info = info;
        this.adresa = adresa;
    }

    public int get_Id(){ return id; }
    public void set_Id(int id){ this.id = id; }

    public Contact get_Contact() { return this.info; }
    public void set_Contact( Contact info ) { this.info = info;}

    public Adresa get_Adresa() { return this.adresa; }
    public void set_Adresa( Adresa adr ) { this.adresa = adr;}

    public String get_Nume() { return nume; }
    public void set_Nume(String nume) { this.nume = nume; }

    public abstract void Date_Utilizator();
}
