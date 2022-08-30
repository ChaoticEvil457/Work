import matplotlib.pyplot as plt
import numpy as numpy
z = [(input()) for x in range(10)]
v = numpy.array(z)
z = [(input()) for x in range(10)]
I = numpy.array(z)
plt.plot(I,v, 'ro') #uses matplotlib to plot voltage vs current
plt.ylabel('Voltage')
plt.xlabel('Current')
plt.title('title')
Text(0.5,1,'title')