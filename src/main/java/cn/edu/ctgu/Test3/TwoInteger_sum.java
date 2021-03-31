package cn.edu.ctgu.Test3;

public class TwoInteger_sum {
    public int sum(int n,int m){

        assert n>=1 && n<=98;
        assert m>=1 && m<=98;
        //新增约束
        assert m+n<100;

        return m+n;
    }
}
