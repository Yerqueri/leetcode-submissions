class FooBar {
    private int n;
    private volatile int x =0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while((x&1)==1){
                    wait();
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                x++;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while((x&1)==0){
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                x++;
                notify();
            }
        }
    }
}