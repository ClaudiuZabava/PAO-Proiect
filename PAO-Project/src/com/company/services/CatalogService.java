package com.company.services;

import com.company.catalog.Catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogService
{
    private List<Catalog> cat = new ArrayList<>();
    private static CatalogService instance;

    private CatalogService(){}

    public static CatalogService get_Instance(){
        if(instance == null){
            instance = new CatalogService();
        }
        return instance;
    }

    public List<Catalog> get_File() {
        List<Catalog> catC = new ArrayList<>();
        catC.addAll(this.cat);
        Collections.sort(catC);
        return catC;
    }

    public Catalog get_Fila_id(int id)
    {
        int check=0;
        Catalog catC = new Catalog();
        if(this.cat.size() <1)
        {
            return null;
        }
        else
        {
            for(int i = 0; i < this.cat.size(); ++i){
                if(this.cat.get(i).get_Id() == id)
                {
                    check=1;
                    catC = this.cat.get(i);
                    break;
                }
            }
        }
        if(check == 0)
            return null;
        else
            return catC;
    }
    public int check_existence(int id)
    {
        int check=0;
        if(this.cat.size() <1)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.cat.size(); ++i)
            {
                if(this.cat.get(i).get_Id() == id)
                {
                    check=1;
                    break;
                }
            }
        }
        return check;
    }

    public void catalog_Update(int id, Catalog catC)
    {
        int check=0;
        for(int i = 0; i < this.cat.size(); ++i)
        {
            if(this.cat.get(i).get_Id() == id)
            {
                check = 1;
                this.cat.remove(i);
                this.cat.add(i, catC);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Fila din catalog cu ID-ul specificat nu a fost gasit");
        }
        else
        {
            System.out.println("Update efectuat.");
        }
    }


    public void adauga_Fila(Catalog catC){
        this.cat.add(catC);
    }

    public void sterge_Fila_id(int id)
    {
        int check=0;
        for(int i = 0; i < this.cat.size(); ++i){
            if(this.cat.get(i).get_Id() == id)
            {
                check=1;
                this.cat.remove(i);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Fila din catalog cu ID-ul specificat nu a fost gasita");
        }
        else
        {
            System.out.println("Delete efectuat.");
        }
    }

    public void sterge_File(Catalog catC){
        for(int i = 0;i < this.cat.size(); ++i){
            if(this.cat.get(i).equals(catC)){
                this.cat.remove(i);
                break;
            }
        }
    }
}
