class BoundedBlockingQueue {

    private final Queue<Integer> q;
    private final int capacity;
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    public BoundedBlockingQueue(int capacity) {
        this.q = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (q.size() == capacity) {
                notFull.await();
            }
            q.offer(element);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (q.isEmpty()) {
                notEmpty.await();
            }
            int result = q.poll();
            notFull.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return q.size();
        } finally {
            lock.unlock();
        }
    }
}