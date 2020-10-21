package com.dynamic;

//0-a 1-b 2-c 3-d 4-e.....
//任意给定一串字符串，问你最后有多少种拆法
//12258 bccfi bwfi bczi mcfi mzi
public class Offer_46 {

    public static int F(String s,int len){
        if(len == 1){
            return 1;
        }

        if(len ==2){
            if(Integer.parseInt(s)>25){
                return 1;
            }else if(s.charAt(0) == '0'){
                return 1;
            }else{
                return 2;
            }
        }

        String st = s.substring(0,2);//截取开头两个字符串，试试这个字符串能不能组成字母
        Integer xt = Integer.parseInt(st);
        int yt = s.charAt(0)-'0';

        if(xt > 25 || yt ==0 ){//开头两个字符不能组成字符串 或者 开头是0，必须只能拆一步
            return F(s.substring(1,len),len-1);
        }else{
            return F(s.substring(1, len), len - 1)+ F(s.substring(2, len), len - 2);
        }
    }

    public static int translateNum(int num) {
        String s ="";
        s += num;
        int len = s.length();


        return F(s,len);
    }



    public static void main(String[] args) {
        String s = "506";
        int len = s.length();
        System.out.println(F(s,len));
    }
}
