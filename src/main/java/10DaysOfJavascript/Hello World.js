var Hello = /** @class */ (function () {
    function Hello(value) {
        this.val = value;
    }
    Hello.prototype.seter = function () {
        this.val *= 5;
    };
    Hello.prototype.getName = function () {
        return 'Durjoy Acharya';
    };
    Hello.prototype.Value = function () {
        return this.val;
    };
    Hello.prototype.getAge = function () {
        return 24;
    };
    return Hello;
}());
var obj = new Hello(5);
console.log(obj.getName());
console.log(obj.getAge());
console.log(obj.Value());
