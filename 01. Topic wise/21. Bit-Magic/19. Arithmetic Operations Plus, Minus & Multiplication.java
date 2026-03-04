AND (&) identifies where the carry happens (e.g., $1 + 1$ produces a carry).
XOR (^) acts as the addition without the carry (e.g., $1 + 1 = 0$ in that column).
Shift (<< 1) moves the carry to the next position.

public int add(int a, int b) {
    while (b != 0) {
        int carry = a & b;    // Find where both bits are 1
        a = a ^ b;            // Sum bits where only one is 1
        b = carry << 1;       // Shift carry to the left
    }
    return a;
}
--------------------------------------------------------------------
public int subtract(int a, int b) {
    // b = ~b + 1 (Two's Complement)
    // Then we add that to a
    return add(a, add(~b, 1));
}
OR
public int subtract(int a, int b) {
    return add(a, -b); // -b = ~b + 1
}
--------------------------------------------------------------------
public int multiply(int a, int b) {
    int result = 0;
    while (b != 0) {
        // If the last bit of b is 1, add a to result
        if ((b & 1) == 1) {
            result = add(result, a); 
        }
        a <<= 1; // Double a
        b >>>= 1; // Halve b (using logical shift for safety)
    }
    return result;
}
--------------------------------------------------------------------
Sum (no carry) : a ^ b
Carry : (a & b) << 1
Negative (-a) : ~a + 1
Double (2a) : a << 1
Halve (a/2) : a >> 1
