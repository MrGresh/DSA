class kQueues {
    int[] arr;      // To store actual values
    int[] front;    // To store front indices of k queues
    int[] rear;     // To store rear indices of k queues
    int[] next;     // To store next entry in queue or next free slot
    int n, k;
    int free;       // To store beginning index of free list

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
        }

        // Initialize all slots as free
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // End of free list
    }

    // Adds element x to the i-th queue
    void enqueue(int x, int i) {
        if (isFull()) {
            return;
        }

        int nextFree = next[free]; // Find next free slot

        if (isEmpty(i)) {
            front[i] = rear[i] = free;
        } else {
            // Update the next pointer of the current rear
            next[rear[i]] = free;
            rear[i] = free;
        }

        next[free] = -1; // New element is now the tail
        arr[free] = x;   // Put value in array
        free = nextFree; // Update free pointer
    }

    // Removes front element from i-th queue
    int dequeue(int i) {
        if (isEmpty(i)) {
            return -1;
        }

        // Find index of front item
        int headIndex = front[i];

        // Move front to the next item in the queue
        front[i] = next[headIndex];

        // If queue becomes empty, update rear as well
        if (front[i] == -1) {
            rear[i] = -1;
        }

        // Add the dequeued slot back to the free list
        next[headIndex] = free;
        free = headIndex;

        return arr[headIndex];
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}
