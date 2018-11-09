package com.fit.tourAgency;
/*интерфес переделать*/
public interface CustomerConnection {

     static int registerClient() {
        return TourAgency.addClient().getId();
    }
     static int buyTour(int clientId, int tourId, int cost) {
        return TourAgency.clients[clientId].addTour(TourAgency.tours[tourId], cost);
    }

     static String getAllTours() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Tour tour : TourAgency.tours) {
            sb.append(String.format("%d) %s%n", i++, tour.toString()));
        }
        return sb.toString();
    }
}
