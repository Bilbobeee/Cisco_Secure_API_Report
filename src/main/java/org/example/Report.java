package org.example;

import java.io.*;
import java.util.*;

public class Report {

    private static BufferedReader input;
    private static  BufferedWriter writeInFile;
    private static ArrayList<String> listOfName;

    public void startFormToReport(String pathToFile,String pathToSaveFile){
        System.out.println("Розпочалося виконнання Завдання...");

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
                line = input.readLine();
                stSplit = line.split(",");

                for (String cell : listOfName){

                    for (int i=0; i<stSplit.length; i++){
                        if (stSplit[i].contains(cell)){
                            listFromFile.add(stSplit[i]);
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

        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i=1; i<listFromFile.size(); i++){

            if (listFromFile.get(i-1).equals(listFromFile.get(i))){
                matches ++;
            } else {
                matches++;
                hashMap.put(listFromFile.get(i-1),matches);
                matches = 0;
            }
            if (i==listFromFile.size()-1){
                matches++;
                hashMap.put(listFromFile.get(i-1),matches);
                matches = 0;
            }

        }


        TreeMap<String,Integer> treeMap = new TreeMap<>(hashMap);

        for (Map.Entry<String, Integer> cell : treeMap.entrySet()){
            System.out.println(cell.getKey()+"+"+ cell.getValue());
        }


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

        System.out.println("Завдання виконано УСПІШНО.");

    }

}
