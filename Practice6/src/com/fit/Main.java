package com.fit;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите адрес файла для считывания: ");
        String inputPath = in.nextLine(); //C:/Users/admin/Desktop/input.txt
        System.out.print("Введите адрес файла для записи: ");
        String outputPath = in.nextLine(); //C:/Users/admin/Desktop/output.txt
        display(inputPath);
        try(//FileReader reader = new FileReader(inputPath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputPath, false),"Cp1251"));
            //FileOutputStream writer =  new FileOutputStream(outputPath,false);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inputPath),"Cp1251"))
        ) {
            ReaderWithCondition readerWithCondition = new ReaderWithCondition(reader);
            char[] word;
            while((word = readerWithCondition.next()) != null){
                writer.write(word);
                writer.newLine();
                //writer.append('\r');
                //writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        display(outputPath);
    }
    static void display(String path){
        System.out.printf("Вывод файла < %s >:\n", path);
        try(
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path),"Cp1251"))
        ){
            String currentLine;
            while((currentLine = reader.readLine())!= null) {
                System.out.println(currentLine);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}