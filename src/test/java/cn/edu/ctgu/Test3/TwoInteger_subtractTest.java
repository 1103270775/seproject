package cn.edu.ctgu.Test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoInteger_subtractTest {
    private final TwoInteger_subtract sub = new TwoInteger_subtract();
    // 无效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}")
    @CsvSource({
            "0, 0",
            "100, 50",
            "40, 50",
            "0, 0",
            "50, 100",
            "40, 50",
    })
    void sumInvalidCases(int num1, int num2) {
        //Assertions 用来代替了Assert
        //Assertions.assertThrows 为异常断言 必然异常，否则就报错
        Assertions.assertThrows(
                AssertionError.class,
                () -> sub.subtract(num1, num2));
    }

    //有效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
    @CsvSource({
            "50, 20, 30",
            "42, 2, 40",
            "19,9,10",
            "30, 20, 10",
            "50,2,48",
            "99, 1, 98",
            "50, 1, 49",
            "50, 2, 48"

    })
    void sumValidCases(int num1, int num2, int result) {
        Assertions.assertEquals(result, sub.subtract(num1, num2));
//        assertEquals(result, adder.sum(num1, num2));
    }

    //采用参数生成方法实现有效输入测试用例
    @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
    @MethodSource("generator") //参数1生成方法源
    void sumValidCasesWithMethodParam(int num1, int num2, int result) {
        Assertions.assertEquals(result, sub.subtract(num1, num2));
    }

    // 参数生成方法必须为static
    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(50,20,30),
                Arguments.of(42,2,40),
                Arguments.of(19,9,10),
                Arguments.of(30,20,10),
                Arguments.of(50,2,48),
                Arguments.of(99,1,98),
                Arguments.of(50,1,49),
                Arguments.of(50,2,48),
                Arguments.of(50,13,37),
                Arguments.of(98,98,0)
        );
    }
}