package Catalog;

import Utilizator.Student;
import Utilizator.Profesor;

import java.util.HashSet;

public class Catalog
{
    private int id;
    private Student student;
    private HashSet<Profesor> profesori;

    public Catalog(){}

    public Catalog(int id, Student student, HashSet<Profesor> profesori) {
        this.student = student;
        this.profesori = profesori;
    }

    public int get_Id() {
        return id;
    }
    public void set_Id(int id) {
        this.id = id;
    }

    public Student get_Studenti() {
        return student;
    }
    public void set_Studenti(Student st) {
        this.student = st;
    }

    public HashSet get_Profesori() {
        return profesori;
    }
    public void set_Profesori(HashSet profesori) {
        this.profesori = profesori;
    }



}
