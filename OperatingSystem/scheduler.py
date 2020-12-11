from matplotlib import pyplot as plt 
from matplotlib import style
import math
import random
style.use("fivethirtyeight")

numSimulations = 10000
numProcesses = 10
minBurstTime = 2
maxBurstTime = 10
maxArrivalsPerTick = 2
probArrival = 0.75
timeQuantum = 2
preemptionOptions = [False, True]

pwait, npwait = [], []
pexec, npexec = [], []



def getArrivalTime(exp):
	p = [1,1,0,1]
	r = random.randint(0,3)
	if p[r]:
		return exp
	return -1

def runSimulation(p,timeQuantum,numProcesses,minBurstTime,maxBurstTime,maxArrivalsPerTick,probArrival):
	processQueue = []
	pId, arTime = 1,0
	while True:
		arrivalTime = getArrivalTime(arTime)
		burstTime = random.randint( minBurstTime,maxBurstTime) 
		if arrivalTime == -1:
			arTime += 1
			continue
		else:
			processQueue.append( [pId,burstTime,arrivalTime,0,0] )

		if len(processQueue) == numProcesses:
			break
		pId += 1
		arTime += 1

	# print(" PID \t   ArrivalTime \t   BurstTime \t TotalWaitingTime \t TotalAllocatedCpuTime ")
	
	if not p:
		time, sumTime = 0, 0
		while True:
			randomProcess = random.randint( 0,len(processQueue)-1 )
			p = processQueue[randomProcess]
			if time >= p[2]:
				p[3] += time
				sumTime += time
				time += p[1]
				p[4]=p[1]
				p[1]=0
				processQueue.pop(randomProcess)
				if len(processQueue)==0:
					break
			else:
				time+=1
				continue
		avgWaitingTime = sumTime//numProcesses
		completeExecTime = time
		# print(avgWaitingTime,completeExecTime)
		# print()
		npwait.append(avgWaitingTime)
		npexec.append(completeExecTime)

	else:
		time, sumTime = 0, 0
		while True:
			randomProcess = random.randint( 0,len(processQueue)-1 )
			p = processQueue[randomProcess]
			if time >= p[2]:
				p[3] += time
				sumTime += time
				time += timeQuantum
				p[4] += timeQuantum
				p[1] -= timeQuantum
				if p[1]<=0:
					p[1]=0
					processQueue.pop(randomProcess)
				else:
					processQueue.pop(randomProcess)
					processQueue.append(p)
				
				if len(processQueue)==0:
					break
			else:
				time+=1
				continue
		avgWaitingTime = sumTime//numProcesses
		completeExecTime = time
		# print(avgWaitingTime,completeExecTime)
		# print()
		pwait.append(avgWaitingTime)
		pexec.append(completeExecTime)




for p in preemptionOptions:
	for i in range(numSimulations):
		runSimulation(p,timeQuantum,numProcesses,minBurstTime,maxBurstTime,maxArrivalsPerTick,probArrival)

sim =  [ i+1 for i in range(numSimulations) ]

plt.plot( sim, npexec, label="Non-Premptive")
plt.plot( sim, pexec, label="Premptive" )
plt.xlabel("Simulation")
plt.ylabel(" Total Execution Time ")
plt.legend()
plt.title("Total Execution Time Plot")
plt.show()

plt.clf();

plt.plot( sim, npwait, label="Non-Premptive" )
plt.plot( sim, pwait, label="Premptive" )
plt.xlabel("Simulation")
plt.ylabel(" Average Waiting Time ")
plt.legend()
plt.title("Average Waiting Time Plot")
plt.show()
