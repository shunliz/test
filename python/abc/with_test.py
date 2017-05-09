class Claim(object):
    def __enter__(self):
        print 'enter claim'

    def __exit__(self, exc_type, exc_val, exc_tb):
        print 'in exit claim'
        if exc_type is not None:
            print 'exception caught'

def instance_claim():
    
    return Claim()

def test_with():
    with instance_claim():
        print 'in the with'

def test_with2():
    with instance_claim():
        print 'in the with'
        raise Exception('error ocurred')

test_with()
print '#################################'
test_with2()