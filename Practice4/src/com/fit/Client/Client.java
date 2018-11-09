package com.fit.Client;

import com.fit.tourAgency.CustomerConnection;

    public class Client {
        private static int currentId = 0;
        private int id;
        private int count;

        private Client(int id) {
            this.id = id;
            this.count = 9999;
        }

        public static Client registerClient() {
            return new Client(CustomerConnection.registerClient());
        }
        public String getToursInfo() {
            return CustomerConnection.getAllTours();
        }
        public void buyTour(int tourId) {
            count = CustomerConnection.buyTour(this.id, tourId - 1, this.count);
        }
    }


