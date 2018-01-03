'use strict';

const isPerf = number => (!( Math.pow(number, 0.5)%1));

const isPerfect = numbs => {
  if(numbs.length < 2) {
    return 0;
  }
  let starting =  numbs[0];
  let ending =  numbs[1];
  var totalCount= 0;
  for(let i = starting+1; i < ending; i++){
    if (isPerf(i)) {
      totalCount++;
    }
  }
  console.log('this many perfects: ', totalCount);
  return totalCount;
}



isPerfect([1, 10])
