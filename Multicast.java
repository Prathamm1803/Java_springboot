public class Multicast {

    public static void main(String[] args) {

        double p1 = 0.33;
        double p2 = 0.50;
        double p3 = 0.50;

        double f1 = 1 - p1;
        double f2 = 1 - p2;
        double f3 = 1 - p3;

        double case1 = p1 * p2 * p3;       
        double case2 = p1 * p2 * f3;       
        double case3 = p1 * f2 * p3;       
        double case4 = p1 * f2 * f3;       
        double case5 = f1 * p2 * p3;     
        double case6 = f1 * p2 * f3;       
        double case7 = f1 * f2 * p3;     
        double case8 = f1 * f2 * f3;       

        System.out.println("Case 1 (S,S,S): " + case1);
        System.out.println("Case 2 (S,S,F): " + case2);
        System.out.println("Case 3 (S,F,S): " + case3);
        System.out.println("Case 4 (S,F,F): " + case4);
        System.out.println("Case 5 (F,S,S): " + case5);
        System.out.println("Case 6 (F,S,F): " + case6);
        System.out.println("Case 7 (F,F,S): " + case7);
        System.out.println("Case 8 (F,F,F): " + case8);

        double total = case1 + case2 + case3 + case4 + case5 + case6 + case7 + case8;
        System.out.println("Total probability: " + total);
    }
}