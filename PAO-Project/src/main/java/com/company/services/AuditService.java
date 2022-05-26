package com.company.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AuditService
{

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV files header
    private static final String FILE_HEADER1 = "actiune, data_executie";

    private static com.company.services.AuditService instance;

    private AuditService(){}

    public static com.company.services.AuditService get_Instance(){
        if(instance == null){
            instance = new com.company.services.AuditService();
        }
        return instance;
    }

    public static void writeCsvAudit(String fileName, String act)
    {
        FileWriter fileWriter = null;
        BufferedReader br = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            br = new BufferedReader(new FileReader(fileName));

            if (!Objects.equals(br.readLine(), FILE_HEADER1.toString())) {
                //Write the CSV file header
                fileWriter.append(FILE_HEADER1.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            //Write a new student object list to the CSV file
            fileWriter.append(act);
            fileWriter.append(COMMA_DELIMITER);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            fileWriter.append(dtf.format(now));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("--- status audti reactualizat ---");
        } catch (Exception e) {
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
