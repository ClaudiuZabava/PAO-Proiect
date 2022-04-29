package com.company.services;


import com.company.catalog.Catalog;
import com.company.curs.Materie;
import com.company.curs.Sala;
import com.company.utilizator.Adresa;
import com.company.utilizator.Contact;
import com.company.utilizator.Profesor;
import com.company.utilizator.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ReadService
{

    private ProfesorService prof_service = ProfesorService.get_Instance();
    private StudentService student_service = StudentService.get_Instance();
    private CatalogService catalog_service = CatalogService.get_Instance();

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    //Student attributes index
    private static final String FILE_HEADER1 = "id, tara, judet, oras, strada";
    private static final String FILE_HEADER2 = "id, emailPersonal, emailInstitutional, telefon";
    private static final String FILE_HEADER3 = "codSala, etaj";
    private static final String FILE_HEADER4 = "id, denumire, notaS, codSala";
    private static final String FILE_HEADER5 = "id, nume, idContact, idAdresa, rank, idMaterie";
    private static final String FILE_HEADER6 = "id, nume, idContact, idAdresa, anStudiu, specializare";
    private static final String FILE_HEADER7 = "id, idStudent, idsProfesori...";


    private static ReadService instance;

    private ReadService(){}

    public static ReadService get_Instance(){
        if(instance == null){
            instance = new ReadService();
        }
        return instance;
    }

    public static List<Adresa> readCsvAdresa(String fileName)
    {

        BufferedReader fileReader = null;

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER1.toString()))
            {
//                System.out.println("Header Adresa");
                return null;
            }

            List<Adresa> adrese = new ArrayList<>();


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Adresa adresa = new Adresa( Integer.parseInt(tokens[0]) ,tokens[1], tokens[2], tokens[3], tokens[4]);
                    adrese.add(adresa);
                }
            }
            if( adrese.size()>=1)
            {
                return adrese;
            }
            else
            {
//                System.out.println("Read adresa");
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;

    }

    public static List<Contact> readCsvContact(String fileName)
    {

        BufferedReader fileReader = null;

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER2.toString()))
            {
//                System.out.println("header contact");
                return null;
            }

            List<Contact> infos = new ArrayList<>();


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Contact info = new Contact( Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    infos.add(info);
                }
            }
            if( infos.size()>=1)
            {
                return infos;
            }
            else
            {
//                System.out.println("Read contact");
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;

    }

    public static List<Sala> readCsvSala(String fileName)
    {

        BufferedReader fileReader = null;

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER3.toString()))
            {
//                System.out.println("header sala");
                return null;
            }

            List<Sala> infos = new ArrayList<>();


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Sala info = new Sala(Integer.parseInt(tokens[1]), tokens[0]);
                    infos.add(info);
                }
            }
            if( infos.size()>=1)
            {
                return infos;
            }
            else
            {
//                System.out.println("Read sala");
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;

    }

    public static List<Materie> readCsvMaterie(String fileName)
    {

        BufferedReader fileReader = null;

        String path = "src/com/company/date/sali.csv";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        List<Sala> sl = readCsvSala(absolutePath);

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER4.toString()))
            {
//                System.out.println("header materie");
                return null;
            }
            if(sl == null || sl.size() < 1)
            {
//                System.out.println("Read sala din materie");
                return null;
            }

            List<Materie> infos = new ArrayList<>();


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0)
                {
                    Sala st = new Sala();
                    int check=0;
                    for(int i = 0; i < sl.size(); ++i)
                    {
                        if(Objects.equals(sl.get(i).get_Cod(), tokens[3]))
                        {
                            check=1;
                            st = sl.get(i);
                            break;
                        }
                    }
                    //Create a new student object and fill his  data
                    if(check == 0)
                    {
//                        System.out.println("Read materie 1");
                        return null;
                    }

                    Materie info = new Materie(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), st);
                    infos.add(info);

                }
            }
            if( infos.size()>=1)
            {
                return infos;
            }
            else
            {
//                System.out.println("Read materie 2");
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;

    }

    public int readCsvProfesor(String fileName)
    {

        BufferedReader fileReader = null;

        String path1 = "src/com/company/date/materii.csv";
        File file1 = new File(path1);
        String absolutePath1 = file1.getAbsolutePath();
        String path2 = "src/com/company/date/contacte.csv";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String path3 = "src/com/company/date/adrese.csv";
        File file3 = new File(path3);
        String absolutePath3 = file3.getAbsolutePath();


        List<Materie> mat = readCsvMaterie(absolutePath1);
        List<Contact> cts = readCsvContact(absolutePath2);
        List<Adresa> adrs = readCsvAdresa(absolutePath3);

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER5.toString()))
            {
                return 0;
            }
            if((mat == null || mat.size() < 1) || (cts == null || cts.size() < 1) || (adrs == null || adrs.size() < 1))
            {
                return 0;
            }

            int check=0;


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0)
                {

                    Contact ct = new Contact();
                    int check1=0;
                    for(int i = 0; i < cts.size(); ++i)
                    {
                        if(cts.get(i).get_id() == Integer.parseInt(tokens[2]))
                        {
                            check1=1;
                            ct = cts.get(i);
                            break;
                        }
                    }
                    if(check1 == 0)
                    {
                        return 0;
                    }


                    Adresa adr = new Adresa();
                    int check2=0;
                    for(int i = 0; i < adrs.size(); ++i)
                    {
                        if(adrs.get(i).get_id() == Integer.parseInt(tokens[3]))
                        {
                            check2=1;
                            adr = adrs.get(i);
                            break;
                        }
                    }
                    if(check2 == 0)
                    {
                        return 0;
                    }


                    Materie mm = new Materie();
                    int check3=0;
                    for(int i = 0; i < mat.size(); ++i)
                    {
                        if(mat.get(i).get_id() == Integer.parseInt(tokens[5]))
                        {
                            check3=1;
                            mm = mat.get(i);
                            break;
                        }
                    }
                    if(check3 == 0)
                    {
                        return 0;
                    }


                    Profesor info = new Profesor(Integer.parseInt(tokens[0]), tokens[1], ct,adr, tokens[4], mm);
                    prof_service.profesor_Add(info);
                    check=1;

                }
            }
            return check;
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return 0;

    }


    public int readCsvStudent(String fileName)
    {

        BufferedReader fileReader = null;
        String path2 = "src/com/company/date/contacte.csv";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String path3 = "src/com/company/date/adrese.csv";
        File file3 = new File(path3);
        String absolutePath3 = file3.getAbsolutePath();



        List<Contact> cts = readCsvContact(absolutePath2);
        List<Adresa> adrs = readCsvAdresa(absolutePath3);

        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER6.toString()))
            {
                return 0;
            }
            if((cts == null || cts.size() < 1) || (adrs == null || adrs.size() < 1))
            {
                return 0;
            }

            int check=0;


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0)
                {

                    Contact ct = new Contact();
                    int check1=0;
                    for(int i = 0; i < cts.size(); ++i)
                    {
                        if(cts.get(i).get_id() == Integer.parseInt(tokens[2]))
                        {
                            check1=1;
                            ct = cts.get(i);
                            break;
                        }
                    }
                    if(check1 == 0)
                    {
                        return 0;
                    }


                    Adresa adr = new Adresa();
                    int check2=0;
                    for(int i = 0; i < adrs.size(); ++i)
                    {
                        if(adrs.get(i).get_id() == Integer.parseInt(tokens[3]))
                        {
                            check2=1;
                            adr = adrs.get(i);
                            break;
                        }
                    }
                    if(check2 == 0)
                    {
                        return 0;
                    }

                    Student info = new Student(Integer.parseInt(tokens[0]), tokens[1], ct,adr, Integer.parseInt(tokens[4]), tokens[5]);
                    student_service.student_Add(info);
                    check=1;

                }
            }
            return check;
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return 0;

    }

    public int readCsvCatalog(String fileName)
    {

        BufferedReader fileReader = null;
        String path2 = "src/com/company/date/studenti.csv";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        String path3 = "src/com/company/date/profesori.csv";
        File file3 = new File(path3);
        String absolutePath3 = file3.getAbsolutePath();



        if( readCsvStudent(absolutePath2)==0 || readCsvProfesor(absolutePath3)==0)
        {
            System.out.println("Students and Profs error");
            return 0;
        }


        try {

            //Create a new list of student to be filled by CSV file data

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));


            if(!Objects.equals(fileReader.readLine(), FILE_HEADER7.toString()))
            {
                System.out.println("header error");
                return 0;
            }
            if((student_service.get_Studenti().size() < 1) || (prof_service.get_Profesori().size() < 1))
            {
                System.out.println("students and profs err 2");
                return 0;
            }

            int check=0;


            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0)
                {


                    int check1=0;
                    int k1=-1;
                    for(int i = 0; i < student_service.get_Studenti().size(); ++i)
                    {
                        if(student_service.get_Studenti().get(i).get_Id() == Integer.parseInt(tokens[1]))
                        {
                            check1=1;
                            k1=i;
                            break;
                        }
                    }
                    if(check1 == 0)
                    {
                        System.out.println(" check students error");
                        return 0;
                    }

                    HashSet<Profesor> pp = new HashSet<>();
                    for(int j=2;  j< tokens.length; ++j)
                    {
                        int check2 = 0;
                        for(int i = 0; i < prof_service.get_Profesori().size(); ++i)
                        {
                            if(prof_service.get_Profesori().get(i).get_Id() == Integer.parseInt(tokens[j]))
                            {
                                check2=1;
                                pp.add(prof_service.get_Profesori().get(i));
                                break;
                            }
                        }
                        if(check2 == 0)
                        {
                            System.out.println(" prof check error");
                            return 0;
                        }
                    }
                    if(pp.size() < 1 || k1 == -1)
                    {
                        System.out.println(" hash set and k err");
                        return 0;
                    }

                    Catalog info = new Catalog(Integer.parseInt(tokens[0]), student_service.get_Studenti().get(k1), pp);
                    catalog_service.adauga_Fila(info);
                    check=1;

                }
            }
            return check;
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return 0;

    }


}
