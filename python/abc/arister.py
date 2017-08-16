######################################################################
#              in function definition                                #
######################################################################

# It packs the passed arguments into tuple when used in function definition.
def my_sum(*args):
    res = 0
    for num in args:
        res = res + num
    return res


def sample(*args):
    print type(args)
    print args
sample("hello", "python", "posts")
#output:
# <type 'tuple'>
# ('hello', 'python', 'posts')

##########################################################

## double asterisk
# packs the passed argument into dictionary when used in function definition.

def sample(*args, **kargs):
    print type(args)
    print args
    print type(kargs)
    print kargs
sample("hello", "python", "posts", name="* and ** in python", author="Alok")
#output£º
#<type 'tuple'>
#('hello', 'python', 'posts')
#<type 'dict'>
#{'name': '* and ** in python', 'author': 'Alok'}


############################################################
#                   Use in function call                   #
############################################################

# single asterisk
#When * is used in function call, it unpacks tuple or list into positional arguments

def sample(a, b, c):
    print a, b, c
 
tp = ("Hello", "Python", "Learner")
sample(*tp)
# output:
# Hello Python Learner

## double astersik
## When ** is used in function call, it unpacks dictionary into named arguments
def sample(name="Sample Python Post", type="Post", Date=""):
	print name, type, Date
 
d = {'type':"New Post", 'name':"* and ** in python", 'Date':""}
sample(**d)

#output:
# * and ** in python New Post


##########################################################
#         in python 3.5                                  #
##########################################################

# asterisk and double asterisk can be used within list, tuple, set and dictionary, * will unpack list/tuple and # ** will unpack dictionary.

list1 = [1,2,3]
#list1 can be unpacked into another list/tuple as below
list2 = [*list1, 4, 5, 6]
list2
# output:
# [1, 2, 3, 4, 5, 6]


#We have two dictionary 
d1 = {'a':1, 'b':2, 'c':3}
d2 = {'x':1, 'y':2, 'z':3}
 
# Lets merge d1 and d2 and create another dictionary by using **
d3 = {**d1, **d2}
d3
# outpu:
# {'z': 3, 'a': 1, 'x': 1, 'c': 3, 'b': 2, 'y': 2}

