package com.demo.test;

/**
 * Created by Administrator on 2019/2/14.
 */
public class Dream {
    public static void getAiXin(){
        for(float y = (float) 1.5;y>-1.5;y -=0.1)  {
            for(float x= (float) -1.5;x<1.5;x+= 0.05){
                float a = x*x+y*y-1;
                if((a*a*a-x*x*y*y*y)<=0.0)  {
                    System.out.print("^");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String showLove(String input) {

        int[] array = { 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1,
                0, 0, 1, 1, 4, 5, 2, 3, 4, 1, 0, 1,

                0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0 };

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; i++) {

            if (i % 7 == 0)

                sb.append("  \n");

            if (array[i] == 0)

                sb.append("   ");

            else if (array[i] == 4)

                sb.append("  ");

            else if (array[i] == 5)

                sb.append(" I ");

            else if (array[i] == 2)

                sb.append("Lvoe ");

            else if (array[i] == 3)

                sb.append("You");

            else

                sb.append("  " + input);

        }

        return sb.toString();

    }



   /* public static void main(String[] args) {
        while (true) {
            String myLover = "";
            for (int i = 0; i < 3; i++) {
                char a = (char) (Math.random() * 26 + 65);
                myLover = myLover + a;
            }
            if (myLover.equals("YOU")) {
                System.out.println(showLove("*"));
                break;
            }
        }
    }*/


}
