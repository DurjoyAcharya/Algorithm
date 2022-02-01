//Factorial in dynamic programming approche
function Factorial(value:number):number {
    let array:number[] = [];
    if (value>=0)
    {
        array[0]=1;
        for (let i = 1; i <=value; i++)
            array[i]=i*array[i-1];
        return array[value];
    }
}
let result=Factorial(4);
console.log(result);