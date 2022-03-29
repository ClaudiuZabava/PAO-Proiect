package Services;

import Utilizator.Student;
import java.util.ArrayList;
import java.util.List;

public class Student_S
{
    private List<Student> studenti = new ArrayList<>();
    private static Student_S instance;

    private Student_S(){}

    public static Student_S get_Instance(){
        if(instance == null){
            instance = new Student_S();
        }
        return instance;
    }

    public List<Student> get_Studenti()
    {
        List<Student> studenti2 = new ArrayList<>();
        studenti2.addAll(this.studenti);
        return studenti2;
    }

    public Student get_Student_id(int id){

        Student student = new Student();

        for(int i = 0; i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).get_Id() == id)
            {
                student = this.studenti.get(i);
            }
        }
        return student;
    }

    public void student_Update(int id, Student student)
    {
        for(int i = 0; i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).get_Id() == id)
            {
                this.studenti.remove(i);
                this.studenti.add(i, student);
                break;
            }
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
        for(int i = 0; i < this.studenti.size(); ++i)
        {
            if(this.studenti.get(i).get_Id() == id)
            {
                this.studenti.remove(i);
                break;
            }
        }
    }
}
