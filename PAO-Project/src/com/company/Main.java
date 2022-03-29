package com.company;

import Services.App_Service;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
            App_Service service = App_Service.get_Instance();
            service.meniu();
    }
}
