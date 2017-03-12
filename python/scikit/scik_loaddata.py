from sklearn import datasets as d
import numpy as np
from sklearn import preprocessing

boston = d.load_boston()
print boston.DESCR

complex_reg_data = d.make_regression(1000, 10, 5, 2, 1.0)
print complex_reg_data[0].shape

classification_set = d.make_classification(weights=[0.1])
print np.bincount(classification_set[1])

n_samples=1000
n_features = 10
n_target=5
n_informative=2
bias=np.random.rand(n_samples, n_target)
X = np.random.randn(n_samples, n_features)
ground_truth = np.zeros((n_features, n_target))
ground_truth[:n_informative, :] = 100*np.random.rand(n_informative,n_target)

print '#######################'
print X.shape
print X
print '#######################'
print ground_truth.shape
print ground_truth
print '#######################'

y = np.dot(X, ground_truth) + bias
print '#######################'
print X
print '#######################'
print y
print '#######################'

print X[:, :3].mean(axis=0) #mean of the first 3 features
print '#######################'
print X[:, :3].std(axis=0)
print '#######################'




