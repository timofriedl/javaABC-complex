package math;

public record Complex(double real, double imaginary) {
    public static final Complex ZERO = new Complex(0.0, 0.0);
    public static final Complex ONE = new Complex(1.0, 0.0);
    public static final Complex TWO = new Complex(2.0, 0.0);
    public static final Complex TEN = new Complex(10.0, 0.0);
    public static final Complex I = new Complex(0.0, 1.0);

    public static Complex fromDouble(double real) {
        return new Complex(real, 0.0);
    }

    public static Complex fromPolar(double abs, double arg) {
        double real = abs * Math.cos(arg);
        double imaginary = abs * Math.sin(arg);
        return new Complex(real, imaginary);
    }

    public Complex add(Complex addend) {
        return new Complex(real + addend.real, imaginary + addend.imaginary);
    }

    public Complex sub(Complex subtrahend) {
        return new Complex(real - subtrahend.real, imaginary - subtrahend.imaginary);
    }

    public Complex mul(Complex factor) {
        double a = real;
        double b = imaginary;
        double c = factor.real;
        double d = factor.imaginary;
        return new Complex(a * c - b * d, a * d + b * c);
    }

    public Complex div(Complex divisor) {
        double a = real;
        double b = imaginary;
        double c = divisor.real;
        double d = divisor.imaginary;
        double sum = c * c + d * d;
        return new Complex((a * c + b * d) / sum, (b * c - a * d) / sum);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double arg() {
        return Math.atan2(imaginary, real);
    }

    public static Complex exp(Complex exponent) {
        return fromPolar(Math.exp(exponent.real), exponent.imaginary);
    }

    public static Complex log(Complex argument) {
        return new Complex(Math.log(argument.abs()), argument.arg());
    }

    public Complex pow(Complex exponent) {
        return exp(log(this).mul(exponent));
    }

    @Override
    public String toString() {
        if (imaginary < 0.0)
            return real + " - " + -imaginary + "i";

        return real + " + " + imaginary + "i";
    }
}
