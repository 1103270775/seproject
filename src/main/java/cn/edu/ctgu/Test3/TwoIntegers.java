package cn.edu.ctgu.Test3;

public class TwoIntegers {
    public int sum(int n,int m){
        //前置断言
        //必须满足前置断言的条件才能进行相应的处理
        assert n>=1 && n<=99;
        assert m>=1 && m<=99;

        return n+m;
    }
}
