# ArrayList in Java — Collection Framework

## What is an ArrayList?

`ArrayList` is a resizable array implementation of the `List` interface in Java's Collection Framework. Unlike regular arrays, an `ArrayList` can grow and shrink dynamically as elements are added or removed.

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## Core Collection Methods

These methods are inherited from the `Collection` interface and work across all Java collections.

### `add(element)`
Appends an element to the end of the list.

```java
list.add(10);
list.add(33);
list.add(234);
// list → [10, 33, 234]
```

---

### `addAll(collection)`
Merges all elements from another collection into the current list.

```java
list.addAll(list2);
// list → [10, 33, 234, 1, 3, 5]
```

---

### `size()`
Returns the number of elements currently in the list.

```java
list.size(); // → 6
```

---

### `clear()`
Removes all elements from the list. The list becomes empty (`size = 0`).

```java
list2.clear();
list2.size(); // → 0
```

---

### `isEmpty()`
Returns `true` if the list contains no elements, `false` otherwise.

```java
list.isEmpty();  // → false (has elements)
list4.isEmpty(); // → true  (nothing added)
```

---

## Iterating with an Iterator

An `Iterator` is a universal, interface-based way to traverse **any** Java collection safely.

```java
Iterator<Integer> itr = list.iterator();
while (itr.hasNext()) {
    System.out.println("Element via iterator: " + itr.next());
}
```

| Method | Description |
|---|---|
| `hasNext()` | Returns `true` if more elements remain |
| `next()` | Returns the next element and advances the cursor |

> **Why use Iterator?** It works on any collection (List, Set, Queue) and allows safe element removal during traversal using `itr.remove()`.

---

## ArrayList-Specific Methods

These methods are specific to `ArrayList` and are not available on all collections.

### 1. `get(index)`
Retrieves the element at the given index (0-based).

```java
list3.get(0); // → 10
list3.get(2); // → 30
```

---

### 2. `set(index, element)`
Replaces the element at the given index with a new value.

```java
// list3 → [10, 20, 30]
list3.set(0, 100);
// list3 → [100, 20, 30]
```

---

### 3. `toArray()`
Converts the `ArrayList` into a plain `Object[]` array.

```java
Object[] arr = list3.toArray();
for (Object obj : arr) {
    System.out.println(obj); // 100, 20, 30
}
```

> The return type is `Object[]`. You can cast to a typed array if needed: `list3.toArray(new Integer[0])`.

---

### 4. `contains(element)`
Checks whether a specific element exists in the list. Returns `true` or `false`.

```java
list3.contains(20);  // → true
list3.contains(211); // → false
```

---

### 5. `indexOf(element)`
Returns the index of the **first occurrence** of the specified element. Returns `-1` if not found.

```java
list.indexOf(355); // → index of 355, or -1 if absent
```

---

### 6. `clone()`
Creates a **shallow copy** of the ArrayList. The new list is independent — adding/removing elements in one does **not** affect the other.

```java
ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();

list.add(355);
// clonedList is unchanged — it doesn't reflect this addition
```

> **Shallow Copy** means the list structure is copied, but for object types, both lists still point to the same underlying objects.

---

### 7. `ensureCapacity(minCapacity)`
Pre-allocates internal storage for at least `minCapacity` elements. This is a **performance hint** — it avoids repeated resizing when you know in advance how many elements you'll be adding.

```java
ArrayList<Integer> list4 = new ArrayList<>();
list4.ensureCapacity(10); // reserves space for 10 elements upfront
```

---

## Sorting with `Collections.sort()`

### Default Sort (Ascending)

```java
Collections.sort(list);
// [1, 3, 5, 10, 33, 234] — natural ascending order
```

### Custom Sort with a Comparator (Lambda)

```java
// Ascending (explicit)
Collections.sort(list, (a, b) -> Integer.compare(a, b));

// Descending
Collections.sort(list, (a, b) -> Integer.compare(b, a));
```

The comparator lambda `(a, b) -> Integer.compare(a, b)` follows the contract:
- Returns **negative** → `a` comes before `b`
- Returns **zero** → equal
- Returns **positive** → `b` comes before `a`

Swapping `a` and `b` in `Integer.compare(b, a)` flips the sort to descending.

---

## Quick Reference Summary

| Method | Description | Return Type |
|---|---|---|
| `add(e)` | Append element | `boolean` |
| `addAll(c)` | Append all from collection | `boolean` |
| `size()` | Number of elements | `int` |
| `clear()` | Remove all elements | `void` |
| `isEmpty()` | Check if list is empty | `boolean` |
| `get(i)` | Element at index `i` | `T` |
| `set(i, e)` | Replace element at index `i` | `T` (old value) |
| `contains(e)` | Check if element exists | `boolean` |
| `indexOf(e)` | First index of element | `int` |
| `toArray()` | Convert to Object array | `Object[]` |
| `clone()` | Shallow copy of the list | `Object` |
| `ensureCapacity(n)` | Pre-allocate capacity | `void` |
| `Collections.sort(list)` | Sort ascending | `void` |
| `Collections.sort(list, comp)` | Sort with custom comparator | `void` |

---

## Key Takeaways

- `ArrayList` is backed by a **dynamic array** — fast for random access (`get`/`set`) but slower for insertions/deletions in the middle.
- Use `Iterator` when you need to traverse **and** remove elements safely.
- `clone()` gives a **shallow copy** — safe for primitives and immutable types like `Integer`, `String`.
- `ensureCapacity()` is a performance optimization, not a size limit.
- `Collections.sort()` with a lambda comparator gives full control over sort order.