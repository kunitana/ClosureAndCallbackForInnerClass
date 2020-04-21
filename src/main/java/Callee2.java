public class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    //Inner class
    private class Closure implements Incrementable{
        public void increment() {
       //used external class method, otherwise there will be recursion
        Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference(){
        return new Closure();
    }
}
