# 🚩 Interview Strategy: Red & Green Flags

A guide to the behavioral and logical habits that make or break a technical interview.

---

## ⚠️ Common Mistakes to Avoid (The Red Flags)

* **Ignoring Edge Cases:** Always check for `empty input`, `single element`, `negative numbers`, or `all duplicates`.
* **Binary Search "Guessing":** Don't pick `lo <= hi` or `lo < hi` randomly. Know your exit condition.
* **Graph Infinite Loops:** Forgetting a `visited[]` set/array in DFS/BFS is a guaranteed way to crash your solution.
* **Integer Overflow:** In languages like Java or C++, remember to use `long` when multiplying large numbers or calculating midpoints.
* **Destructive Mutation:** Never modify the input array/string without asking, "Am I allowed to mutate the input?"
* **Silent Coding:** Jumping into implementation before clarifying constraints ($N$ size, memory limits, etc.) is a major red flag.
* **Tunnel Vision:** Not communicating trade-offs. Interviewers want to see your thought process, not just a script.

---

## ✅ The 'Green Flags' (What Interviewers Love)

* **[ ] Clarify First:** You ask clarifying questions (e.g., "Is the input sorted?") before writing a single line.
* **[ ] Think Out Loud:** You state your approach and get a "thumbs up" from the interviewer before implementing.
* **[ ] Proactive Edge Cases:** You call out potential pitfalls (like null checks) while you are still in the logic phase.
* **[ ] Complexity-First:** You mention Big O Time and Space complexity unprompted.
* **[ ] The "Pivot":** When stuck, you start with **Brute Force** and then explicitly say, "Now, let's optimize this to $O(n)$."
* **[ ] Manual Trace:** You dry-run your code with a small example after writing it to catch typos or logic gaps.

---
*Tip: Treat the interviewer as a collaborator, not an examiner.*
