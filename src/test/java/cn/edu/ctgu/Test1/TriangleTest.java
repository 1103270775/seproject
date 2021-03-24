package cn.edu.ctgu.Test1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 * 
 * @author tiger
 * @date 2021年3月4日-下午8:43:13
 * @description 三角形测试用例
 */
class TriangleTest {


//    @Test
//    @DisplayName("输入错误")
//    void parameters_error_test(){
//        Triangle triangle = new Triangle();
//        String type = triangle.classify(0, 4, 5);
//
//        assertEquals("输入错误", type);
//    }

	@Test
	@DisplayName(value="不等边三角形测试")
	void testTriangle() {
		Triangle triangle = new Triangle();
		
		String type = triangle.classify(3, 4, 6);
		assertEquals("不等边三角形", type);
	}

	@Test
	@DisplayName("等腰三角形测试")
	void isosceles_test() {
		Triangle triangle = new Triangle();

		String type = triangle.classify(3, 3, 5);
		assertEquals("等腰三角形", type);
	}

	@Test
	@DisplayName("等边三角形测试")
	void equallaterialTriangle() {
		Triangle triangle = new Triangle();
		
		String type = triangle.classify(3, 3, 3);
		assertEquals("等边三角形", type);
	}
	
	@Test
	@DisplayName("非三角形测试")
	void notTriangle() {
		Triangle triangle = new Triangle();
		
		String type = triangle.classify(3, 3, 6);
		assertEquals("非三角形", type);
	}

	@DisplayName("批量数据测试")
	@ParameterizedTest
	@CsvSource({
		"3,4,6,不等边三角形",
		"3,3,3,等边三角形",
		"3,3,6,非三角形"
	})
	void paramTriangle(int a, int b,int c,String expected) {
		Triangle triangle = new Triangle();
		
		String type = triangle.classify(a, b, c);
		
		assertEquals(expected, type);
	}

//	@ParameterizedTest
//	@CsvFileSource(resources = "/naiveTestTriangle.csv",numLinesToSkip = 5, encoding = "UTF-8")
//	void testWithCsvFileSource(int num, int a, int b, int c,String expected) {
//		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
//		Triangle triangle = new Triangle();
//		String type = triangle.classify(a,b,c);
//
//		assertEquals(expected,type);
//
//	}

	@ParameterizedTest
	@DisplayName("三角形一般边界测试")
	@CsvFileSource(resources = "/三角形一般边界测试用例.csv",numLinesToSkip = 1, encoding = "UTF-8")
	void testWithCsvFileSource_GeneralBoundary(int num, int a, int b, int c,String expected) {
		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
		Triangle triangle = new Triangle();
		String type = triangle.classify(a,b,c);

		assertEquals(expected,type);

	}

	@ParameterizedTest
	@DisplayName("三角形健壮性最坏情况测试")
	@CsvFileSource(resources = "/三角形健壮性最坏情况测试用例.csv",numLinesToSkip = 1, encoding = "UTF-8")
	void testWithCsvFileSource_RobustnessBad(int num, int a, int b, int c,String expected) {
		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
		Triangle triangle = new Triangle();
		String type = triangle.classify(a,b,c);

		assertEquals(expected,type);

	}

	@ParameterizedTest
	@DisplayName("三角形健壮测试")
	@CsvFileSource(resources = "/三角形健壮测试用例.csv",numLinesToSkip = 1, encoding = "UTF-8")
	void testWithCsvFileSource_Robustness(int num, int a, int b, int c,String expected) {
		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
		Triangle triangle = new Triangle();
		String type = triangle.classify(a,b,c);

		assertEquals(expected,type);

	}

	@ParameterizedTest
	@DisplayName("三角形弱一般等价类测试")
	@CsvFileSource(resources = "/三角形弱一般等价类测试用例.csv",numLinesToSkip = 1, encoding = "UTF-8")
	void testWithCsvFileSource_GeneralEquivalenceClass(int num, int a, int b, int c,String expected) {
		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
		Triangle triangle = new Triangle();
		String type = triangle.classify(a,b,c);

		assertEquals(expected,type);

	}
	@ParameterizedTest
	@DisplayName("三角形最坏情况测试")
	@CsvFileSource(resources = "/三角形最坏情况测试用例.csv",numLinesToSkip = 1, encoding = "UTF-8")
	void testWithCsvFileSource_Bad(int num, int a, int b, int c,String expected) {
		System.out.println("测试用例"+num+":"+a+","+b+","+c+":"+expected);
		Triangle triangle = new Triangle();
		String type = triangle.classify(a,b,c);

		assertEquals(expected,type);

	}
}
