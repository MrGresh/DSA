& (AND) : 1 only if both bits are 1.

| (OR) : 1 if at least one bit is 1.

^ (XOR) : 1 if bits are different. (Important!)

~ (NOT) : "Flips all bits (0 becomes 1, 1 becomes 0)."

<< (Left Shift) : Moves bits left; fills with 0. (Multiplies by 2).

>> (Right Shift) : Moves bits right; discards end bits. (Divides by 2).
---------------------------------------------------------------------------------------
The "Big Four" Bit Hacks

1. extract ith bit :
int bit = (n & (1 << i));
int bit = ((n>>i) & 1);

2. Set ith bit :
n = n | (1 << i);

3. Clear ith bit
n = n & ~(1 << i);

4. Toggle ith bit
n = n ^ (1 << i);
---------------------------------------------------------------------------------------
Shortcuts

1. Check if even/odd:
if ((n & 1) == 1) -> odd 
else even

2. Multiply/Divide by 2^k:
Multiply: n << k
Divide: n >> k

3. The "Power of 2" Check:
If ((n & (n - 1)) == 0) yes
else No

4. XOR Properties (Magic):
x ^ x = 0 (A number XORed with itself cancels out).
x ^ 0 = x (A number XORed with zero stays the same).

5. Turn off the rightmost set bit
n = n & (n - 1);

6. n ^ (n-1)
Let's trace n = 12 (1100):
(n-1): 1011
n ^ (n-1): 0111
The Result: This creates a mask of 1s starting from the rightmost set bit all the way to the right. This is very useful when you need to process all trailing bits at once.

7. ~n = -(n+1)

8. (n & ~n) = 0

9. (n & -(n+1)) = 0

---------------------------------------------------------------------------------------
1. 1’s Complement
The 1’s complement is the simplest way to invert a binary number. You just flip every bit.
Rule: Change all 1s to 0s and all 0s to 1s.

Example: Find the 1’s complement of 101101.
Original: 1 0 1 1 0 1
Result:   0 1 0 0 1 0

The Problem: 1's complement has a "Double Zero" problem. It has a representation for $+0$ (0000) and $-0$ (1111). This makes hardware logic messy and inefficient.
---------------------------------------------------------------------------------------
2. 2’s Complement
This is the standard used by almost every modern computer. It fixes the "double zero" problem and makes binary arithmetic much smoother.
Rule: Find the 1’s complement, then add 1 to the least significant bit (LSB).
Formula: 2's Complement = (1's Complement) + 1

Step-by-Step Example: Find -5 (using 4 bits)
1. Start with +5: 0101
2. 1’s Complement: 1010 (Flip the bits)
3. Add 1: 1010 + 1 = 1011
4. Result: -5 is represented as 1011

The "Fast Trick" for 2's Complement
1. Scan the binary number from right to left.
2. Keep all bits the same until you hit the first 1.
3. Keep that first 1 as it is.
4. Flip all remaining bits to the left of it.

Example: 101[100] ---- 2's Complement ----> 010[100]

Tip: Isolate the rightmost set bit (2 Ways): 
n & -n
(n & (n-1)) ^ n
