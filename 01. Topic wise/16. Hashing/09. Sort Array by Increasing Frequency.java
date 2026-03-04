class Solution {
    public int[] frequencySort(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        List<Integer>[] list = new ArrayList[101];
        for(int x : m.keySet()) {
            int val = m.get(x);
            List<Integer> lis = list[val];
            if(lis==null) lis = new ArrayList<>();
            lis.add(x);
            list[val] = lis;
        }
        int k = 0;
        for(int i=0;i<101;i++) {
            if(list[i]!=null) {
                if(list[i].size()==1) {
                    for(int a=1;a<=i;a++) arr[k++] = list[i].get(0);
                }
                else {
                    Collections.sort(list[i], Collections.reverseOrder());
                    for(int j=0;j<list[i].size();j++) {
                        for(int a=1;a<=i;a++) arr[k++] = list[i].get(j);
                    }
                }
            }
        }
        return arr;
    }
}
-----------------------------------------------------------------------------------------
class Solution {
    public int[] frequencySort(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, (a, b) -> {
            int freqCompare = frequencyMap.get(a).compareTo(frequencyMap.get(b));
            if (freqCompare == 0) return b.compareTo(a);
            return freqCompare;
        });
        for (int i = 0; i < arr.length; i++) arr[i] = integerArray[i];
        return arr;
    }
}
