class Solution {
    public int countVowelSubstrings(String s) {
        int n = s.length();
        int res = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < n-4; i++) {
            if (vowels.contains(s.charAt(i))) {
                Set<Character> foundVowels = new HashSet<>();
                foundVowels.add(s.charAt(i));
                for (int j = i+1; j < n; j++) {
                    if (!vowels.contains(s.charAt(j))) break;
                    foundVowels.add(s.charAt(j));
                    if (foundVowels.size() == 5) res++;
                }
            }
        }
        return res;
    }
}
