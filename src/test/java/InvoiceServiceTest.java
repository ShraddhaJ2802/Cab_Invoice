import org.example.InvoiceGenerator;
import org.example.InvoiceSummary;
import org.example.Ride;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class InvoiceServiceTest {

    InvoiceGenerator invoiceGenerator = null;
    @BeforeEach
    void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        double distance =2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);

    }

    //For Minimum Fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
       // double fare = invoiceGenerator.calculateFare(distance,time, Ride.RideType.NORMAL);
        Assert.assertEquals(5,fare,0.0); //delta is for remove extra point values

    }

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary(){

        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1) ,
                new Ride(3.0,3)};

        double fare = invoiceGenerator.multipleRides(rides);
        Assert.assertEquals(30,fare,0.0);

    }
    @Test
    public void givenMultipleRide_ShouldReturncalculateInvoiceSummary(){
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};

        InvoiceSummary summary  = invoiceGenerator.calculateInvoiceSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
        double fare  = invoiceGenerator.calculateFare(rides, Ride.RideType.PREMIUM,"Shraddha");
        double expected = 111.0;
        Assertions.assertEquals(expected,fare);

    }




}
