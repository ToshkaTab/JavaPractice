package com.fit;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите адрес файла для считывания: ");
        String inputPath = in.nextLine(); //C:/Users/admin/Desktop/input.txt
        System.out.print("Введите адрес файла для записи: ");
        String outputPath = in.nextLine(); //C:/Users/admin/Desktop/output.txt

        try(//FileReader reader = new FileReader(inputPath);
            FileWriter writer = new FileWriter(outputPath, false);
            //FileOutputStream writer =  new FileOutputStream(outputPath,false);
            FileInputStream fis =  new FileInputStream(inputPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "Cp1251")))
        {
            ReaderWithCondition readerWithCondition = new ReaderWithCondition(reader);
            char[] word;
            while((word = readerWithCondition.next()) != null){
                writer.write(word);
                writer.append('\r');
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}