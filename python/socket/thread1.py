import threading
import time 
    
class MyThread(threading.Thread): 
    def __init__(self, signal): 
        threading.Thread.__init__(self)
        # inital
        self.singal = signal 
            
    def run(self): 
        print "I am %s,I will sleep ..."%self.name 
        # waiting
        self.singal.wait() 
        print "I am %s, I awake..." %self.name 
            
if __name__ == "__main__":
    # init to False
    singal = threading.Event() 
    for t in range(0, 3): 
        thread = MyThread(singal) 
        thread.start() 
        
    print "main thread sleep 3 seconds... " 
    time.sleep(3) 
    #wake up signal waiting others
    singal.set()

