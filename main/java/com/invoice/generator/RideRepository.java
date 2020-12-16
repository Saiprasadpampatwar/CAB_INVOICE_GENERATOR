package com.invoice.generator;

import java.util.*;

public class RideRepository {
    private HashMap<String, List<Ride>> ridesData;

    public RideRepository() {
        this.ridesData = new HashMap<String, List<Ride>>();
    }

    public void addRides(String userId, Ride[] rides) {
        List<Ride> userRides = ridesData.get(userId);
        if(userRides == null){
            ridesData.put(userId, Arrays.asList(rides));
        }
    }

    public List<Ride> getRidesData(String userId) {
        return ridesData.get(userId);
    }
}
