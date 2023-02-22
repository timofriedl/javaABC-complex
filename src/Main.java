import math.Complex;

import static math.Complex.*;

public class Main {
    public static void main(String[] args) {
        Complex e = Complex.fromDouble(Math.E);
        Complex pi = Complex.fromDouble(Math.PI);

        System.out.println(e.pow(pi.mul(I)));
    }
}
