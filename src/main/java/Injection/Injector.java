package Injection;

import Annotations.AutoInjectable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class which is implementing dependency injection based on a given annotation
 */
public class Injector {
    /**
     * File of information about the properties of injected dependencies
     */
    private File data;

    /**
     * Constructor with parameters for an object of the Injection.Injector class
     */
    public Injector(String filePath) {
        this.data = new File(filePath);
    }

    /**
     * Main dependency injection method
     *
     * @param obj object
     * @param <T> object class
     * @return new instance of initial object with injected dependencies, cast to its class
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T inject(T obj) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Properties properties = new Properties();
        properties.load(new FileReader(data));
        Class objectClass = obj.getClass();
        Object object = objectClass.newInstance();
        Field[] fields = objectClass.getDeclaredFields();
        for (Field f : fields) {
            Annotation annotation = f.getAnnotation(AutoInjectable.class);
            f.setAccessible(true);
            if (annotation != null) {
                String type = properties.getProperty(f.getType().getName());
                Object classObject = Class.forName(type).newInstance();
                f.set(object, classObject);
            }
        }
        return (T) object;
    }

}
