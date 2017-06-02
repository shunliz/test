class TestObject(object):
    def __init__(self):
        self.v = self.add()
       
    def add(self):
	    print 'return 1'
        return 1

test = TestObject()
