package com.company.curs;

public class Materie
{
    private int id;
    private String denumire;
    private double notaS;
    private Sala sala;

    public Materie(){}

    public Materie(int id, String denumire, double notaS, Sala sala)
    {
        this.id = id;
        this.denumire= denumire;
        this.notaS = notaS;
        this.sala = sala;
    }

    public int get_id(){return id;}
    public void set_id(int id) {this.id = id;}

    public String get_Denumire(){return denumire;}
    public void set_Denumire(String d)
    {
        this.denumire = d;
    }

    public double get_Nota_student(){return notaS;}
    public void set_Nota_student(double nt)
    {
        this.notaS = nt;
    }

    public Sala get_Sala(){return sala;}
    public void set_Sala(Sala sala1)
    {
        this.sala = sala1;
    }

    public String toString(){
        return "< ->Nume materie: " + this.denumire + " ;  ->Sala: " + this.sala.get_Cod() + " ;  ->Nota studentului: " + this.notaS + ">";
    }
}
