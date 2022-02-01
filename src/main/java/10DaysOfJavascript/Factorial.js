//Factorial in dynamic programming approche
function Factorial(value) {
    var array = [];
    if (value >= 0) {
        array[0] = 1;
        for (var i = 1; i <= value; i++)
            array[i] = i * array[i - 1];
        return array[value];
    }
}
var result = Factorial(4);
console.log(result);
