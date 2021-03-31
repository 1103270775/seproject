package cn.edu.ctgu.Test3;

public class TwoInteger_subtract {
    public int subtract(int n,int m){

        //其中 n为被减数,m为减数
        int sub;
        sub = n-m;
        assert n>=1&&n<=99;
        assert m>=1&&m<=99;
        assert sub>=0&&sub<=99;

        return sub;
    }
}
