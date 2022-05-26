package com.company.curs;

public class Sala
{
    private int id;
    private int etaj;
    private String codSala;

    public Sala(){}

    public Sala(int id, int et, String cod)
    {
        this.id = id;
        this.etaj= et;
        this.codSala = cod;
    }

    public int get_Id(){return id;}
    public void set_Id(int id)
    {
        this.id = id;
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
