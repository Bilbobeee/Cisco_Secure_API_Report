package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String pathToOpenFile = "D:\\Report From Cisco Sec PC\\Secure_Endpoint_Computers_23-03-25-124434.csv";
    private static final String pathToSaveFile = "D:\\Report From Cisco Sec PC\\Secure_Endpoint_Computers_Report.txt";
    public static void main(String[] args) {


        Report report = new Report();
        report.startFormToReport(pathToOpenFile,pathToSaveFile);


    }
}