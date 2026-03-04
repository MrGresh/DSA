class Solution {
    public int splitNum(int n) {
        List<Integer> digits = new ArrayList<>();
        while(n>0) {
            digits.add(n%10);
            n /= 10;
        }
        Collections.sort(digits);
        int i = 0, j = 1;
        int num1 = 0, num2 = 0;
        while(i<digits.size() && j<digits.size()) {
            num1 = num1*10 + digits.get(i);
            num2 = num2*10 + digits.get(j);
            i += 2;
            j += 2;
        }
        if(i<digits.size()) {
            num1 = num1*10 + digits.get(i);
        }
        if(j<digits.size()) {
            num2 = num2*10 + digits.get(j);
        }
        return num1 + num2;
    }
}
