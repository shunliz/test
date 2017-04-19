class Parent(object):
    def printp(self):
	    raise NotImplementedError()

	def output(self):
	    self.printp()


class Child(Parent):
    def printp(self):
	    print 'Child'

c = Child()
c.output()