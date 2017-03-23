import commands

from functools import wraps

def somedec(somearg, someopt=None):
    def somedec_outer(fn):
        @wraps(fn)
        def somedec_inner(*args, **kwargs):
            # do stuff with somearg, someopt, args and kwargs
            try:
                return fn(*args, **kwargs)
            except Exception as e:
                raise Exception('wrapped exception'+somearg)
        return somedec_inner
    return somedec_outer

def wrap_exception(f, param):
    """This decorator wraps a method to catch any exceptions that may
    get thrown."""
    def wrapped(*args, **kw):
        # Don't store self or context in the payload, it now seems to
        # contain confidential information.
        try:
            return f(*args, **kw)
        except Exception as e:
            raise Exception('wrapped exception'+param)

    return wrapped


@somedec('test')
def exec_cmd():
    (status, output) = commands.getstatusoutput('ls /proc/cpuinfo')
    raise Exception('mock exception')
    return (status, output)

data = exec_cmd()
print data