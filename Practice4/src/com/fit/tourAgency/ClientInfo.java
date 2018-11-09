package com.fit.tourAgency;

import java.util.Arrays;

class ClientInfo {
    private static int currentClientId = 0;

    private int id;
    private int discount;
    private Tour[] tours = new Tour[0];

    public int getId() {
        return id;
    }
    public int getDiscount() {
        return discount;
    }
    public Tour[] getTours() {
        return tours;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ClientInfo(){
        discount = 0;
        id = currentClientId++;
    }

    public int addTour(Tour tour, int money){
        /*Tour[] newTourss = new Tour[tours.length+1];
         *int i = 0;
         *for(Tour t : tours){
         *    newTourss[i++] = t;
         *}
         *newTourss[i] = tour;
         *tours = newTourss;*/
        int cost = tour.getPrice();
        if(money > cost){
            tours = Arrays.copyOf(tours, tours.length+1);
            tours[tours.length - 1] = tour;
            money = money - cost;
        }
        return money;
    }

}
