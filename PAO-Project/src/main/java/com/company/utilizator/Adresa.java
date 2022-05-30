package com.company.utilizator;

public class Adresa
{
    private int id;
    private String tara;
    private String judet;
    private String oras;
    private String strada;

    public Adresa() {}

    public Adresa(int id, String tara, String judet, String oras, String strada) {
        this.id = id;
        this.tara = tara;
        this.judet = judet;
        this.oras = oras;
        this.strada = strada;
    }

    public int get_id(){return id;}
    public void set_id(int id) {this.id = id;}

    public String get_tara() { return tara; }
    public void set_tara(String tara) {
        this.tara = tara;
    }

    public String get_judet() {
        return judet;
    }
    public void set_judet(String judet) {this.judet = judet; }

    public String get_oras() {
        return oras;
    }
    public void set_oras(String oras) {
        this.oras = oras;
    }

    public String get_strada(){ return strada;}
    public void set_strada(String strada) { this.strada = strada;}

    public String toString(){
        return "< tara: " + this.tara + " ; judet: " + this.judet + " ; oras: " + this.oras + " ; strada: " + this.strada + ">";
    }
}
