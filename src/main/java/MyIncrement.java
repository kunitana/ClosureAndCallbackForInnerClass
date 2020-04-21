public class MyIncrement {
    public void increment(){ System.out.println("Other operation");}
    public static void f(MyIncrement mi){mi.increment();}
}
