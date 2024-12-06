import * as fs from 'fs';

const words = fs.readFileSync('./input.txt', 'utf-8');

var splitInput = words.split("\n");

var readAllRules = false;
var middles = 0;
var badMiddles = 0;
var hmm = 0;
var rules: String[][] = [];
splitInput.forEach(element => {
    if (element == "") {
        readAllRules = true;
    } else if (!readAllRules) {
        var pair: String[] = [""];
        pair = element.split("|");
        rules.push(pair);
    } else {
        var order = element.split(",");
        var end = order.length - 1;
        var mid = end / 2;
        var sorted = true;
        for (var i = end; i >= 0; i--) {
            for (var j = 0; j < i; j++) {
                for(var k = 0; k < rules.length; k++) {
                    if(rules[k][0] == order[i] && rules[k][1] == order[j]) {
                        sorted = false;
                    }
                }
            }
        }
        if (sorted) {
            middles += +order[mid];
        } else {
            var order = element.split(",");
            var end = order.length - 1;
            var mid = end / 2;
            for (var i = end; i >= 0; i--) {
                for (var j = 0; j < i; j++) {
                    for(var k = 0; k < rules.length; k++) {
                        if(rules[k][0] == order[i] && rules[k][1] == order[j]) {
                            var temp = order[i];
                            order[i] = order[j];
                            order[j] = temp;
                        }
                    }
                }
            }
            
            badMiddles += +order[mid];
        }
    }
});

console.log(middles);
console.log(badMiddles);
console.log(hmm);
