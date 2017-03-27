class AttributeDict(object):
	"""
	A class to convert a nested Dictionary into an object with key-values
	accessibly using attribute notation (AttributeDict.attribute) instead of
	key notation (Dict["key"]). This class recursively sets Dicts to objects,
	allowing you to recurse down nested dicts (like: AttributeDict.attr.attr)
	"""
	def __init__(self, **entries):
		self.add_entries(**entries)

	def add_entries(self, **entries):
		for key, value in entries.items():
			if type(value) is dict:
				self.__dict__[key] = AttributeDict(**value)
			else:
				self.__dict__[key] = value

	def __getitem__(self, key):
		"""
		Provides dict-style access to attributes
		"""
		return getattr(self, key)

	def get(self, key):
	    return getattr(self, key)

import yaml
y = yaml.load(open('D:\\code\\shunliz\\test\\python\\abc\\test.yaml', 'r'))
print y
print type(y)
myobj = AttributeDict(**y)
print myobj.test

y2 = {'test1':'test1',
      'test2': {'test22':'test22'}}

myobj2 = AttributeDict(**y2)
print myobj2.test2
print myobj2['test2']
myobj2.testattr = 'tesok?'
print myobj2['testattr']
print myobj2.get('testattr')