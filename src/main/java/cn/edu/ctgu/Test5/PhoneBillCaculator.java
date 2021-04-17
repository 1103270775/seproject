package cn.edu.ctgu.Test5;

public class PhoneBillCaculator {
    public static double caculator(int minutes){
        if (minutes<=0){
            return 0.0;
        }
        if (minutes<=20){
            return minutes*0.05;
        }else{
            return 1.0+(minutes-20)*0.1;
        }
    }
}