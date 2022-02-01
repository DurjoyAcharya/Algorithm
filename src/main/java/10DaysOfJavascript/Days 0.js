/**
 * This series focuses on learning and practicing JavaScript.
 * Each challenge comes with a tutorial article, and you can view these articles
 * by clicking either the Topics tab along the top or the article icon in the right-hand menu.
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
function greeting(parameterVariable) {
    console.log('Hello, World!');
    console.log(parameterVariable);

}

function main() {
    const parameterVariable = readLine();
    greeting(parameterVariable);
}
main();