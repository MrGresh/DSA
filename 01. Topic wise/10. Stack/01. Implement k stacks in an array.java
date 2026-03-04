class kStacks {
    private int[] arr;   // Stores actual elements
    private int[] top;   // Stores top indices of k stacks
    private int[] next;  // Stores next items in stack or next free slots
    private int n, k;
    private int free;    // Head of the free list

    public kStacks(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        // Initialize all slots as free
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // End of free list
    }

    // Pushes x into stack number i (0 to k-1)
    public void push(int x, int i) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int currentFree = free;     // Select the first free slot
        free = next[free];   // Update free to the next available slot

        // Link the new node to the previous top of stack i
        next[currentFree] = top[i];
        top[i] = currentFree;       // Update top to the new slot

        arr[currentFree] = x;       // Insert the value
    }

    // Pops element from stack number i (0 to k-1)
    public int pop(int i) {
        if (isEmpty(i)) {
            return -1;
        }

        int topIndex = top[i];      // Get the current top index
        top[i] = next[topIndex];    // Move top to the element below

        // Add the popped slot back to the free list
        next[topIndex] = free;
        free = topIndex;

        return arr[topIndex];
    }

    public boolean isEmpty(int i) {
        return top[i] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }
}
