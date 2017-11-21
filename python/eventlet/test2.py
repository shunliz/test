import eventlet

def handle(fd):
    print "client connected"
    while True:  
        # pass through every non-eof line  
        x = fd.readline()
        if not x: break
        fd.write(x)
        fd.flush()    
        print "echoed", x,
    print "client disconnected"


print "server socket listening on port 8000"   
server = eventlet.listen(('127.0.0.1', 8000)) 
pool = eventlet.GreenPool(200)    

while True:
        new_sock, address = server.accept() 
        print "accepted", address
        pool.spawn_n(handle, new_sock.makefile('rw')) 