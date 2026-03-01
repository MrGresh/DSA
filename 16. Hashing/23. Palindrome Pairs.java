class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words.length;j++) {
                if(i!=j) {
                    if(isPal(words[i], words[j])) res.add(Arrays.asList(i, j));
                } 
            }
        }
        return res;
    }
    boolean isPal(String a, String b) {
        String s = a + b;
        int i=0, j=s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
----------------------------------------------------------------------------------------------
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (map.containsKey("") && isPalindrome(word) && map.get("") != i) {
                ansSet.add(Arrays.asList(i, map.get("")));
                ansSet.add(Arrays.asList(map.get(""), i));
            }

            for (int k = 1; k <= word.length(); k++) {
                String prefix = word.substring(0, k);
                String suffix = word.substring(k);

                if (isPalindrome(prefix) && map.containsKey(suffix)) {
                    ansSet.add(Arrays.asList(map.get(suffix), i));
                }
                if (isPalindrome(suffix) && map.containsKey(prefix) && map.get(prefix) != i) {
                    ansSet.add(Arrays.asList(i, map.get(prefix)));
                }
            }
        }

        res.addAll(ansSet);
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
