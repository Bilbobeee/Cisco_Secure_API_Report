package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Report {

    private static BufferedReader input;
    private static  BufferedWriter writeInFile;
    private static ArrayList<String> listOfName;

    public void startFormToReport(String pathToFile,String pathToSaveFile){

        try {
            input = new BufferedReader(new FileReader(pathToFile));

        } catch (FileNotFoundException e){
            System.err.println("Файл не знайдено");
        }

        String line = "";

        Library library = new Library();
        listOfName = library.list;
        String[] stSplit = {};
        ArrayList<String> listFromFile = new ArrayList<>();

        try {
            while (input.ready()){
//                System.out.println((count++) + " " + (line = input.readLine()));
                line = input.readLine();
                stSplit = line.split(",");

                for (String cell : listOfName){

                    for (int i=0; i<stSplit.length; i++){
                        if (stSplit[i].contains(cell)){
                            listFromFile.add(stSplit[i]);
//                            System.out.println((count++)+" "+stSplit[i]);
                        }
                    }
                }
            }

        } catch (IOException e){
            System.err.println("Помилка при зчитуванні/виводу файлу");
        }

        listFromFile.addAll(library.allNameOFGroupForViewAllPC);


        Collections.sort(listFromFile);
        int matches = 0;

        for (String cell : listFromFile){
//            System.out.println(cell);

        }
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i=1; i<listFromFile.size(); i++){
//            System.out.println(i+" "+listFromFile.get(i));
//
            if (listFromFile.get(i-1).equals(listFromFile.get(i))){
                matches ++;
            } else {
                matches++;
                hashMap.put(listFromFile.get(i-1),matches);
                matches = 0;
            }
        }

        TreeMap<String,Integer> treeMap = new TreeMap<>(hashMap);

        try{
            writeInFile = new BufferedWriter(new FileWriter(pathToSaveFile));

            for (Map.Entry<String,Integer> cell : treeMap.entrySet()){
                writeInFile.write(cell.getKey()+"\t"+(cell.getValue()-1)+"\n");

            }

            writeInFile.flush();

        } catch (IOException e){
            System.err.println("Проблема при збережені файлу");
        }

        try{

            input.close();
            writeInFile.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
