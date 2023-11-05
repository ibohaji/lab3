//Basic implementation of Alley class (skeleton)
//CP Lab 3
//Course 02158 Concurrent Programming, DTU

//Hans Henrik Lovengreen

public class BasicAlley extends Alley {
   private static boolean cond;
   private static int up;
   private static int down;
    BasicAlley() {
        cond = true;
    }

    @Override
    /* Block until car no. may enter alley */
    public synchronized void enter(int no) throws InterruptedException {
        {
            try{
                if(no<5){
                    while(up>0){
                        wait();
                    }
                    down+=1;
                }

                else{
                    while(down>0){
                        wait();
                    }
                    up+=1;
                }




            }catch(Exception e){
            }
        }

    }

    @Override
    /* Register that car no. has left the alley */
    public synchronized void leave(int no) {
        {
            if(no<5){
                down--;
                if(down==0){
                    notifyAll();
                }
            }else{
                up--;
                if(up==0){
                    notifyAll();
                }
            }
        }
    }
    
 
}
