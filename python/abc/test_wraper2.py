def decorate_B(function):
    def wrap_function(*args, **kwargs):
        str = 'Hello!'
        return function(str, *args, **kwargs)
    return wrap_function
@decorate_B
def print_message_B(str, *args, **kwargs):
    print str
print_message_B('test')