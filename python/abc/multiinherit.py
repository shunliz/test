class A(object):
    def func(self):
	    print 'A func'
		
class B(object):
    def func(self):
	    print 'B func'
		
class C(object):
    def func1(self):
	    print 'C func1'
		
class D(B, A, C):
    def func(self):
	    super(D, self).func()

d = D()
d.func()