package com.homework;

/**
 * @author ZDH
 * @version 1.0
 * @date 2020/10/31 20:35
 */
public class Demo02 {

    public static void main(String[] args) {

        //初始尝试
//          String dragon = "F-H";
//        String dargon1  = "";
//        for(int j=0;j<dragon.length();j++){
//            char c = dragon.charAt(j);
//            if(c == 'F'){
//                dargon1  = dargon1  + s1;
//            } else if (c == 'H') {
//                dargon1  = dargon1  + s2;
//            }else{
//                dargon1 = dargon1  +c;
//            }
//        }
//        System.out.println("dragon1:"+dargon1);
//
//        String dargon2 = "";
//        for(int j=0;j<dargon1.length();j++){
//            char c = dargon1.charAt(j);
//            if(c == 'F'){
//                dargon2 = dargon2 + s1;
//            } else if (c == 'H') {
//                dargon2 = dargon2 + s2;
//            }else{
//                dargon2 = dargon2 +c;
//            }
//        }
//        System.out.println("dargon2:"+dargon2);

        String dragon = "F-H";

        String s1 = "F-H";
        String s2 = "F+H";

        //1.第一层for循环用来控制我要得到获得dragon[?]
        for (int i = 1; i <= 10; i++) {//从dragon0->dragon1->dragon2->···->dragon10

            String tdargon = "";//在上面一个dragon的基础上去拿到下面一个的dragon

            //2.第二层for循环用来遍历当前dragon,由当前dragon就可以获得我的下一个新的dragon了
            for (int j = 0; j < dragon.length(); j++) {
                char c = dragon.charAt(j);
                if (c == 'F') {
                    tdargon = tdargon + s1;
                } else if (c == 'H') {
                    tdargon = tdargon + s2;
                } else {
                    tdargon = tdargon + c;
                }
            }

            //dragon --> tdragon(dragon1)
            //tdrgon -->? dragon2

            //3.第二层for循环结束的时候就得到了我要的新的dragon,就是tdragon
            dragon = tdargon;//4.我要继续出发去接收找新的dragon,出发起点就是dragon,tragon就给tdragon就好

            System.out.println("i=" + i + " " + dragon);
        }

    }
}

