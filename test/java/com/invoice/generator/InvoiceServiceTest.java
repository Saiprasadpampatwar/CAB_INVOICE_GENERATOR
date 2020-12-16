package com.invoice.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceService = null;

    @Before
    public void setUp(){
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double totalFare = invoiceService.calculateTotalFare(10,20);
        Assert.assertEquals(120.0,totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double totalFare = invoiceService.calculateTotalFare(0.1,1);
        Assert.assertEquals(5,totalFare, 0.0);

    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);

    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "abc@123";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(userId,rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSumary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }


}
