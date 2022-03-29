package Curs;

public class Sala
{
    private int etaj;
    private String cod_sala;

    public Sala(){}

    public Sala(int et, String cod)
    {
        this.etaj= et;
        this.cod_sala = cod;
    }

    public int get_Etaj(){return etaj;}
    public void set_Etaj(int et)
    {
        this.etaj = et;
    }

    public String get_Cod(){return cod_sala;}
    public void set_Cod(String cod)
    {
        this.cod_sala = cod;
    }


}
