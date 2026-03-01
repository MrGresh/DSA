class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] arr = new String[words.length];
        for(String word : words) {
            arr[Character.getNumericValue(word.charAt(word.length()-1))-1] = word.substring(0, word.length()-1);
        }
        StringBuilder res = new StringBuilder();
        for(int k=0;k<arr.length;k++) {
            if(k!=arr.length-1) res.append(arr[k]+ " ");
            else res.append(arr[k]);
        }
        return res.toString();
    }
}
