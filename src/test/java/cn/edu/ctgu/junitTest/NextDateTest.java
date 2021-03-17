package cn.edu.ctgu.junitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDateTest {

    @Test
    @DisplayName(value="月份出现问题")
    void testMonth() throws ParseException {
        NextDate nextDate = new NextDate();

        String type = nextDate.classify(-8, 20, 1999);
        assertEquals("输入月份出现问题", type);
    }
    @Test
    @DisplayName(value="日期出现问题")
    void testDay() throws ParseException {
        NextDate nextDate = new NextDate();

        String type = nextDate.classify(8, 199, 1999);
        assertEquals("输入日期出现问题", type);
    }
    @Test
    @DisplayName(value="年份出现问题")
    void testYear() throws ParseException {
        NextDate nextDate = new NextDate();

        String type = nextDate.classify(8, 12, 500);
        assertEquals("所输入年份不合规", type);
    }

    @Test
    @DisplayName(value="合法日期测试")
    void equallaterialNextDate() throws ParseException {
        NextDate nextDate = new NextDate();

        String type = nextDate.classify(3, 2, 1999);
        assertEquals("1999年03月03日", type);
    }


    @DisplayName(value="日期批量测试")
    @ParameterizedTest
    @CsvSource({
            "3,2,2000,2000年03月03日"

    })
    void paramNextDate(int month, int day,int year,String expected) throws ParseException {

        NextDate nextDate = new NextDate();

        String type = nextDate.classify(month, day, year);


        assertEquals(expected, type);
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/.csv",numLinesToSkip = 1, encoding = "UTF-8")
//    void testWithCsvFileSource(int num, int a, int b, int c,String expected) {
//        System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
//        NextDate nextDate = new NextDate();
//        String type = nextDate.classify(a,b,c);
//
//        assertEquals(expected,type);
//
//    }
}