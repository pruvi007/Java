from matplotlib import pyplot as plt
from matplotlib import style

style.use("fivethirtyeight")

sim =  [ 1,2,3,4,5 ]


nonExec = [ 66, 56, 62, 51, 62 ]
Exec = [ 62,69,68,78,77 ]

nonWait = [ 32, 24, 30, 23, 30 ]
Wait = [  92,113,110,147,143 ]  


plt.plot( sim, nonExec, label="Non-Premptive",marker='o',markersize=12 )
plt.plot( sim, Exec, label="Premptive",marker='o',markersize=12 )
plt.xlabel("Simulation")
plt.ylabel(" Total Execution Time ")
plt.legend()
plt.title("Total Execution Time Plot")
plt.show()

plt.clf();

plt.plot( sim, nonWait, label="Non-Premptive",marker='o',markersize=12 )
plt.plot( sim, Wait, label="Premptive",marker='o',markersize=12 )
plt.xlabel("Simulation")
plt.ylabel(" Average Waiting Time ")
plt.legend()
plt.title("Average Waiting Time Plot")
plt.show()
