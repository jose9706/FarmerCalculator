package com.farmerCalculator;

import com.farmerCalculator.Exchange.Exchange;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exchange_Test
{
    @Test
    public void GetRannarTest_Pass() {
        // Rannar weed item id.
        int itemValue = Exchange.getValueForItem(257);
        Assert.assertTrue(itemValue > 0);
    }

    // Supposed to make sure when an invalid id is used an except is thrown.
    @Test(expected = RuntimeException.class)
    public void GetInvalidId_Throws() {
        Exchange.getValueForItem(258);
    }

    @Test
    public void GetSeveralItemPrices_Pass() {
        List<String> items = new ArrayList<String>();
        items.add("257");
        items.add("259");
        items.add("261");
        Map<String, Integer> prices = Exchange.getValueForItems(items);
        Assert.assertNotNull(prices);
        Assert.assertEquals(3, items.size());
    }

}
