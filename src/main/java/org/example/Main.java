package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String pathToOpenFile = "D:\\New - MY Disc\\Job NPU\\NPU\\Cisco AMP\\Cisco-Report\\Secure_Endpoint_Computers_23-04-25-092522 – копія.csv";
    private static final String pathToSaveFile = "D:\\New - MY Disc\\Job NPU\\NPU\\Cisco AMP\\Cisco-Report\\Secure_Endpoint_Computers_Report.txt";
    public static void main(String[] args) {


        Report report = new Report();
        report.startFormToReport(pathToOpenFile,pathToSaveFile);


    }
}