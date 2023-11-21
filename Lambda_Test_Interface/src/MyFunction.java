public interface MyFunction {
    static MyFunction getMyFunction(String f3) {
        MyFunction myFunction = () -> System.out.println(f3 + ".run()");
        return myFunction;
    }
    void run() ;

    default void sayHello(){
        System.out.println("Hello");
    }
}
