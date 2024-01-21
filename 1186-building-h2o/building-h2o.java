class H2O {
    private int hydrogenCount = 0;
    private final Object lock = new Object();

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized(lock) {
            while (hydrogenCount == 2) { // Wait if two hydrogens are already released
                lock.wait();
            }
            releaseHydrogen.run();
            hydrogenCount++;
            if (hydrogenCount == 2) { // If two hydrogens are released, reset for oxygen
                lock.notifyAll();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(lock) {
            while (hydrogenCount != 2) { // Wait for two hydrogens to be released
                lock.wait();
            }
            releaseOxygen.run();
            hydrogenCount = 0; // Reset hydrogen count after oxygen is released
            lock.notifyAll(); // Notify all waiting threads
        }
    }
}