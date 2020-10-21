package com.Oct;

// alex aaleelx
// abcd aaabbbcccddd
public class D_925 {

    public static boolean isLongPressedName(String name, String typed) {
        int i= 0,j=0;
        if(name == null || typed == null)
            return false;

        if(name.charAt(0) != typed.charAt(0)){
            return false;
        }

        while(i<name.length() && j<typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if( i-1>=0 &&typed.charAt(j) == name.charAt(i-1)){
                j++;
            }else if( i-1>=0 &&typed.charAt(j) != name.charAt(i-1)){
                return false;
            }else{
                j++;
            }
        }
        if(i >= name.length()){
            if(j<typed.length()){
                while(j<typed.length()){
                    if(typed.charAt(j) != name.charAt(name.length()-1))
                        return false;
                    else
                        j++;
                }
                if(j>=typed.length())
                    return true;
            }

            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String name3 = "alex";
        String typed3 = "alexxr";
        System.out.println(isLongPressedName(name3,typed3));


//        String name2 = "alex";
//        String typed2 = "aaleelx";
//        System.out.println(isLongPressedName(name2,typed2));


//        String name1 = "alex";
//        String typed1 = "aaleelx";
//        System.out.println(isLongPressedName(name1,typed1));
//
//        String name = "abcd";
//        String typed = "aaabbbcccddd";
//        System.out.println(isLongPressedName(name,typed));
    }
}
