class Hello {
    private val;
    constructor(value) {
    this.val=value;
    }
    private seter():void{
        this.val*=5;
    }
    public getName():string{
        return 'Durjoy Acharya';
    }
    public Value():number{
        return this.val;
    }
    public getAge():number{
        return 24;
    }
}
const obj=new Hello(5);
console.log(obj.getName());
console.log(obj.getAge());
console.log(obj.Value());