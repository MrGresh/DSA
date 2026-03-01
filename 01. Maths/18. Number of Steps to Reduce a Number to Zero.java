class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }
}
----------------------------------------
// Bit Magic
class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int steps = 0;
        while (num > 0) {
            if ((num & 1) == 1) steps += (num > 1) ? 2 : 1;
            else steps += 1;
            num >>= 1;
        }
        return steps;
    }
}
