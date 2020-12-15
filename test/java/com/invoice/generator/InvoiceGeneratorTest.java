package com.invoice.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp(){
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double totalFare = invoiceGenerator.calculateTotalFare(10,20);
        Assert.assertEquals(120.0,totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double totalFare = invoiceGenerator.calculateTotalFare(0.1,1);
        Assert.assertEquals(5,totalFare, 0.0);

    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateTotalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);

    }
}
