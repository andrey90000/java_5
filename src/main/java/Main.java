import Injection.ClassForInjection;
import Injection.Injector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Test 1:");
        ClassForInjection inj = (new Injector("C:/Users/Andreyy/IdeaProjects/Laba5Java/src/main/resources/props.properties").inject(new ClassForInjection()));
        inj.Action();
        System.out.println("Test 2:");
        ClassForInjection inj2 = (new Injector("C:/Users/Andreyy/IdeaProjects/Laba5Java/src/main/resources/props2.properties").inject(new ClassForInjection()));
        inj2.Action();
    }


}
