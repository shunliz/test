import numpy as np
import matplotlib.pyplot as plt

u =np.random.uniform(0.0, 1.0, 10000)
plt.hist(u, 40, facecolor='g', alpha=0.75)
plt.grid(True)
plt.show()

v = [0,0,1,2,3,4,5]

plt.hist(v, 4, facecolor='g', alpha=0.25)
plt.grid(True)
plt.show()
