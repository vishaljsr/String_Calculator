package com.company;

import org.junit.Test;

public class Main {

    public static void main(String[] args) {

        testAdd();
    }

    @Test
    private static void testAdd() {
        System.out.println(Add(""));
        System.out.println(Add("1"));
        System.out.println(Add("1","2"));
        System.out.println(Add("1\n2,3"));
        System.out.println(Add("//;\\n1;2"));
        System.out.println(Add("//[***]\\n1***2***3"));
        System.out.println(Add("//[*][%]\\n1*2%3"));
    }

    public static int Add(String... number) {
        boolean testpass = false;
        String[] compareString = new String[number.length];
        int ans = 0;
        /*
         for checking unwanted character and removing it.
         */
        for (String s : number) {
           if(s!=null && s.length()!=0){
            if (s.contains("\n") || (s.contains("\\n"))) {
                String s1 = s.replaceAll("\n", " ")
                        .replaceAll("n", "")
                        .replaceAll("[^a-zA-Z0-9]","");

                compareString = s1.split("");
                testpass = true;
            }
            else
                break;
           }
        }

        /*
         assigning original value which was passed initially if there is no unwanted character.
         */
            if(testpass == true){
            }else compareString = number;
           /*
            checking if the string is empty
            */
            if(compareString[0].hashCode()==0 ){
                ans = 0;
                return ans;
            }
            else{
                for(String s : compareString){
                if(Integer.parseInt(s)<0){
                    showNegative(compareString);
                }
                ans = ans+Integer.parseInt(s);
                }
            }
    return ans;
    }
    /*
     it will print negative input
     */
    private static void showNegative(String[] s) {
        try {
                    throw new IllegalArgumentException("negatives not allowed");

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    for (String s1 : s) {
                        System.out.println(s1);
                    }
                    System.exit(0);

                }
    }
}

