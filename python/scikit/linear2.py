from sklearn import datasets
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt


boston = datasets.load_boston()
lr = LinearRegression()
lr.fit(boston.data, boston.target)
predictions = lr.predict(boston.data)
print lr.coef_

print zip(boston.feature_names, lr.coef_)