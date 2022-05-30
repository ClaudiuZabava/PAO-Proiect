package com.company.services;

import com.company.utilizator.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService
{
    private List<Student> studenti = new ArrayList<>();
    private static StudentService instance;

    private StudentService(){}

    public static StudentService get_Instance(){
        if(instance == null){
            instance = new StudentService();
        }
        return instance;
    }

    public List<Student> get_Studenti()
    {
        List<Student> studenti2 = new ArrayList<>();
        studenti2.addAll(this.studenti);
        return studenti2;
    }
    public int check_existence(int id)
    {
        int check=0;
        if(this.studenti.size() <1)
        {
            return 0;
        }
        else
        {
            for(int i = 0; i < this.studenti.size(); ++i)
            {
                if(this.studenti.get(i).get_Id() == id)
                {
                    check=1;
                    break;
                }
            }
        }
        return check;
    }

    public Student get_Student_id(int id)
    {

        Student student = new Student();
        int check=0;
        if(this.studenti.size() <1)
        {
            return null;
        }
        else
        {
            for(int i = 0; i < this.studenti.size(); ++i)
            {
                if(this.studenti.get(i).get_Id() == id)
                {
                    check=1;
                    student = this.studenti.get(i);
                    break;
                }
            }
        }
        if(check == 0)
            return null;
        else
            return student;
    }

    public void student_Update(int id, Student student)
    {
        int check=0;
        for(int i = 0; i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).get_Id() == id)
            {
                check = 1;
                this.studenti.remove(i);
                this.studenti.add(i, student);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Studentul cu ID-ul specificat nu a fost gasit");
        }
        else
        {
            System.out.println("Update efectuat.");
        }
    }

    public void student_Add(Student student)
    {
        this.studenti.add(student);
    }

    public void student_Remove(Student student)
    {
        for(int i = 0;i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).equals(student))
            {
                this.studenti.remove(i);
                break;
            }
        }
    }

    public void student_Remove_id(int id)
    {
        int check=0;
        for(int i = 0; i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).get_Id() == id)
            {
                check=1;
                this.studenti.remove(i);
                break;
            }
        }
        if(check == 0)
        {
            System.out.println("Studentul cu ID-ul specificat nu a fost gasit");
        }
        else
        {
            System.out.println("Delete efectuat.");
        }
    }
}
