# Java Collection Framework vs C++ STL

A side-by-side mapping for developers who know both languages. Especially useful when translating DSA solutions between Java and C++.

---

## Sequences

| Java | C++ STL | Match | Key Differences |
|---|---|---|---|
| `ArrayList` | `vector<T>` | Exact | Nearly identical. Java uses `get(i)` / `set(i, v)`; C++ uses `[]` operator |
| `LinkedList` | `list<T>` | Exact | Java `LinkedList` also acts as `Queue` + `Deque`. C++ splits these into separate containers |
| `Stack` | `stack<T>` | Exact | Both are adapters. Prefer `ArrayDeque` in Java; C++ `stack` wraps `deque` by default |
| `Vector` (legacy) | `vector<T>` | Close | Java `Vector` is synchronized (slow). C++ `vector` is not thread-safe. Avoid Java `Vector` |

---

## Queue & Deque

| Java | C++ STL | Match | Key Differences |
|---|---|---|---|
| `ArrayDeque` | `deque<T>` | Exact | Both support O(1) push/pop at both ends. Java uses `addFirst/addLast`; C++ uses `push_front/push_back` |
| `PriorityQueue` | `priority_queue<T>` | Close — reversed! | **Java = min-heap. C++ = max-heap.** Common DSA trap — see note below |
| `LinkedList` as `Queue` | `queue<T>` | Close | C++ `queue` is a clean FIFO adapter. Java uses `LinkedList` cast to `Queue`, or `ArrayDeque` |

---

## Sets

| Java | C++ STL | Match | Key Differences |
|---|---|---|---|
| `HashSet` | `unordered_set<T>` | Exact | Same O(1) avg insert/lookup. C++ uses `count()` to check membership; Java uses `contains()` |
| `TreeSet` | `set<T>` | Exact | Identical Red-Black tree internals. Java has `floor/ceiling/higher/lower`; C++ uses `lower_bound/upper_bound` iterators |
| `LinkedHashSet` | — | No match | No STL equivalent. Workaround: `unordered_set` + separate `vector` to track insertion order |

---

## Maps

| Java | C++ STL | Match | Key Differences |
|---|---|---|---|
| `HashMap` | `unordered_map<K,V>` | Exact | Java `map.get(k)` returns `null` if absent. C++ `map[k]` **inserts a default value** — use `count()` or `find()` to check first |
| `TreeMap` | `map<K,V>` | Exact | Both Red-Black trees, O(log n). Java has `floorKey/ceilingKey`; C++ uses `lower_bound/upper_bound` |
| `LinkedHashMap` | — | No match | No STL equivalent. Workaround: `unordered_map` + `vector<key>` to preserve insertion order |

---

## The Big DSA Gotcha — `PriorityQueue` Default Order is Flipped

This silently produces wrong answers when converting solutions between the two languages.

| | Java | C++ |
|---|---|---|
| Default | **Min-heap** (smallest out first) | **Max-heap** (largest out first) |

```java
// Java — min-heap (default)
PriorityQueue<Integer> pq = new PriorityQueue<>();

// Java — max-heap
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

```cpp
// C++ — max-heap (default)
priority_queue<int> pq;

// C++ — min-heap
priority_queue<int, vector<int>, greater<int>> pq;
```

---

## Method Name Cheat Sheet

| Operation | Java | C++ |
|---|---|---|
| Add to back | `add(e)` / `addLast(e)` | `push_back(e)` |
| Add to front | `addFirst(e)` | `push_front(e)` |
| Remove from front | `poll()` / `removeFirst()` | `pop_front()` |
| Remove from back | `pollLast()` / `removeLast()` | `pop_back()` |
| Peek front | `peek()` / `peekFirst()` | `front()` |
| Peek back | `peekLast()` | `back()` |
| Check if key exists (Map) | `containsKey(k)` | `count(k)` or `find(k) != end()` |
| Check if element exists (Set/List) | `contains(e)` | `count(e)` |
| Size | `size()` | `size()` |
| Empty check | `isEmpty()` | `empty()` |
| Sort a list | `Collections.sort(list)` | `list.sort()` or `sort(v.begin(), v.end())` |
| Reverse | `Collections.reverse(list)` | `reverse(v.begin(), v.end())` |
| Min / Max | `Collections.min(list)` | `*min_element(v.begin(), v.end())` |

---

## Things C++ STL Has That Java Doesn't

### `splice()` — O(1) node transfer between lists
```cpp
list<int> a = {1, 2, 3};
list<int> b = {4, 5, 6};
a.splice(a.end(), b);  // moves all of b into a — O(1), no copying
// a = {1,2,3,4,5,6},  b = {}
```
Java's `addAll()` copies elements — it's O(n).

### `lower_bound` / `upper_bound` as free functions
```cpp
vector<int> v = {1, 3, 5, 7};
auto it = lower_bound(v.begin(), v.end(), 4); // points to 5
```
In Java, binary search on a sorted list uses `Collections.binarySearch()`, which returns an index, not an iterator.

---

## Things Java Has That C++ STL Doesn't

### `LinkedHashSet` and `LinkedHashMap`
Insertion-ordered hash structures with O(1) lookup. No STL equivalent exists natively.

### `getOrDefault()` on maps
```java
map.getOrDefault(key, 0);  // returns 0 if key not present
```
C++ `map[key]` inserts a zero-initialised default — a side effect Java avoids.

### `Collections` utility class
`Collections.sort()`, `Collections.shuffle()`, `Collections.frequency()`, `Collections.unmodifiableList()` — a rich set of static helpers with no single C++ equivalent (they're spread across `<algorithm>` and `<numeric>`).

---

## Quick Picks for DSA Problems

| Use case | Java | C++ |
|---|---|---|
| Dynamic array | `ArrayList` | `vector` |
| Stack | `ArrayDeque` | `stack` |
| Queue (BFS) | `ArrayDeque` / `LinkedList` | `queue` |
| Min-heap | `PriorityQueue` (default) | `priority_queue<int, vector<int>, greater<int>>` |
| Max-heap | `PriorityQueue(reverseOrder())` | `priority_queue` (default) |
| Fast lookup set | `HashSet` | `unordered_set` |
| Sorted set / order stats | `TreeSet` | `set` |
| Fast lookup map | `HashMap` | `unordered_map` |
| Sorted map | `TreeMap` | `map` |
| Sliding window / monotonic deque | `ArrayDeque` | `deque` |