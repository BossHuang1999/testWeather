package example.testClient;

import example.HelloWorld;

public class Client {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        String test = hw.sayHelloWorldFrom("tom");
    }
}
