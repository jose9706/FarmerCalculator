package com.farmerCalculator.ExchangeTests;

import com.farmerCalculator.Exchange.PriceParser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTests {

    @Test
    public void TestPriceWithK() {
        int result = PriceParser.GetPrice("10.2k");
        Assert.assertEquals(10200, result);
    }

    @Test
    public void TestPriceWithM() {
        int result = PriceParser.GetPrice("1.8m");
        Assert.assertEquals(result, 1800000);
    }
}
