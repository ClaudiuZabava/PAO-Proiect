package com.company.utilizator;

import com.company.curs.Materie;

public class Profesor extends Utilizator
{
    private String rank;
    private Materie materie;

    public Profesor(){}
    public Profesor(int id, String nume, Contact info, Adresa adresa, String rank, Materie materie)
    {
        super(id,nume,info,adresa);
        this.rank = rank;
        this.materie = materie;

    }

    @Override
    public void Date_Utilizator()
    {
        System.out.println("com.company.curs: " + materie.get_Denumire());
        System.out.println("Cod Sala: " + materie.get_Sala().get_Cod());
        System.out.println("Etaj Sala: " + materie.get_Sala().get_Etaj());
        System.out.println("Nota obtinuta: " + materie.get_Nota_student());
        System.out.println("Info com.company.curs: " + get_Materie());
        System.out.println("Nume Profesor: " + get_Nume());
        System.out.println("Pozitia profesorului: " + get_Rank());
        System.out.println("Contact Info: " + get_Contact());
        System.out.println("Adresa: " + get_Adresa());
    }

    public String get_Rank() { return rank;}
    public void set_Rank(String r) { this.rank = r;}

    public Materie get_Materie() { return materie;}
    public void set_Materie(Materie materie) { this.materie = materie;}
}
