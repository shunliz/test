import eventlet  
from eventlet.green import urllib2  
  
  
urls = [  
    "http://www.baidu.com",  
    "http://www.tencent.com",  
    "http://www.sina.com",  
]  
  
  
def fetch(url):  
    return urllib2.urlopen(url).read()  
  

pool = eventlet.GreenPool(200) 
  
for body in pool.imap(fetch, urls): 
    print("got body", len(body))  