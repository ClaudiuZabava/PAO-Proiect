package Utilizator;

public class Contact {
    private String email_personal;
    private String email_institutional;
    private int telefon;

    public Contact(){}
    public Contact(String e1, String e2, int tel)
    {
        this.email_personal = e1;
        this.email_institutional = e2;
        this.telefon = tel;
    }

    public String get_email1(){ return email_personal;}
    public void set_email1(String e1){ this.email_personal = e1;}

    public String get_email2(){ return email_institutional;}
    public void set_email2(String e2){ this.email_institutional = e2;}

    public int get_tel(){ return telefon;}
    public void set_tel(int nr){ this.telefon = nr;}

    public String toString() {
        return "< email personal: " + this.email_personal + " ; email institutional: " + this.email_institutional + " ; telefon: " + this.telefon + " >";
    }
}
