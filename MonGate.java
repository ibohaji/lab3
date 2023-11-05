//Monitor implementation of Gate (skeleton)
//CP Lab 3
//Course 02158 Concurrent Programming, DTU

//Hans Henrik Lovengreen


public class MonGate extends Gate {
    private boolean isOpen = false;

    public synchronized void pass() throws InterruptedException {

        while (!isOpen) {
            wait();
        }
    }

    //Signal and continue

    public synchronized void open() {
        isOpen=true;
        notifyAll();

        }

    public synchronized void close() {
        isOpen = false;
        notifyAll();
       }
    }


