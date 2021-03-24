package cn.edu.ctgu.Test2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    /**
     * TempDir
     * 创建临时目录。
     * 一旦测试方法或类执行完毕，
     * 将删除在测试执行过程中创建的目录及其内容
     * 参考资料：
     * https://blog.csdn.net/dnc8371/article/details/106701248
     */
    @TempDir
    static Path tempDir;

    @DisplayName("当键存在时应该返回键值")
    //参数解析器 批量处理的时候需要
    @ParameterizedTest
    @CsvSource({
            "ea,false",
            "closeable,true"
    })
    void value_should_exist_when_key_exist(String Key,String Value) throws IOException{
        // arrange 创建临时文件 app.conf
        Path path = tempDir.resolve("app.conf");
        //文件写入数据
        // Arrays.asList()数组转换为List
        String s = Key+"="+Value;
        System.out.println("组合完毕:"+s);
//        Files.write(path, Arrays.asList(
//                "ea=false",
//                "closeable=true",
//                " = "
//        ));
//        Files.write(path, s);
        Files.write(path,s.getBytes());
        //创建文件解析类
        Configuration configuration = new Configuration();
        //调用文件解析方法
        configuration.fromFile(path.toFile());

        // act
        String value = configuration.getProp(Key);
        System.out.println("获取完毕:"+value);
        // assert
        assertEquals(Value, value);
    }

    @Test
    @DisplayName("当key不存在的时候报错/返回默认值---错误测试类")
    void throw_ValueParseException_when_key_not_exist() throws IOException, ParseException {
        // arrange
        Path path = tempDir.resolve("app.conf");
        Files.write(path, Arrays.asList("ea=false"));

        Configuration conf = new Configuration();
        //解析配置文件
        conf.fromFile(path.toFile());

        // act
        // assertThrows()主要对被测试方法的抛出异常进行测试，
        // 测试所抛出的异常是否满足预期
        // 2.如果抛出的异常与设定异常相同，则这一步断言成功并返回一个异常的顶级父级
        Throwable throwable_getProp = assertThrows(ValueParseException.class, () ->{
            //1.执行该语句会抛出一个异常，ValueParseException("键值不存在")
            // 随后被assertThrows方法捕获
            conf.getProp("notexist");

        });

        Throwable throwable_getBoolean = assertThrows(ValueParseException.class, () ->{
            conf.getBoolean("notexist");
        });

        Throwable throwable_Boolean_Default = assertThrows(ValueParseException.class, () ->{
            conf.getBooleanWithDefault("notexist",true);
        });

        Throwable throwable_Integer_Default = assertThrows(ValueParseException.class, () ->{
            conf.getInt("note",123);
        });


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date DefaultDate = sdf.parse("2000-01-01");
        Throwable throwable_Date_Default = assertThrows(ValueParseException.class, () ->{
            conf.getDate("notexist",DefaultDate);
        });

        // assert
        //assertAll执行所有断言，并且所有失败都将一起报告
        assertAll(
                //验证是否能正确捕获异常
                () -> assertEquals("键值不存在",throwable_getProp.getMessage()),
                () -> assertEquals("键值不存在",throwable_getBoolean.getMessage()),
                () -> assertEquals("true",throwable_Boolean_Default.getMessage()),
                () -> assertEquals("123",throwable_Integer_Default.getMessage()),
                () -> assertEquals("Sat Jan 01 00:00:00 CST 2000",throwable_Date_Default.getMessage())


        );
    }

    @ParameterizedTest
    @DisplayName("返回指定键的布尔值")
    @CsvSource({
            "ea,false,false",
            "closeable,true,false",
            "hello,true,true"
    })
    void throw_DefaultValue_when_key_not_exist(String Key,Boolean Value,Boolean Default)throws IOException{

        Path path = tempDir.resolve("app.conf");
        String s = Key+"="+Value;
        System.out.println("组合完毕:"+s);
        Files.write(path, Collections.singletonList(s));

        Configuration conf = new Configuration();
        //解析配置文件
        conf.fromFile(path.toFile());
//        assertEquals(conf.getBooleanWithDefault("notexist",Default),Default);
//        if(!Key.equals("notexist")) {
            assertEquals(conf.getBooleanWithDefault(Key,Default),Value);
//        }
//        else{
//            assertEquals(conf.getBooleanWithDefault(Key,Default),Default);
//        }


    }

    @ParameterizedTest
    @DisplayName("返回指定键的整数值")
    @CsvSource({
            "ea,9,10",
            "closeable,10,100",
            "hello,314,314"
    })
    void throw_DefaultValue_Integer_when_key_not_exist(String Key,Integer Value,Integer Default)throws IOException{

        Path path = tempDir.resolve("app.conf");
        String s = Key+"="+Value;
        System.out.println("组合完毕:"+s);
        Files.write(path, Collections.singletonList(s));

        Configuration conf = new Configuration();
        //解析配置文件
        conf.fromFile(path.toFile());
//        assertEquals(conf.getBooleanWithDefault("notexist",Default),Default);
//        if(!Key.equals("notexist")) {
            assertEquals(conf.getInt(Key,Default),Value);
//            System.out.println(Value);
//        }
//        else{
//            assertEquals(conf.getInt(Key,Default),Default);
//        }
    }

    @ParameterizedTest
    @DisplayName("返回指定键的日期值")
    @CsvSource({
            "ea,2018-11-11,2000-01-01",
            "closeable,2019-11-11,2000-01-01"

    })
    void throw_DefaultValue_Date_when_key_not_exist(String Key,String Value, String Default) throws IOException, ParseException {

        Path path = tempDir.resolve("app.conf");
        String s = Key+"="+Value;
        System.out.println("组合完毕:"+s);
        Files.write(path, Collections.singletonList(s));

        Configuration conf = new Configuration();
        //解析配置文件
        conf.fromFile(path.toFile());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date DefaultDate = sdf.parse(Default);

//        if(!Key.equals("notexist")) {
            Date ValueDate = sdf.parse(Value);
            assertEquals(conf.getDate(Key,DefaultDate),ValueDate);
//        }
//        else{
//            assertEquals(conf.getDate(Key,DefaultDate),DefaultDate);
//        }
    }
}