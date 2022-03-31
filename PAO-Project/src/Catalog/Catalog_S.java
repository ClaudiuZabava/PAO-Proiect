package Catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog_S
{
    private List<Catalog> cat = new ArrayList<>();
    private static Catalog_S instance;

    private Catalog_S(){}

    public static Catalog_S get_Instance(){
        if(instance == null){
            instance = new Catalog_S();
        }
        return instance;
    }

    public List<Catalog> get_File() {
        List<Catalog> cat_c = new ArrayList<>();
        cat_c.addAll(this.cat);
        Collections.sort(cat_c);
        return cat_c;
    }

    public Catalog get_Fila_id(int id)
    {
        Catalog cat_c = new Catalog();
        for(int i = 0; i < this.cat.size(); ++i){
            if(this.cat.get(i).get_Id() == id)
            {
                cat_c = this.cat.get(i);
            }
        }
        return cat_c;
    }

    public void catalog_Update(int id, Catalog cat_c){
        for(int i = 0; i < this.cat.size(); ++i){
            if(this.cat.get(i).get_Id() == id){
                this.cat.remove(i);
                this.cat.add(i, cat_c);
                break;
            }
        }
    }


    public void adauga_Fila(Catalog cat_c){
        this.cat.add(cat_c);
    }

    public void sterge_Fila_id(int id)
    {
        for(int i = 0; i < this.cat.size(); ++i){
            if(this.cat.get(i).get_Id() == id)
            {
                this.cat.remove(i);
                break;
            }
        }
    }

    public void sterge_File(Catalog cat_c){
        for(int i = 0;i < this.cat.size(); ++i){
            if(this.cat.get(i).equals(cat_c)){
                this.cat.remove(i);
                break;
            }
        }
    }
}
