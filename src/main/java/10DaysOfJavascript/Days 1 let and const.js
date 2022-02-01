/**
 * In this challenge, we practice
 * declaring variables using the let and
 * const keywords. Check out the attached tutorial for more details.
 */
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function main() {

    try {
        let radio = readLine();
        const PI = Math.PI;
        console.log(PI*radio*radio);
        console.log(PI*2*radio);
    } catch(error) {
        console.error("You correctly declared 'PI' as a constant.");
    }
}