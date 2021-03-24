package cn.edu.ctgu.Test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NextDate {
        public String classify(int month,int day,int year) throws ParseException {
            int max = 2050;
            int min = 1900;
            String time;
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");


            if(month<0||month>12){
                return"输入月份出现问题";
            }
            else if(day<1||day>31){
                return "输入日期出现问题";
            }
            else if(year<min||year>max){
                return "所输入年份不合规";
            }
            else{
                time = (year+"年"+month+"月"+day+"日");
                Date date = sdFormat.parse(time);
                Calendar nextdate = Calendar.getInstance();
                nextdate.setTime(date);
                nextdate.add(Calendar.DAY_OF_MONTH,1);
                return sdFormat.format(nextdate.getTime());
                        
            }


//            return "";
        }
}
