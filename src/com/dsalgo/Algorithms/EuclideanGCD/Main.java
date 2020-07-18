package Algorithms.EuclideanGCD;

public class Main {
    public static void main(String[] args) {
        EuclideanGCD euclideanGCD = new EuclideanGCD();

        System.out.println(euclideanGCD.gcd(30, 4));
        System.out.println(euclideanGCD.gcd(10, 9));
        System.out.println(euclideanGCD.gcd(222, 2));
        System.out.println(euclideanGCD.gcd(0, 1));
    }
}
