# Java Collection Framework

## What is the Collection Framework?

The **Java Collection Framework (JCF)** is a unified architecture for storing, managing, and manipulating groups of objects. It provides a set of **interfaces**, **implementations (classes)**, and **algorithms** that make working with data structures simple and consistent.

Introduced in **Java 1.2**, it lives under the `java.util` package and is one of the most fundamental parts of the Java standard library.

```java
import java.util.*;
```

---

## Why Use the Collection Framework?

| Without JCF | With JCF |
|---|---|
| Manual array resizing | Dynamic sizing built-in |
| No standard API | Consistent methods across all structures |
| Reimplementing algorithms | Ready-made sort, search, shuffle |
| Type-unsafe structures | Generics ensure type safety |
| Hard to switch data structures | Program to interfaces, swap implementations freely |

---

## Architecture Overview

```
                        «interface»
                        Iterable<E>
                            │
                        «interface»
                        Collection<E>
                ┌───────────┼────────────┐
           «interface»  «interface»  «interface»
            List<E>      Set<E>       Queue<E>
               │            │             │
       ┌───────┴──────┐  ┌──┴──────┐  ┌──┴───────────┐
  ArrayList  LinkedList HashSet  TreeSet  PriorityQueue  Deque
  Vector     Stack    LinkedHashSet         ArrayDeque
                                               LinkedList


                        «interface»
                         Map<K,V>
                    ┌──────┴────────┐
                HashMap          TreeMap
             LinkedHashMap      Hashtable
```

---

## Core Interfaces

### `Collection<E>`
The root interface of the hierarchy. Defines the most basic operations shared by all collections.

Key methods: `add()`, `remove()`, `size()`, `clear()`, `contains()`, `iterator()`

---

### `List<E>`
An **ordered** collection that allows **duplicate** elements. Elements can be accessed by their index.

- Maintains insertion order
- Allows positional access via `get(index)`
- Duplicates are permitted

**Implementations:** `ArrayList`, `LinkedList`, `Vector`, `Stack`

---

### `Set<E>`
A collection that **does not allow duplicates**. Models the mathematical concept of a set.

- No guaranteed order (except `LinkedHashSet` and `TreeSet`)
- At most one `null` element (depends on implementation)
- No index-based access

**Implementations:** `HashSet`, `LinkedHashSet`, `TreeSet`

---

### `Queue<E>`
A collection designed for **FIFO (First-In, First-Out)** processing. Elements are inserted at the tail and removed from the head.

- Used for task scheduling, BFS, buffers
- `PriorityQueue` orders by natural order or comparator

**Implementations:** `PriorityQueue`, `ArrayDeque`, `LinkedList`

---

### `Deque<E>`
A **double-ended queue** that allows insertion and removal from **both ends**. Can act as both a stack and a queue.

**Implementations:** `ArrayDeque`, `LinkedList`

---

### `Map<K, V>`
Not a true `Collection`, but part of the framework. Stores **key-value pairs** where keys are unique.

- Lookup, insert, and delete by key
- Values can be duplicates; keys cannot

**Implementations:** `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`

---

## Implementation Classes — At a Glance

| Class | Interface | Ordered | Sorted | Duplicates | Null | Thread-Safe |
|---|---|---|---|---|---|---|
| `ArrayList` | `List` | ✅ (insertion) | ❌ | ✅ | ✅ | ❌ |
| `LinkedList` | `List`, `Deque` | ✅ (insertion) | ❌ | ✅ | ✅ | ❌ |
| `Vector` | `List` | ✅ (insertion) | ❌ | ✅ | ✅ | ✅ |
| `Stack` | `List` | ✅ (LIFO) | ❌ | ✅ | ✅ | ✅ |
| `HashSet` | `Set` | ❌ | ❌ | ❌ | ✅ (one) | ❌ |
| `LinkedHashSet` | `Set` | ✅ (insertion) | ❌ | ❌ | ✅ (one) | ❌ |
| `TreeSet` | `Set` | ✅ (sorted) | ✅ | ❌ | ❌ | ❌ |
| `PriorityQueue` | `Queue` | ✅ (priority) | ✅ | ✅ | ❌ | ❌ |
| `ArrayDeque` | `Deque` | ✅ | ❌ | ✅ | ❌ | ❌ |
| `HashMap` | `Map` | ❌ | ❌ | Keys: ❌ | ✅ | ❌ |
| `LinkedHashMap` | `Map` | ✅ (insertion) | ❌ | Keys: ❌ | ✅ | ❌ |
| `TreeMap` | `Map` | ✅ (sorted) | ✅ | Keys: ❌ | ❌ | ❌ |

---

## The `Collections` Utility Class

`Collections` (note the **s**) is a utility class with static helper methods that operate on any collection.

```java
Collections.sort(list);                          // sort ascending
Collections.sort(list, (a, b) -> b - a);        // sort descending
Collections.reverse(list);                       // reverse order
Collections.shuffle(list);                       // random shuffle
Collections.min(list);                           // smallest element
Collections.max(list);                           // largest element
Collections.frequency(list, element);            // count occurrences
Collections.unmodifiableList(list);              // read-only view
Collections.synchronizedList(list);              // thread-safe wrapper
```

---

## Iterating Collections

### For-Each Loop
```java
for (Integer item : list) {
    System.out.println(item);
}
```

### Iterator
```java
Iterator<Integer> itr = list.iterator();
while (itr.hasNext()) {
    System.out.println(itr.next());
}
```
> Use `itr.remove()` to safely remove elements during traversal.

### ListIterator (List only)
```java
ListIterator<Integer> litr = list.listIterator();
while (litr.hasNext()) {
    System.out.println(litr.next());
}
```
> Supports **bidirectional** traversal and element replacement.

### Stream API (Java 8+)
```java
list.stream()
    .filter(x -> x > 10)
    .forEach(System.out::println);
```

---

## Generics and Type Safety

The Collection Framework uses **Generics** (`<E>`, `<K,V>`) to enforce compile-time type safety.

```java
ArrayList<String> names = new ArrayList<>();
names.add("Alice");
names.add(42); // ❌ Compile error — type mismatch
```

Without generics you'd get `ClassCastException` at runtime. Generics catch these errors early.

---

## Choosing the Right Collection

```
Need key-value pairs?
    └── Yes → Use a Map
            ├── Order matters?    → LinkedHashMap
            ├── Sorted by key?    → TreeMap
            └── Just fast lookup? → HashMap

Need a single group of elements?
    ├── Duplicates allowed?
    │       ├── Yes → Use a List
    │       │       ├── Fast random access?    → ArrayList  ✅
    │       │       └── Frequent insert/delete? → LinkedList
    │       └── No → Use a Set
    │               ├── Insertion order?  → LinkedHashSet
    │               ├── Sorted order?     → TreeSet
    │               └── Just uniqueness?  → HashSet
    └── FIFO / Priority processing? → Queue / PriorityQueue
```

---

## Detailed Guides

| Collection | Guide |
|---|---|
| ✅ **ArrayList** | [ArrayList — Full Guide](./ArrayList.md) |
| 🔜 LinkedList | *Coming soon* |
| 🔜 HashSet / TreeSet | *Coming soon* |
| 🔜 HashMap / TreeMap | *Coming soon* |
| 🔜 PriorityQueue | *Coming soon* |
| 🔜 ArrayDeque | *Coming soon* |

---

## Quick Cheat Sheet

```java
// List
List<Integer> list = new ArrayList<>();
list.add(1);           // add element
list.get(0);           // access by index
list.set(0, 99);       // update by index
list.remove(0);        // remove by index
list.size();           // number of elements
list.contains(1);      // check presence

// Set
Set<String> set = new HashSet<>();
set.add("apple");      // add (ignored if duplicate)
set.contains("apple"); // check presence
set.remove("apple");   // remove element

// Map
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);       // insert key-value
map.get("a");          // retrieve by key → 1
map.containsKey("a");  // check key exists
map.remove("a");       // remove by key
map.keySet();          // all keys
map.values();          // all values
map.entrySet();        // all key-value pairs
```

---

> This repository documents the Java Collection Framework through working code examples and detailed explanations. Each collection is covered with its own dedicated guide linked in the table above.