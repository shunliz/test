class SqlHelper:
    __static_instance = None
 
    def __init__(self):
        self.hostname = '0.0.0.0'
        self.port = 3306
 
    @classmethod
    def instance(cls):
        if cls.__static_instance:
            return cls.__static_instance
        else:
            cls.__static_instance = SqlHelper()
            return cls.__static_instance
 
 
 
obj1 = SqlHelper.instance()
print id(obj1)
obj2 = SqlHelper.instance()
print id(obj2)