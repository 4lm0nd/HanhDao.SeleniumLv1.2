package org.example;

import common.utils.PropertyReader;
import common.utils.JsonReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Read Properties
        PropertyReader reader = new PropertyReader("config.properties");

        String name = reader.getProperty("project.name");
        String owner = reader.getProperty("project.owner");
        String browser = reader.getProperty("project.browser");

        System.out.println("Project: " + name);
        System.out.println("Owner: " + owner);
        System.out.println("Browser: " + browser);

        //Read Json

        String mgs = JsonReader.getJsonValue("message.json", "msg login error");
        System.out.println("Message:" + mgs);

    }


    }

