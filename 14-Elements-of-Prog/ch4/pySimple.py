import math

def isPerfect(numb):
  return (math.pow(numb, 0.5)%1 == 0)


def printPerfects(arr):
  if (len(arr) < 2):
    return 0;
  start = arr[0];
  end = arr[1];
  container = [];
  for x in range(start,end):
    if(isPerfect(x)):
      container.append(x)
  return container

print( len(printPerfects([1, 500])) )