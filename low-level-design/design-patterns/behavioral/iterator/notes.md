# Iterator Pattern

> "Provide a way to access the elements of a collection sequentially without exposing its internal representation."

Used heavily in: Java Collections Framework, file system traversal, tree/graph traversal, pagination, streaming APIs (playlists, feeds, queues).

---

## Simple Explanation

You have a collection:

```
[10, 20, 30, 40]
```

You want to walk through it one by one:

```
10
20
30
40
```

…but the client should **not care** whether the data is stored as an array, linked list, tree, graph, stack, or queue.

The Iterator Pattern solves exactly this — **traverse a collection without knowing how it is implemented.**

You already use it every day:

```java
for (String name : names) {
    System.out.println(name);
}
```

Behind that `for-each` loop, Java is doing:

```java
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    String name = it.next();
}
```

---

## Real-World Analogy — TV Remote

You press **Next Channel**. You don't know how channels are stored — array, database, frequency map. The remote just gives you `next()`.

A Spotify playlist is the same: you only use `nextSong()`, `hasNext()`. How the playlist is stored internally is hidden from you.

That is the Iterator Pattern.

---

## Why Not Just Expose the Array?

Most beginners write:

```java
class BookShelf {
    Book[] books;
}

// client
shelf.books[0];
shelf.books[1];
```

Problems:
- the client now **knows the internal storage** is `Book[]`
- it knows the indexing and size-handling logic
- if you later switch to `List<Book>` or `LinkedList<Book>`, **client code breaks**
- storage logic and traversal logic are tangled together

The Iterator hides storage. The client only ever says *"give me the next item."*

---

## Structure

```
      +-------------------+
      | Aggregate         |   <- collection interface
      |-------------------|
      | createIterator()  |
      +-------------------+
               |
               v
      +-------------------+
      | Iterator          |   <- traversal interface
      |-------------------|
      | hasNext()         |
      | next()            |
      +-------------------+
               ^
               |
       ----------------------
       |                    |
+--------------+   +----------------+
| ArrayIterator|   | TreeIterator   |   <- concrete iterators
+--------------+   +----------------+
```

| Role | Job | Example |
|------|-----|---------|
| **Iterator** (interface) | declares `hasNext()`, `next()` | `SongIterator`, `BookIterator` |
| **Concrete Iterator** | actual traversal logic + cursor state | `PlaylistIterator`, `InorderIterator` |
| **Aggregate** (collection) | holds the items, exposes `createIterator()` | `Playlist`, `BookShelf`, `BinaryTree` |
| **Concrete Aggregate** | builds and returns the iterator | `playlist.createIterator()` |

---

## Refactor — From Bad to Good

**Step 1 — Iterator interface**

```java
interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

**Step 2 — Collection (Aggregate)**

```java
class BookShelf {
    private List<Book> books;

    public Iterator<Book> iterator() {
        return new BookIterator(books);
    }
}
```

**Step 3 — Concrete Iterator** (holds the cursor)

```java
class BookIterator implements Iterator<Book> {
    private List<Book> books;
    private int position = 0;

    public boolean hasNext() {
        return position < books.size();
    }

    public Book next() {
        return books.get(position++);
    }
}
```

**Client** — identical loop no matter what the collection is:

```java
Iterator<Book> it = shelf.iterator();
while (it.hasNext()) {
    Book book = it.next();
}
```

---

## The Core Insight

The Iterator **separates two responsibilities**:

```
Collection  ->  holds the data        (storage logic)
Iterator    ->  moves through data     (traversal logic)
```

This is the **Single Responsibility Principle** in action. The collection can change its internal structure freely, and as long as it still hands out an iterator, **no client code changes.**

The biggest payoff shows up across the practice problems below: a list, a reversed list, a filtered stream, a 2-D nested list, and a binary tree **all drive the same client loop** — `while (hasNext()) next()`. Only the iterator's internals differ.

---

## Two Implementation Styles

Both are valid; you'll see both in the practice problems.

**1. Separate concrete iterator class** (constructor receives the data)
```java
class PlaylistIterator implements SongIterator {
    PlaylistIterator(List<Song> songs) { ... }
}
```
Used in: `music-playlist`.

**2. Private inner iterator class** (reads the outer collection directly)
```java
class BookShelf {
    private class ShelfIterator implements BookIterator { ... }
}
```
Better **encapsulation** — the iterator is an implementation detail nobody else can construct, and as a non-static inner class it accesses the outer collection's fields for free. Used in: `book-shelf`, `student-list`, `reverse-iterator`, `tree-iterator`.

---

## Iterator vs for-loop

| | for-loop | Iterator |
|---|----------|----------|
| Who controls traversal | **client** (`for i = 0; i < n; i++`) | the **iterator** |
| Client knows indexing? | yes | no |
| Works on non-indexed structures (tree/graph)? | awkward | natural |
| Coupling to storage | tight | loose |

Java's `for-each` is *built on* the Iterator — that's why it works on `List`, `Set`, `Map`, etc. uniformly.

---

## Advantages

- **Encapsulation** — client never sees internal structure.
- **Loose coupling** — collection internals can change without breaking clients.
- **Multiple traversal strategies** — one collection can offer forward, reverse, filtered, DFS, BFS iterators.
- **Cleaner client code** — same readable `while (hasNext())` loop everywhere.

## Tradeoffs

- **More classes** — every traversal needs an iterator class.
- **Overengineering risk** — for a tiny, fixed array it may be unnecessary.
- **Concurrent modification** — mutating a collection while iterating is dangerous. In Java this throws `ConcurrentModificationException`.

---

## Interview Q&A

**Q: Why not just use a loop?**
Because the iterator hides the collection's internals and decouples traversal from storage. A loop forces the client to know the indexing scheme.

**Q: Can one collection have multiple iterators?**
Yes — `ForwardIterator`, `ReverseIterator`, `EvenNumberIterator`, `InorderIterator`, `BFSIterator`. Same data, different traversal.

**Q: Why does Java's for-each work?**
Because internally it calls `iterator()` and loops on `hasNext()` / `next()`. Any class implementing `Iterable` gets for-each for free.

---

## Practice Problems

| Problem | Folder | Traversal idea |
|---------|--------|----------------|
| Music Playlist | `music-playlist` | flat list, separate iterator class |
| Book Shelf | `book-shelf` | flat list, private inner iterator |
| Student List | `student-list` | flat list, inner iterator |
| Reverse Iterator | `reverse-iterator` | walk backward (`5 4 3 2 1`) |
| Even Number Iterator | `even-number-iterator` | filtering — skip odds, emit `2 4` |
| Tree Iterator | `tree-iterator` | inorder traversal via explicit stack |
| Nested List Iterator | `nested-list-iterator` | flatten `[[1,2],[3,4],[5]]` → `1 2 3 4 5` (two cursors) |

**Progression:** flat list → reverse → filtered → 2-D nested → binary tree → N-ary tree (file system). The traversal complexity grows, but the client loop never changes.

**Key techniques across them:**
- *Cursor* (`int position`) — for flat/indexed structures.
- *Two cursors* (`outer`, `inner`) — for fixed-depth nesting.
- *Explicit stack* — for trees and arbitrary-depth structures (simulates recursion lazily, O(height) memory).
- *Lazy filtering in `hasNext()`* — advance past unwanted elements so `next()` always returns a valid one.

---

## One-Line Definition

> The Iterator Pattern provides a way to traverse a collection sequentially without exposing how the collection is stored internally.

**Formula:** `Collection + Iterator = Flexible Traversal`

**Use when:** you need sequential traversal · want to hide internal structure · need multiple traversal strategies · want cleaner client code.
