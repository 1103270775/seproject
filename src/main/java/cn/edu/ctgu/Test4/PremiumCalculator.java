package cn.edu.ctgu.Test4;

/**
 * @author 11032
 */
public class PremiumCalculator {
    public double calculate(double money,int age,String sex,String status,int number){

        //前置断言
        assert money > 0;
        assert age>0 && age<=110;
        assert "male".equals(sex)|| "female".equals(sex);
        assert "yes".equals(status)|| "no".equals(status);
        assert number>=0;

        // 保费 点数 保险费率
        double  premium=0,count=0,ratio=0;
        //年龄判定
        if(age>=20&&age<=39){
            count+=6;
        }else if(age>=40&&age<=59){
            count+=4;
        }else {
            count+=2;
        }
        //性别判定 male为男性 female为女性
        if("male".equals(sex)){
            count+=4;
        }
        if("female".equals(sex)){
            count+=3;
        }
        //婚姻情况判定
        if("yes".equals(status)){
            count+=3;
        }
        if("no".equals(status)){
            count+=5;
        }
        //抚养人数
        if(number*0.5<3){
            count = count - number*0.5;
        }else{
            count = count - 3;
        }

        //费率计算
        if(count>=10){
            ratio = 0.006;
        }else{
            ratio = 0.001;
        }
        //保费计算
        premium = money*ratio;


        return premium;
    }
}
