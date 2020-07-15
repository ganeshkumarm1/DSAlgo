package FastExponentiation;

public class FastExponentiation {
    private final long modulo;

    public FastExponentiation(long modulo) {
        this.modulo = modulo;
    }

    public long power(long base, long exponent) {
        base = base % modulo;

        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        long result = 1;

        while (exponent > 0) {

           if((exponent & 1) == 1) {
               result = (result * base) % modulo;
           }

           exponent = exponent >> 1;
           base = (base * base) % modulo;

        }

        return result;
    }
}
