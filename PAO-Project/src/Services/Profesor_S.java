package Services;

import Utilizator.Profesor;

import java.util.ArrayList;
import java.util.List;

public class Profesor_S
{
    private List<Profesor> profesori = new ArrayList<>();
    private static Profesor_S instance;

    private Profesor_S(){}

    public static Profesor_S get_Instance(){
        if(instance == null){
            instance = new Profesor_S();
        }
        return instance;
    }


    public List<Profesor> get_Profesori()
    {
        List<Profesor> prof = new ArrayList<>();
        prof.addAll(this.profesori);
        return prof;
    }

    public Profesor get_Profesor_id(int id){

        Profesor prof = new Profesor();

        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).get_Id() == id)
            {
                prof = this.profesori.get(i);
            }
        }
        return prof;
    }

    public void profesor_Update(int id, Profesor prof)
    {
        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).get_Id() == id)
            {
                this.profesori.remove(i);
                this.profesori.add(i, prof);
                break;
            }
        }
    }

    public void profesor_Add(Profesor prof)
    {
        this.profesori.add(prof);
    }

    public void profesor_Remove(Profesor prof)
    {
        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).equals(prof))
            {
                this.profesori.remove(i);
                break;
            }
        }
    }

    public void profesor_Remove_id(int id)
    {
        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).get_Id() == id)
            {
                this.profesori.remove(i);
                break;
            }
        }
    }

}
