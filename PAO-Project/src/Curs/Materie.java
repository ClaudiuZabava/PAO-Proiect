package Curs;

public class Materie
{
    private String denumire;
    private double nota_s;
    private Sala sala;

    public Materie(){}

    public Materie(String denumire, double nota_s, Sala sala)
    {
        this.denumire= denumire;
        this.nota_s = nota_s;
        this.sala = sala;
    }

    public String get_Denumire(){return denumire;}
    public void set_Denumire(String d)
    {
        this.denumire = d;
    }

    public double get_Nota_student(){return nota_s;}
    public void set_Nota_student(double nt)
    {
        this.nota_s = nt;
    }

    public Sala get_Sala(){return sala;}
    public void set_Sala(Sala sala1)
    {
        this.sala = sala1;
    }

    public String toString(){
        return "< ->Nume materie: " + this.denumire + " ;  ->Sala: " + this.sala + " ;  ->Nota studentului: " + this.nota_s + ">";
    }
}
