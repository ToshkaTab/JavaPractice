package com.fit.tourAgency;

import java.util.Date;

final class ExcursionTour extends Tour {
    private String[] culturalPoints;

    public String[] getCulturalPoints() {
        return culturalPoints;
    }

    public ExcursionTour(String countryDeparture, String regionDeparture, String country, String region, int costFlight, int costOfLiving, Date startDate, Date endDate, String[] culturalPoints) {
        super(countryDeparture, regionDeparture, country, region, costFlight, costOfLiving, startDate, endDate);
        this.culturalPoints = new String[culturalPoints.length];
        int i = 0;
        for(String shopPoint : culturalPoints){
            this.culturalPoints[i++] = shopPoint;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Достопримечательности: \n");
        int i = 1;
        for(String culturalPoint : culturalPoints){
            builder.append(String.format("%d. %s%n", i++, culturalPoint));
        }
        return builder.toString();
    }
}
