package cn.edu.ctgu.junitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommissionTest {

    @Test
    @DisplayName(value = "测试数据合法性")
    void classify() {
        Commission commission = new Commission();
        String type = commission.classify(-1,0,0);
        assertEquals("数据无效",type);
    }

    @ParameterizedTest
    @DisplayName(value = "测试佣金计算")
    @CsvSource({
            "10,10,10,佣金为：100.0",
            "20,20,20,佣金为：260.0",
            "10,11,12,佣金为：208.0"
    })
    void paramCommission(int a, int b,int c,String expected) {
        Commission commission = new Commission();

        String type = commission.classify(a,b,c);

        assertEquals(expected,type);
    }

}