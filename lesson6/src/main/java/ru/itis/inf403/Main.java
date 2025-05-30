package ru.itis.inf403;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {-1000,1,5,7,9,23,1,6,8};
        System.out.println(max(array,0,array.length-1));
        System.out.println(karate("10011011","10111010"));
    }

    public static int max(int[] array, int l, int r) {
        if (r-l == 1) {return array[l];}
        int max1 = max(array,l,r-((r-l)/2));
        int max2 = max(array,l+((r-l)/2),r);
        return max1>max2? max1:max2;
    }

    public static Integer karate(String s1, String s2) {
        if (s1.length() == 1 && s2.length() == 1) {
            int n1 = s1.charAt(0) - '0';
            int n2 = s2.charAt(0) - '0';
            return Integer.valueOf(n1 * n2);
        }
        String a = s1.substring(0,s1.length()/2);
        String b = s1.substring(s1.length()/2);
        double x = Math.pow(2,s1.length()/2);
        String c = s2.substring(0,s2.length()/2);
        String d = s2.substring(s2.length()/2,s2.length());
        return (int) (karate(a,c)*x*x+karate(b,d)+((karate(b,c)+karate(a,d))*x));
    }
}
