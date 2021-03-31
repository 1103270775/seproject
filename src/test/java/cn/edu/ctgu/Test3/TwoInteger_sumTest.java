package cn.edu.ctgu.Test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoInteger_sumTest {

    private final TwoInteger_sum adder = new TwoInteger_sum();

    // 无效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}")
    @CsvSource({
            "0, 50",
            "99, 50",
            "50, 50",
            "50, 0",
            "50, 99",
            "50, 50",
    })
    void sumInvalidCases(int num1, int num2) {
        //Assertions 用来代替了Assert
        //Assertions.assertThrows 为异常断言 必然异常，否则就报错
        Assertions.assertThrows(
                AssertionError.class,
                () -> adder.sum(num1, num2));
    }

    //有效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
    @CsvSource({
            "50, 40, 90",
            "1, 50, 51",
            "2,50,52",
            "97, 1, 98",
            "98,1,99",
            "50, 49, 99",
            "50, 1, 51",
            "50, 2, 52",
            "1,98,99",
            "50,22,72"
    })
    void sumValidCases(int num1, int num2, int result) {
        Assertions.assertEquals(result, adder.sum(num1, num2));
//        assertEquals(result, adder.sum(num1, num2));
    }

    //采用参数生成方法实现有效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
    @MethodSource("generator") //参数1生成方法源
    void sumValidCasesWithMethodParam(int num1, int num2, int result) {
        Assertions.assertEquals(result, adder.sum(num1, num2));
    }

    // 参数生成方法必须为static
    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(50,49,99),
                Arguments.of(1,50,51),
                Arguments.of(2,50,52),
                Arguments.of(98,1,99),
                Arguments.of(1,98,99),
                Arguments.of(50,43,93),
                Arguments.of(50,1,51),
                Arguments.of(50,2,52),
                Arguments.of(50,13,63),
                Arguments.of(1,98,99)
        );
    }

}