package com.company.curs;

public class Sala
{
    private int etaj;
    private String codSala;

    public Sala(){}

    public Sala(int et, String cod)
    {
        this.etaj= et;
        this.codSala = cod;
    }

    public int get_Etaj(){return etaj;}
    public void set_Etaj(int et)
    {
        this.etaj = et;
    }

    public String get_Cod(){return codSala;}
    public void set_Cod(String cod)
    {
        this.codSala = cod;
    }


}
