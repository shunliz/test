class A(object):
    def __init__(self):
        self.str='astr'
        print 'init A'

    def printf(self):
        print self.str

    def __enter__(self):
        print 'enter A'

    def __exit__(self, exc_type, exc_val, exc_tb):
        print 'exit A'

class B(object):
    def __init__(self):
        self.str = 'bstr'
        print 'init B'

    def printf(self):
        print self.str

    def __enter__(self):
        print 'enter B'

    def __exit__(self, exc_type, exc_val, exc_tb):
        print 'exit B'

with A() as a, B() as b:
   print 'in with'
