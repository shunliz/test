class Test(object):

    def __init__(self):
        print 'in init'

    def __new__(cls):
        print 'in new'
        return object.__new__(cls)

    def __exit__(self):
        print 'in exit'

    def echo(self):
        print 'echo what?'

test = Test()
test.echo()

