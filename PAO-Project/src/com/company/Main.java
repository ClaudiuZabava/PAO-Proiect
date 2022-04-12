package com.company;

import com.company.services.AppService;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
            AppService service = AppService.get_Instance();
            service.meniu();
    }
}
