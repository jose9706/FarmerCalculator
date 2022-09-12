package com.farmerCalculator;

import org.junit.Assert;
import org.junit.Test;
import com.farmerCalculator.Exchange.Exchange;

public class Exchange_Test
{
    @Test
    public void GetRannarTest_Pass() {
        int price = Exchange.getPrice(257);
        Assert.assertNotNull(price);
    }
}
