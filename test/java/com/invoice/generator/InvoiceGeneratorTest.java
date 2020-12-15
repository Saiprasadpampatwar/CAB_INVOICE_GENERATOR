package com.invoice.generator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateTotalFare(10,20);
        Assert.assertEquals(120.0,totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateTotalFare(0.1,1);
        Assert.assertEquals(5,totalFare, 0.0);

    }
}
