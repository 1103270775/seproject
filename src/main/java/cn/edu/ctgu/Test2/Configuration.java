package cn.edu.ctgu.Test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 
 * @author xzh
 * @date 2021.3.24
 */

public class Configuration {

    /**
     * Properties为java的配置文件
     */
    private Properties props = new Properties();

    /**
    * 读取属性配置文件
    * 
    * @param confFile
    */
    public void fromFile(File confFile) {
        try(FileInputStream in = new FileInputStream(confFile);){
            props.load(new InputStreamReader(in,StandardCharsets.UTF_8));
        } catch (IOException e) {
        throw new ValueParseException("配置文件解析错误");
        } 
    }

    /**
    * 获取键值
    * 
    * @param key
    * @return value
    */
    public String getProp(String key) {
        return props.getProperty(key);
    }

    /**
    * 获取布尔类型键值
    * 
    * @param key
    * @return value
    */
    public boolean getBoolean(String key) {
        String value = props.getProperty(key);
        //忽略大小写
        // 将两个字符串进行比较是否相等
        if ("true".equalsIgnoreCase(value)) {
            return true;
        }
        if ("false".equalsIgnoreCase(value)) {
            return false;
        }
        throw new ValueParseException("键值不存在");
    }

    /**
     * 返回指定键的布尔值；
     * 若值不存在返回传入的缺省值
     *
     * @param key，defaultValue
     * @return value
     */
    public Boolean getBooleanWithDefault(String key,Boolean defaultValue){
        String value = props.getProperty(key);
        if ("true".equalsIgnoreCase(value)) {
            return true;
        }
        if ("false".equalsIgnoreCase(value)) {
            return false;
        }
        throw new ValueParseException(defaultValue);

    }

    /**
     * 返回指定键的整数值；
     * 若值不存在返回传入的缺省值
     *
     * @param key，defaultValue
     * @return value
     */
    public Integer getInt(String key, int defaultValue){
        //props.getProperty(key)返回的null为String的null

        if(!"null".equals(props.getProperty(key)) && props.getProperty(key)!=null){
            return Integer.parseInt(props.getProperty(key));
        }
        throw new ValueParseException(defaultValue);


    }

    /**
     * 返回指定键的日期值；
     * 若值不存在返回传入的缺省值
     *
     * @param key，defaultValue
     * @return value
     */
    public Date getDate(String key, Date defaultValue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(!"null".equals(props.getProperty(key))&& props.getProperty(key)!=null){
            return sdf.parse(props.getProperty(key));
        }
        throw new ValueParseException(defaultValue);

    }
}