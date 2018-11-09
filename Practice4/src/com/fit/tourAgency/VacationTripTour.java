package com.fit.tourAgency;

import java.util.Date;

final class VacationTripTour extends Tour {
    protected int costOfEntertainment;

    public int getCostOfEntertainment() {
        return costOfEntertainment;
    }
    public void setCostOfEntertainment(int costOfEntertainment) {
        this.costOfEntertainment = costOfEntertainment;
    }

    public VacationTripTour(String countryDeparture, String regionDeparture, String country, String region, int costFlight, int costOfLiving, Date startDate, Date endDate, int costOfEntertainment) {
        super(countryDeparture, regionDeparture, country, region, costFlight, costOfLiving, startDate, endDate);
        this.costOfEntertainment = costOfEntertainment;
    }

    @Override
    public int getFullPrice(){
       return super.getFullPrice() + costOfEntertainment;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(String.format("Стоимость развлечений: %d долларов%n", costOfEntertainment));
        return builder.toString();
    }
}
