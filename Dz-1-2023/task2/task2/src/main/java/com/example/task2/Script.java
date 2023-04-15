package com.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;

import org.apache.groovy.util.ScriptRunner;

public class Script {
    public static void main(String[] args) {

        String script = "tests.sql";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ScriptRunner
                    .runScript(String.valueOf(new BufferedReader(new FileReader(script))));

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
