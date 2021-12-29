package Implementations;

import Interfaces.InterfaceNumOne;

public class TestImplementation implements InterfaceNumOne {

    @Override
    public void doSomething() {
        System.out.println("Test is working");
    }
}
