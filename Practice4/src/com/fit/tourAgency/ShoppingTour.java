package com.fit.tourAgency;

import java.util.Date;

final class ShoppingTour extends Tour {
    private String[] shopPoints;

    public String[] getShopPoints() {
        return shopPoints;
    }

    public ShoppingTour(String countryDeparture, String regionDeparture, String country, String region, int costFlight, int costOfLiving, Date startDate, Date endDate, String[] shopPoints) {
        super(countryDeparture, regionDeparture, country, region, costFlight, costOfLiving, startDate, endDate);
        this.shopPoints = new String[shopPoints.length];
        int i = 0;
        for(String shopPoint : shopPoints){
            this.shopPoints[i++] = shopPoint;
        }
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Торговые точки: \n");
        int i = 1;
        for(String shopPoint : shopPoints){
            builder.append(String.format("%d. %s%n",  i++, shopPoint));
        }
        return builder.toString();
    }
}
