public class PairSumExists {
    public static void findPairs(int[] arr) {
        // Step 1: Store all elements in a HashSet for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        System.out.println("Pairs whose sum exists in the array:");
        boolean found = false;

        // Step 2: Iterate through all unique pairs (using indices)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                // Step 3: Check if sum is in our set
                if (set.contains(sum)) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No such pairs found.");
        }
    }
}
