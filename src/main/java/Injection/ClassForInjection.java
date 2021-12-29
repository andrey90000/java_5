package Injection;

import Annotations.AutoInjectable;
import Interfaces.InterfaceNumOne;
import Interfaces.InterfaceNumTwo;

/**
 * Class which is demonstrating auto dependency injection with annotations
 */
public class ClassForInjection {
    @AutoInjectable
    private InterfaceNumOne fieldOne;
    @AutoInjectable
    private InterfaceNumTwo fieldTwo;

    /**
     * Method which is outputs result of injection
     */
    public void Action() {
        fieldOne.doSomething();
        fieldTwo.doAnything();
    }

}
