package com.fit.tourAgency;

import java.text.SimpleDateFormat;

public final class TourAgent {
    public static void setDiscount(int clientId, int discount){
        if(discount >= 0 && discount <=100)
            TourAgency.clients[clientId].setDiscount(discount);
    }

    public static void setHotTour(int tourId){
        TourAgency.tours[tourId].setHot(true);
    }
}
