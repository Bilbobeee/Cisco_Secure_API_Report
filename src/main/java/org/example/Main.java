package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String pathToOpenFile = "D:\\Report From Cisco Sec PC\\Secure_Endpoint_Computers_23-04-10-164301.csv";
    private static final String pathToSaveFile = "D:\\Report From Cisco Sec PC\\Secure_Endpoint_Computers_Report.txt";
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("cmd");

        try
        {
            pb.start();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        Report report = new Report();
        report.startFormToReport(pathToOpenFile,pathToSaveFile);


    }
}