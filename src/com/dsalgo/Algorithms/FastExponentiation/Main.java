package Algorithms.FastExponentiation;

public class Main {
    public static void main(String[] args) {
        FastExponentiation fastExponentiation = new FastExponentiation(1000000007);

        System.out.println(fastExponentiation.power(2, 8));
        System.out.println(fastExponentiation.power(10, 100000000));
        System.out.println(fastExponentiation.power(2, 2000));
        System.out.println(fastExponentiation.power(2, 1789));
    }
}
