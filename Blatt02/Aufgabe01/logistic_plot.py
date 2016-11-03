
import matplotlib.pyplot as plt
import numpy as np

R = np.linspace(0, 4, 400)
 

def logistic( y ):
    return R*y*(1-y)
   
   
def run_logistic(runs, y0):
    ycurrent = logistic(y0)
    ynew = logistic(ycurrent)
     
    for i in range (1, runs):
        ycurrent = ynew
        ynew = logistic(ynew)
    
    return ynew
    

#y0 = 0.5
#colors = ('cyan', 'red', 'yellow')
#for color in colors:
#    y0 += 0.1 
#    for i in range(0,7):
#        plt.scatter(R, run_logistic(5*10**5 + i), marker=',', color = color, alpha=0.4, s=2, lw=0) 

y0 = 0.2
for i in range(0,20):
    plt.scatter(R, run_logistic(10**5 + i, y0), marker=',', color = 'blue', alpha=0.4, s=1, lw=0) 
    
x=[3,3]
y=[0,1]
 
plt.plot(x,y, 'r--')
plt.xlabel('R')
plt.ylabel('f_y')
#plt.title('Bifurcationdiagram for y0=0.5')
plt.show()