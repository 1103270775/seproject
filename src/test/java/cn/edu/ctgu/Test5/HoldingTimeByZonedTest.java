package cn.edu.ctgu.Test5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HoldingTimeByZonedTest {

    @Test
    @Order(1)
    @DisplayName("开始通话和结束通话时间均在标准时间内,且通话为整数分钟")
    void testBetweenStandardTime() {

        LocalDateTime startingTime =
                LocalDateTime.of(2021,2,3,12,30,0);
        ZonedDateTime zonedStartTime =
                startingTime.atZone(ZoneId.of("America/New_York"));

        LocalDateTime endingTime =
                LocalDateTime.of(2021, 2,3,12,50,0);
        ZonedDateTime zonedEndTime =
                endingTime.atZone(ZoneId.of("America/New_York"));

        HoldingTimeByZoned holdingTime = new HoldingTimeByZoned(zonedStartTime, zonedEndTime);

        assertEquals(20*0.05, PhoneBillCaculator.caculator((int)holdingTime.getHoldingTime()));
    }

    @Test
    @Order(2)
    @DisplayName("开始通话和结束通话时间均在标准时间内,且通话不为整数分钟")
    void testBetweenStandardTime_with_seconds() {

        LocalDateTime startingTime =
                LocalDateTime.of(2021,2,3,12,30,0);
        ZonedDateTime zonedStartTime =
                startingTime.atZone(ZoneId.of("America/New_York"));

        LocalDateTime endingTime =
                LocalDateTime.of(2021, 2,3,12,50,25);
        ZonedDateTime zonedEndTime =
                endingTime.atZone(ZoneId.of("America/New_York"));

        HoldingTimeByZoned holdingTime = new HoldingTimeByZoned(zonedStartTime, zonedEndTime);
        assertEquals(1+1*0.1, PhoneBillCaculator.caculator((int)holdingTime.getHoldingTime()));

    }

    @Test
    @Order(3)
    @DisplayName("开始通话和结束通话时间均在夏令时内,且通话为整数分钟")
    void testBetweenDaylightTime() {

        LocalDateTime startingTime =
                LocalDateTime.of(2021,11,30,12,30,0);
        ZonedDateTime zonedStartTime =
                startingTime.atZone(ZoneId.of("America/New_York"));

        LocalDateTime endingTime =
                LocalDateTime.of(2021, 11,30,12,50,0);
        ZonedDateTime zonedEndTime = endingTime.atZone(ZoneId.of("America/New_York"));

        HoldingTimeByZoned holdingTime = new HoldingTimeByZoned(zonedStartTime, zonedEndTime);
        assertEquals(20*0.05, PhoneBillCaculator.caculator((int)holdingTime.getHoldingTime()));
    }

    @Test
    @Order(10)
    @DisplayName("开始通话在标准时间，结束通话时间在夏令时内,且通话为整数分钟")
    void test_standard_to_DaylightTime() {

        LocalDateTime startingTime = LocalDateTime.of(2021,3,14,0,40,0);
        ZonedDateTime zonedStartTime = startingTime.atZone(ZoneId.of("America/New_York"));

        LocalDateTime endingTime = LocalDateTime.of(2021, 3,14,3,40,0);
        ZonedDateTime zonedEndTime = endingTime.atZone(ZoneId.of("America/New_York"));

        HoldingTimeByZoned holdingTime = new HoldingTimeByZoned(zonedStartTime, zonedEndTime);
        assertEquals(1+100*0.1, PhoneBillCaculator.caculator((int)holdingTime.getHoldingTime()));

    }

}