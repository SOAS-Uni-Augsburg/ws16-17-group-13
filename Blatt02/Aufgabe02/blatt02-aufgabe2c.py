
import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(0,1,100)[1:-2]
y = - (x * np.log2(x) + (1-x) * np.log2(1-x))

plt.plot(x,y)
plt.xlabel('h')
plt.ylabel('Hx')
plt.title('Entropy for h in (0,1)')
plt.show()
