var fs = require('fs');
var readline = require('readline');
var path = require('path');

var fileContents = fs.readFileSync('./Inputs/2024-12-01.txt').toString()

console.log(fileContents)

var nums = fileContents.split("\n")
console.log(nums)

var left = []
var right = []

nums.forEach(pair => {
    var temp = pair.split(" ")
    left.push(temp[0])
    right.push(temp[temp.length - 1])
});

var sortedLeft = left.sort((a, b) => a - b)
var sortedRight = right.sort((a, b) => a - b)

console.log(sortedLeft)
console.log(sortedRight)

var dist = 0;
for(var i = 0; i<sortedLeft.length;i++) {
    dist+=Math.abs(sortedLeft[i]-sortedRight[i])
}
console.log(dist)

var rightMap = new Map()
sortedRight.forEach(number => {
    if(!rightMap.has(number)) {
        rightMap.set(number, 1)
    } else {
        rightMap.set(number, rightMap.get(number)+1)
    }
});

var similarity = 0

sortedLeft.forEach(val => {
    if (rightMap.has(val)) {
        similarity += (val * rightMap.get(val))
    }
});

console.log(similarity)