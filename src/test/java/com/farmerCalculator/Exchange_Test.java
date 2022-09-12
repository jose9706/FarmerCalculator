package com.farmerCalculator;

import org.junit.Test;

import static com.farmerCalculator.Exchange.ExchangeJsonDataHandler.ExtractCurrentPrice;
import static com.farmerCalculator.Exchange.ExchangeJsonDataHandler.ExtractTokenDataFromJsonData;

public class Exchange_Test
{
    @Test
    public void GetRannarTest_Pass() {
        String value = ExtractCurrentPrice("{\"item\":{\"icon\":\"https://secure.runescape.com/m=itemdb_oldschool/1662647178079_obj_sprite.gif?id=257\",\"icon_large\":\"https://secure.runescape.com/m=itemdb_oldschool/1662647178079_obj_big.gif?id=257\",\"id\":257,\"type\":\"Default\",\"typeIcon\":\"https://www.runescape.com/img/categories/Default\",\"name\":\"Ranarr weed\",\"description\":\"A useful herb.\",\"current\":{\"trend\":\"neutral\",\"price\":\"7,306\"},\"today\":{\"trend\":\"negative\",\"price\":\"- 5\"},\"members\":\"true\",\"day30\":{\"trend\":\"negative\",\"change\":\"-19.0%\"},\"day90\":{\"trend\":\"negative\",\"change\":\"-21.0%\"},\"day180\":{\"trend\":\"negative\",\"change\":\"-21.0%\"}}}");
        System.out.println(value);
    }

}
