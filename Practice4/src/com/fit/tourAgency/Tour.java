package com.fit.tourAgency;

import java.util.Date;
import java.text.SimpleDateFormat;

class Tour {
    private static int currentId = 0;

    protected int id;
    protected String countryDeparture;
    protected String regionDeparture;
    protected String country;
    protected String region;
    protected int costFlight;
    protected int costOfLiving;
    protected Date startDate;
    protected Date endDate;
    protected boolean isHot;

    public String getCountryDeparture(){
        return countryDeparture;
    }
    public String getRegionDeparture(){
        return regionDeparture;
    }
    public String getCountry() {
        return country;
    }
    public String getRegion(){
        return region;
    }
    public int getCostFlight() {
        return costFlight;
    }
    public int getCostOfLiving() {
        return costOfLiving;
    }
    public boolean isHot() {
        return isHot;
    }
    public int getId() {
        return id;
    }

    public void setCountryDeparture(String countryDeparture) {
        this.countryDeparture = countryDeparture;
    }
    public void setRegionDeparture(String regionDeparture) {
        this.regionDeparture = regionDeparture;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setCostFlight(int costFlight) {
        this.costFlight = costFlight;
    }
    public void setCostOfLiving(int costOfLiving) {
        this.costOfLiving = costOfLiving;
    }
    public void setHot(boolean hot) {
        isHot = hot;
    }

    public Tour(String countryDeparture, String regionDeparture, String country, String region,
                int costFlight, int costOfLiving, Date startDate, Date endDate){
        this.countryDeparture = countryDeparture;
        this.regionDeparture = regionDeparture;
        this.country = country;
        this.region = region;
        this.costFlight = costFlight;
        this.costOfLiving = costOfLiving;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = currentId++;
    }
    public int getFullPrice(){
        return (costOfLiving+costFlight);
    }
    public int getPrice(){
        if(isHot) return (int)(getFullPrice() * 0.5);
        else return getFullPrice();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        builder.append(String.format("Откуда: %s, %s%n", countryDeparture, regionDeparture));
        builder.append(String.format("Куда: %s, %s%n", country, region));
        builder.append(String.format("Гарячий тур: %s%n", isHot));
        builder.append(String.format("Дата заезда: %s; Дата выезда: %s%n", sdf.format(startDate), sdf.format(endDate)));
        builder.append(String.format("Стоимость перелёта: %d долларов%n", costFlight));
        builder.append(String.format("Стоимость проживания: %d долларов%n", costOfLiving));

        //builder.append(String.format("%20s, %-20s%20s, %-20s%-15.14s%-15.14s%-15d%-15d", countryDeparture, regionDeparture,
        //       country, region, sdf.format(startDate), sdf.format(endDate), costFlight, costOfLiving));
        return builder.toString();
    }
}
