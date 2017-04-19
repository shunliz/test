from abc import ABCMeta, abstractmethod


class Drawable():

    __metaclass__ = ABCMeta
           
    @abstractmethod
    def draw(self, x, y, scale=1.0):
        pass
    
    
    def draw_doubled(self, x, y):
        self.draw(x, y, scale=2.0)


class Square(Drawable):

    def draw(self, x, y, scale):
	    print 'draw square'

s = Square()
s.draw(1,1,2)
s.draw_doubled(1,1)