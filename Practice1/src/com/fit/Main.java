package com.fit;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("console.encoding","Cp866");
        System.out.println("Tабунов A.A.");
        Scanner in = new Scanner(System.in);

        while(true) {
                System.out.print("Enter matrix lenght: ");

                int size = in.nextInt();
                SquareMatrix matrix = new SquareMatrix(size);
                matrix.print();
                matrix.reverse();
                matrix.print();
        }

    }
}

