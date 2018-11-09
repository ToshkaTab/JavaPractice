package com.fit;

import com.fit.Client.Client;
import com.fit.tourAgency.TourAgent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            Client client = Client.registerClient();

            System.out.println(client.getToursInfo());

            System.out.print("Выберите тур для покупки: ");
            client.buyTour(in.nextInt());

            System.out.println("Вы тур агент.");
            System.out.print("Выберите тур для установки гарячего тура: ");
            TourAgent.setHotTour(in.nextInt());
            System.out.println(client.getToursInfo());
        }
        catch (Exception e){

        }

    }
}
