# ⏱️ Complexity Quick Reference

A cheat sheet for Big O time and space complexity of common algorithms and data structures.

| Algorithm / Structure | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Binary Search** | $O(\log n)$ | $O(1)$ |
| **Hash Table** (Average) | $O(1)$ insert / get | $O(n)$ |
| **Heap** insert / extract | $O(\log n)$ | $O(n)$ |
| **Merge Sort** / **Heap Sort** | $O(n \log n)$ | $O(n)$ / $O(1)$ |
| **Quicksort** | $O(n \log n)$ avg, $O(n^2)$ worst | $O(\log n)$ |
| **BFS** / **DFS** | $O(V + E)$ | $O(V)$ |
| **Union-Find** (with Path Comp.) | $O(\alpha(n))$ per op | $O(n)$ |
| **Trie** insert / search | $O(L)$, $L$ = word length | $O(\text{total chars})$ |
| **2D DP** | $O(m \cdot n)$ | $O(m \cdot n)$ or $O(n)$ |

---

### 💡 Key Takeaways
* **Space Optimization:** In 2D DP, you can often reduce space from $O(m \cdot n)$ to $O(n)$ by only storing the previous row/column.
* **The $\alpha(n)$ Term:** This is the Inverse Ackermann function, which grows so slowly that it is effectively $O(1)$ for all practical values of $n$.
* **Quicksort Space:** The $O(\log n)$ space for Quicksort comes from the recursive call stack.
