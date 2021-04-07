package cn.edu.ctgu.Test4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PremiumCalculatorTest {

    private final PremiumCalculator premium = new PremiumCalculator();

    // 无效输入测试用例
    @ParameterizedTest(name = "money={0}, age={1}, sex={2},status={3},number={4}")
    @CsvSource({
            "0,50,male,yes,2",
            "100,500,male,yes,2",
            "100,50,nan,yes,2",
            "100,50,male,dansheng,2",
            "100,50,male,yes,-2"

    })
    void calculateInvalidCases(double money,int age,String sex,String status,int number) {
        //Assertions 用来代替了Assert
        //Assertions.assertThrows 为异常断言 必然异常，否则就报错
        Assertions.assertThrows(
                AssertionError.class,
                () -> premium.calculate(money, age,sex,status,number));
    }

    //有效输入测试用例
    @ParameterizedTest(name = "money={0}, age={1}, sex={2},status={3},number={4},result={5}")
    @CsvSource({
            "1000000,39,male,yes,2,6000",
            "1000000,20,male,yes,2,6000",
            "1000000,40,male,yes,2,6000",
            "1000000,59,male,yes,2,6000",
            "1000000,100,male,yes,2,1000",
            "1000000,39,female,yes,2,6000",
            "1000000,20,female,yes,2,6000",
            "1000000,40,female,yes,2,1000",
            "1000000,59,female,yes,2,1000",
            "1000000,100,female,yes,2,1000",
            "1000000,39,male,no,2,6000",
            "1000000,20,male,no,2,6000",
            "1000000,40,male,no,2,6000",
            "1000000,59,male,no,2,6000",
            "1000000,100,male,no,2,6000",
            "1000000,39,female,no,2,6000",
            "1000000,20,female,no,2,6000",
            "1000000,40,female,no,2,6000",
            "1000000,59,female,no,2,6000",
            "1000000,100,female,no,2,1000",

            "1000000,39,male,yes,7,6000",
            "1000000,20,male,yes,7,6000",
            "1000000,40,male,yes,7,1000",
            "1000000,59,male,yes,7,1000",
            "1000000,100,male,yes,7,1000",
            "1000000,39,female,yes,7,1000",
            "1000000,20,female,yes,7,1000",
            "1000000,40,female,yes,7,1000",
            "1000000,59,female,yes,7,1000",
            "1000000,100,female,yes,7,1000",
            "1000000,39,male,no,7,6000",
            "1000000,20,male,no,7,6000",
            "1000000,40,male,no,7,6000",
            "1000000,59,male,no,7,6000",
            "1000000,100,male,no,7,1000",
            "1000000,39,female,no,7,6000",
            "1000000,20,female,no,7,6000",
            "1000000,40,female,no,7,1000",
            "1000000,59,female,no,7,1000",
            "1000000,100,female,no,7,1000"
    })
    void calculateValidCases(double money,int age,String sex,String status,int number,double result) {
        Assertions.assertEquals(result, premium.calculate(money, age,sex,status,number));
    }

//    //采用参数生成方法实现有效输入测试用例
//    @ParameterizedTest(name = "num1={0}, num2={1}, result={2}")
//    @MethodSource("generator") //参数1生成方法源
//    void sumValidCasesWithMethodParam(int num1, int num2, int result) {
//        Assertions.assertEquals(result, adder.sum(num1, num2));
//    }
//
//    // 参数生成方法必须为static
//    private static Stream<Arguments> generator(){
//        return Stream.of(
//                Arguments.of(50,50,100),
//                Arguments.of(1,50,51),
//                Arguments.of(2,50,52),
//                Arguments.of(99,50,149),
//                Arguments.of(98,50,148),
//                Arguments.of(50,50,100),
//                Arguments.of(50,1,51),
//                Arguments.of(50,2,52),
//                Arguments.of(50,99,149),
//                Arguments.of(50,98,148)
//        );
//    }
}