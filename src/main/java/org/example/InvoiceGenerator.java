package org.example;

public class InvoiceGenerator {

    private double MINIMUM_COST_PER_KM = 10.0;
    private int COST_PER_TIME = 1;
    private double MINIMUM_FARE = 5.0;


    public double calculateFare(double distance, int time) {

        //  return distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;

        if (totalFare < MINIMUM_FARE) {

            return MINIMUM_FARE;

        }

        return totalFare;

    }

    public double calculateFare(Ride[] rides, Ride.RideType rideType, String userName) {

        UserId user = new UserId("Shraddha");
        boolean update = userName.equals(user.getUser());
        double totalFare = 0.0;

        for (Ride ride : rides) {
            try {
                if (!update) {
                    throw new UserIdException("--Invalid User Id---");
                } else {
                    for (Ride ride1 : rides) {

                        totalFare += this.calculateFare(ride1.distance, ride1.time, rideType);

                    }

                    totalFare += this.calculateFare(ride.distance, ride.time);

                }

            } catch (UserIdException e) {
                System.out.println(e.getMessage());
            }


        }
        return totalFare;

    }


    public double multipleRides(Ride[] rides) {

        double totalFare = 0.0;

        for (Ride ride : rides){

            totalFare += this.calculateFare (ride.distance, ride.time);

        }
        return totalFare;
    }

    public double calculateFare(double distance,int time,Ride.RideType rideType) {
        if(rideType == Ride.RideType.NORMAL) {
            MINIMUM_COST_PER_KM = 10;
            COST_PER_TIME = 1;
            MINIMUM_FARE = 5;
            System.out.println("Ride type " + Ride.RideType.NORMAL);
        } else {
            MINIMUM_COST_PER_KM = 15;
            COST_PER_TIME = 2;
            MINIMUM_FARE = 20;
            System.out.println("Ride type " + Ride.RideType.PREMIUM);
        }
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if( totalFare < MINIMUM_FARE) {
            totalFare = MINIMUM_FARE;
        }
        System.out.println(totalFare);
        return totalFare;
    }
   public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {

       double totalFare = 0.0;

       for (Ride ride : rides){
           totalFare += this.calculateFare (ride.distance, ride.time);

       }

       return new InvoiceSummary(rides.length, totalFare);
   }
}
