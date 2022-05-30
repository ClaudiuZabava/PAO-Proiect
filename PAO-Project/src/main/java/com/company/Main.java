package com.company;

import com.company.config.DatabaseConfiguration;
import com.company.config.DatabaseManager;
import com.company.services.AppService;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {

            DatabaseConfiguration.CreateMyDb();
            DatabaseManager.createTabelAdresa();
            DatabaseManager.createTabelContact();
            DatabaseManager.createTabelSala();
            DatabaseManager.createTabelMaterie();
            DatabaseManager.createTabelStudent();
            DatabaseManager.createTabelProfesor();
            DatabaseManager.createTabelFila();
            AppService service = AppService.get_Instance();
            service.meniu();
    }
}
