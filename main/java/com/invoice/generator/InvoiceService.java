package com.invoice.generator;

import java.util.List;

public class InvoiceService {

    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MINIMUMFARE = 5;
    private  RideRepository rideRepository;



    public enum RideType{
        NORMAL(10,1,5),
        PREMIUM(15,2,20);
        public final double costPerKm;
        public final double costPeeMin;
        public final double minimumFare;

        RideType(double costPerKm, double costPeeMin, double minimumFare) {
            this.costPerKm = costPerKm;
            this.costPeeMin = costPeeMin;
            this.minimumFare = minimumFare;
        }
    }

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateTotalFare(double distance, double time) {
        double fare = (distance*COST_PER_KM+time*COST_PER_MIN);
        return Math.max(MINIMUMFARE,fare);
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides) {
        double fare=0.0;
        for(Ride ride: rides){
            fare += this.calculateTotalFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,fare);
    }


    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }


    public InvoiceSummary getInvoiceSumary(String userId) {
        List<Ride> ridesList = rideRepository.getRidesData(userId);
        return calculateTotalFare(ridesList.toArray(new Ride[ridesList.size()]));
    }

    public double calculateTotalFare(double distance, double time, RideType rideType) {
        double fare=0;
        fare = distance*rideType.costPerKm+time*rideType.costPeeMin;
        return Math.max(rideType.minimumFare,fare);
    }
}
