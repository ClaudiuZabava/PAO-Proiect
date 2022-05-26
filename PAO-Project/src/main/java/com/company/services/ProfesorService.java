package com.company.services;

import com.company.utilizator.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorService
{
    private List<Profesor> profesori = new ArrayList<>();
    private static ProfesorService instance;

    private ProfesorService(){}

    public static ProfesorService get_Instance(){
        if(instance == null){
            instance = new ProfesorService();
        }
        return instance;
    }


    public List<Profesor> get_Profesori()
    {
        List<Profesor> prof = new ArrayList<>();
        prof.addAll(this.profesori);
        return prof;
    }

    public Profesor get_Profesor_id(int id)
    {

        Profesor prof = new Profesor();
        int check=0;
        if(this.profesori.size() <1)
        {
            return null;
        }
        else
        {
            for(int i = 0; i < this.profesori.size(); ++i)
            {
                if(this.profesori.get(i).get_Id() == id)
                {
                    check=1;
                    prof = this.profesori.get(i);
                    break;
                }
            }
        }

        if(check == 0)
            return null;
        else
            return prof;
    }
    public int check_existence(int id)
    {
        int check=0;
        if(this.profesori.size() <1)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.profesori.size(); ++i)
            {
                if(this.profesori.get(i).get_Id() == id)
                {
                    check=1;
                    break;
                }
            }
        }
        return check;
    }

    public void profesor_Update(int id, Profesor prof)
    {
        int check=0;
        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).get_Id() == id)
            {
                check=1;
                this.profesori.remove(i);
                this.profesori.add(i, prof);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Profesorul cu ID-ul specificat nu a fost gasit");
        }
        else
        {
            System.out.println("Update efectuat.");
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
        int check=0;
        for(int i = 0; i < this.profesori.size(); ++i)
        {
            if(this.profesori.get(i).get_Id() == id)
            {
                check=1;
                this.profesori.remove(i);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Profesorul cu ID-ul specificat nu a fost gasit");
        }
        else
        {
            System.out.println("Delete efectuat.");
        }
    }

}
