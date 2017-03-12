import inspect

class A(object):
    def test(self):
	    print 'test'

		
	

for attr_name, attr in inspect.getmembers(A):
	print str(attr_name)+"#"+ str(attr)