class Province:
    # 静态字段
    country = '中国'
    def __init__(self,name):
        # 普通字段
        self.name = name
# 直接访问普通字段
obj = Province('北京')
print obj.name

# 直接访问静态字段
print Province.country



class Foo:
    # 初始化类
    def __init__(self):
        pass
    # 定义普通方法，至少有一个self参数
    def p(self):
        print '普通方法'
    # 定义类方法，至少有一个cls参数
    @classmethod
    def q(cls):
        print '类方法'
    # 定义静态方法
    @staticmethod
    def w():
        print '静态方法'
# 调用普通方法
a = Foo()
ret = a.p()
# print ret
# 调用类方法
Foo.q()
# 调用静态方法
Foo.w()


class Goods(object):
    def __init__(self):
        # 原价
        self.original_price = 100
        # 折扣
        self.discount = 0.8
 
    @property
    def price(self):
        # 实际价格 = 原价 * 折扣
        new_price = self.original_price * self.discount
        return new_price
 
    @price.setter
    def price(self,value):
        # 设置原始价格
        self.original_price = value
    @price.deleter
    def price(self,value):
        # 删除原始价格
        del self.original_price
# 调用
obj = Goods()
# 获取商品价格
obj.price
# 设置原始价格
obj.price = 3000
# 删除原始价格
del obj.price



class C:
    name = '公有静态字段'
    def func(self):
        print C.name
class D(C):
    def func_1(self):
        print C.name
# 直接使用类访问
C.name
# 类内部访问
obj = C()
obj.func()
# 派生类内部访问
obj_1 = D()
obj_1.func_1()


class C:
    __name = '公有静态字段'
    def func(self):
        print C.__name
class D(C):
    def func_1(self):
        print C.__name
# 类中访问
# C.__name    # 错误
# 类内部访问
obj = C()
obj.func()



class C:
    def __init__(self):
        self.foo = '公有字段'
    def func(self):
        # 在类内部调用访问
        print self.foo
class D(C):
    def show(self):
        # 在派生类中调用访问
        print self.foo
obj = C()
# 通过对象访问
print type(obj.foo)
print  obj.foo
print '==========='
# 类的内部访问
obj.func()
print '==========='
obj_1 = D()
# 在派生类中访问
obj_1.show()


class C:
    def __init__(self):
        self.__foo = '私有普通字段'
    def func(self):
        # 类的内部调用访问
        print self.__foo
class D(C):
    def show(self):
        # 在派生类中调用访问
        print self.__foo
obj = C()
# obj.__foo      # 通过对象访问：报错
obj.func()       # 通过类内部访问
 
obj_1 = D()
#obj_1.show()    # 通过派生类调用访问： 报错



# 新式类
class D(object):
# 经典类
#class D:
    def bar(self):
        print 'D.bar'
class C(D):
    def bar(self):
        print 'C.bar'
class B(D):
    pass
class A(B,C):
    pass
a = A()
a.bar()
 
'''
经典类：深度优先  D.bar
新式类：广度优先  C.bar
'''



class F1:
    pass
class S1(F1):
    def show(self):
        print 'S1.show'
class S2(F1):
    def show(self):
        print 'S2.show'
 
def Func(obj):
    print obj.show()
 
s1_obj = S1()
Func(s1_obj)
 
s2_obj = S2()
Func(s2_obj)





