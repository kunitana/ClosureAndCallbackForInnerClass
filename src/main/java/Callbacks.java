/*
This is the example from the book of Bruce Eckel "Thinking in Java", which illustrated Closure and Callback process with inner classes.
 */

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();

        MyIncrement.f(c2); //here c2 is initialized with parent mtd increment + mtd increment Callee2 (result: other operation, (c2.i) 1)

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go(); // caller1 is initialized with c1 = 0 and call c1.increment(result (c1.i) 1)
        caller1.go(); // caller1 call c1.increment one more time (result (c2.i) 2)
        caller2.go(); // caller2 call Callee2.newClosure.increment => Callee2.this.increment => super.implement (result: Other operation) => c2.1++ (result 2)
        caller2.go(); // caller2 call Callee2.newClosure.increment => Callee2.this.increment => super.implement (result: Other operation) => c2.1++ (result 3)
    }
}
