//Implementation of Alley class with inner alley (skeleton)
//CP Lab 3
//Course 02158 Concurrent Programming, DTU

//Hans Henrik Lovengreen

public class DoubleAlley extends Alley {
   private static int inner; // both up and downs 1 and 2 should wait for
   private static int up; // cars
   private static int down; //

    DoubleAlley() {
        inner = 0;
        up = 0;
        down =0;
    }

    @Override
    /* Block until car no. may enter alley */
    public synchronized void enter(int no) throws InterruptedException {


        if(no<3){
            while(inner>0){
                wait();
            }
            down++;
        }
         else if(no<5){
            while(up>0 ){
                wait();
            }
            down++;
        }

        if(no>=5){
            while(down>0){
                wait();
            }
            up++;
            inner++;

        }
    }

    @Override
    /* Register that car no. has left the alley */
    public synchronized void leave(int no) {
        if(no<5){
            down--;
            if(down==0){
                notifyAll();
            }

    }
        else{
            up--;
            if(up==0){
                notifyAll();
            }
        }
    }
    
    @Override
    /* Register that car no. has left the inner alley */
    public synchronized void leaveInner(int no) {
        if(no>=5){
            inner--;
            if(inner==0)
            {
                notifyAll();
            }
        }

    }

}
