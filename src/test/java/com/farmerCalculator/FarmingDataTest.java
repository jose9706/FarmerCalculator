package com.farmerCalculator;

import com.farmerCalculator.FarmingData.FarmingData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class FarmingDataTest {

    @Test
    public void testGetSeedPrices() {
        FarmingData instance = new FarmingData();
        Map<String, Integer> test = instance.getSeedToPrice();
        Assert.assertNotNull(test);
        Assert.assertEquals(14, test.size());
    }
}
