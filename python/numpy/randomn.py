import numpy as np

sizes = [784, 30 , 10]
biases = [np.random.randn(y, 1) for y in sizes[1:]]
print sizes[1:]
print np.random.randn(10, 1)
print biases 