class Solution {
    private Map<String, Boolean> memo;
    public boolean checkValidString(String s) {
        memo = new HashMap<>();
        return backtrack(s, 0, 0);
    }

    private boolean backtrack(String s, int index, int balance) {
        if (balance < 0) return false;

        if (index == s.length()) return balance == 0;

        String key = index + "," + balance;
        if (memo.containsKey(key)) return memo.get(key);

        char c = s.charAt(index);
        boolean isValid = false;

        if (c == '(') {
            isValid = backtrack(s, index + 1, balance + 1);
        } else if (c == ')') {
            isValid = backtrack(s, index + 1, balance - 1);
        } else {
            isValid = backtrack(s, index + 1, balance + 1) ||
                backtrack(s, index + 1, balance - 1) ||
                backtrack(s, index + 1, balance);
        }

        memo.put(key, isValid);
        return isValid;
    }
}
