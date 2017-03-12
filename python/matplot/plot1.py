import numpy as np
import matplotlib.pyplot as plt

X = np.linspace(-np.pi, np.pi, 256, endpoint=True)
C,S, W = np.cos(X), np.sin(X), np.exp(np.sin(X))

plt.plot(X,C)
plt.plot(X,S)
plt.plot(X,W)

plt.show()