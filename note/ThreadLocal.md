# ThreadLocal

存储的值只能被特定线程访问

## 实现原理

**实现1 - 使用Map存储对应关系**
使用一个Map进行实现如ConcurrentHashMap<Thread,T>使用当前线程Thread.currentThread()作为Key。这种实现会合理工作，但会有一些缺点：
- 线程竞争 - ConcurrentHashMap虽然是一个很好的类但它最终还是要处理防止多个线程
- 永久保存了Thread与Object，即使线程已经结束和可能被GC

**实现2 - 对GC友好的实现**
使用弱引用
Collections.synchronizedMap(new WeakHashMap<Thread, T>())
或Guava new MapMaker().weakKeys().makeMap()

如果线程结束后有对象Hold这个线程GC操作就不会进行

**最佳实现**

>We've been thinking about ThreadLocal as a mapping of threads to values, but maybe that's not actually the right way to think about it. Instead of thinking of it as a mapping from Threads to values in each ThreadLocal object, what if we thought about it as a mapping of ThreadLocal objects to values in each Thread? If each thread stores the mapping, and ThreadLocal merely provides a nice interface into that mapping, we can avoid all of the issues of the previous implementations





## 总结
- ThreadLocal 适用于变量在线程间隔离且在方法间共享的场景
- ThreadLocal 并不解决线程间共享数据的问题
- ThreadLocal 通过隐式的在不同线程内创建独立实例副本避免了实例线程安全的问题
- ThreadLocalMap 的 Entry 对 ThreadLocal 的引用为弱引用，避免了 ThreadLocal 对象无法被回收的问题
- ThreadLocalMap 的 set 方法通过调用 replaceStaleEntry 方法回收键为 null 的 Entry 对象的值（即为具体实例）以及 Entry 对象本身从而防止内存泄漏
- ThreadLocalMap 的 Entry 对 ThreadLocal 的引用为弱引用，避免了 ThreadLocal 对象无法被回收的问题
- 不要在ExecutorService中使用ThreadLocal
