package com.fit.tourAgency;

import java.util.Arrays;
import java.text.SimpleDateFormat;
//singleton
class TourAgency {
    public static ClientInfo[] clients = new ClientInfo[0];
    public static Tour[] tours;
    static {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            tours = new Tour[4];
            tours[0] = new ExcursionTour("Ukraine", "Kiev", "France", "Paris",
                    120, 120, sdf.parse("26.11.2018"), sdf.parse("29.11.2018"),
                    new String[]{"Eiffel Tower", "The Louvre"});
            tours[1] = new ShoppingTour("Ukraine", "Kiev", "France", "Paris",
                    120, 140, sdf.parse("26.11.2018"), sdf.parse("29.11.2018"),
                    new String[]{"Shop1", "Shop2", "Shop3"});
            tours[2] = new VacationTripTour("Ukraine", "Kiev", "Turkey", "Pigal",
                    230, 120, sdf.parse("26.11.2018"), sdf.parse("29.11.2018"),
                    200);
            tours[3] = new ExcursionTour("Ukraine", "Lviv", "Germany", "Koln",
                    120, 120, sdf.parse("26.11.2018"), sdf.parse("29.11.2018"),
                    new String[]{"Ex1", "Ex2","Ex3"});
        }
        catch (Exception e){

        }
    }

    public static ClientInfo addClient(){
        clients = Arrays.copyOf(clients, clients.length+1);
        clients[clients.length-1] = new ClientInfo();
        return clients[clients.length-1];
    }
}
