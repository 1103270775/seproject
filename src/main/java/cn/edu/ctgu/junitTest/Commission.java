package cn.edu.ctgu.junitTest;

public class Commission {
    public String classify(int lockNum,int stockNum,int barrelNum){
        //定义配件价格 枪机 枪托 枪管
        int lockPrice = 45,stockPrice = 30,barrelPrice = 25;
        //定义销售总额
        double totalSales = 0;
        //定义佣金
        double money = 0;
        //定义佣金等级
        int levelOne=1000,levelTwo=1800;
        double levelOnePrice = 0.1,levelTwoPrice = 0.15,levelThreePrice = 0.2;
        //数据合法
        boolean legal = (lockNum>=1&&stockNum>=0&&barrelNum>=1);
        if (legal){
            //总销售额
            totalSales = lockNum * lockPrice + stockNum * stockPrice + barrelNum * barrelPrice;
            if(totalSales<=levelOne){
                money = totalSales * levelOnePrice;
                return "佣金为："+money;
            }else if(totalSales>levelOne&&totalSales<levelTwo){
                money = levelOne * levelOnePrice + levelTwoPrice * (levelTwo - totalSales);
                return "佣金为："+money;
            }else{
                money = levelOne * levelOnePrice + (levelTwo - levelOne) * levelTwoPrice + (totalSales - levelTwo) * levelThreePrice;
                return "佣金为："+money;
            }
        }else{
            return "数据无效";
        }


    }
}
