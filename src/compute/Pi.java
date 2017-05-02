package client;

import compute.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public interface Pi {

   private static final long serialVersionUID = 227L;
//    private BigDecimal piCalc = BigDecimal.valueOf(777);
//
//    /** constants used in pi computation */
   private static final BigDecimal FOUR = BigDecimal.valueOf(4);
//
//    /** rounding mode to use during pi computation */
   private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
//
//    /** digits of precision after the decimal point */
//    private final int digits;
//    

    public BigDecimal retrieve();
    /**
     * Calculate pi.
     */
    public BigDecimal execute();
    

    /**
     * Compute the value of pi to the specified number of 
     * digits after the decimal point.  The value is 
     * computed using Machin's formula:
     *
     *          pi/4 = 4*arctan(1/5) - arctan(1/239)
     *
     * and a power series expansion of arctan(x) to 
     * sufficient precision.
     */
    public static BigDecimal computePi(int digits);
    /**
     * Compute the value, in radians, of the arctangent of 
     * the inverse of the supplied integer to the specified
     * number of digits after the decimal point.  The value
     * is computed using the power series expansion for the
     * arc tangent:
     *
     * arctan(x) = x - (x^3)/3 + (x^5)/5 - (x^7)/7 + 
     *     (x^9)/9 ...
     */   
    public static BigDecimal arctan(int inverseX, int scale);
}
