package com.company.services;

import com.company.catalog.Catalog;
import com.company.curs.Materie;
import com.company.curs.Sala;
import com.company.utilizator.Adresa;
import com.company.utilizator.Contact;
import com.company.utilizator.Profesor;
import com.company.utilizator.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class WriteService {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV files header
    private static final String FILE_HEADER1 = "id, tara, judet, oras, strada";
    private static final String FILE_HEADER2 = "id, emailPersonal, emailInstitutional, telefon";
    private static final String FILE_HEADER3 = "codSala, etaj";
    private static final String FILE_HEADER4 = "id, denumire, notaS, codSala";
    private static final String FILE_HEADER5 = "id, nume, idContact, idAdresa, rank, idMaterie";
    private static final String FILE_HEADER6 = "id, nume, idContact, idAdresa, anStudiu, specializare";
    private static final String FILE_HEADER7 = "id, idStudent, idsProfesori...";

    private static WriteService instance;

    private WriteService(){}

    public static WriteService get_Instance(){
        if(instance == null){
            instance = new WriteService();
        }
        return instance;
    }

    public static void writeCsvAdresa(String fileName, Adresa adresa) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER1.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER1.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(adresa.get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(adresa.get_tara());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(adresa.get_judet());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(adresa.get_oras());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(adresa.get_strada());
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Adresa salvata in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCsvContact(String fileName, Contact info) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName,true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER2.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER2.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(info.get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(info.get_email1());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(info.get_email2());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(info.get_tel()));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Contact salvat in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCsvSala(String fileName, Sala sala) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER3.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER3.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(sala.get_Cod()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(sala.get_Etaj()));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Sala salvat in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCsvMaterie(String fileName, Materie materie) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER4.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER4.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(materie.get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(materie.get_Denumire());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(materie.get_Nota_student()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(materie.get_Sala().get_Cod()));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Materie salvat in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCsvProfesor(String fileName, Profesor prof) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER5.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER5.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(prof.get_Id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(prof.get_Nume());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(prof.get_Contact().get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(prof.get_Adresa().get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(prof.get_Rank()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(prof.get_Materie().get_id()));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Profesor salvata in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeCsvStudent(String fileName, Student student) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER6.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER6.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(student.get_Id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.get_Nume());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(student.get_Contact().get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(student.get_Adresa().get_id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(student.get_An()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.get_Specializare());
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Student salvata in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }


    public static void writeCsvCatalog(String fileName, Catalog catalog) {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if(!Objects.equals(br.readLine(), FILE_HEADER7.toString()))
            {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER7.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(String.valueOf(catalog.get_Id()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(catalog.get_Studenti().get_Id()));

            Iterator<Profesor> it = catalog.get_Profesori().iterator();
            while (it.hasNext())
            {
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(it.next().get_Id()));

            }
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("Fila de catalog salvata in fisierul CSV!!!");
        }
        catch (Exception e)
        {
            System.out.println("Eroare la incarcarea datelor in CSV !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Eroare la stergerea datelor din CSV!!!");
                e.printStackTrace();
            }
        }
    }
}
