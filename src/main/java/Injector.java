import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector<T> {

    /**
     * Для полей с @AutoInjectable
     * @param obj - объект класса
     * @return - возвращает объект
     */
    public T inject(T obj) {
        Class cl = obj.getClass();

        for(Field fl : cl.getDeclaredFields()) {
            Annotation a = fl.getAnnotation(AutoInjectable.class);
            if(a != null) {
                fl.setAccessible(true);
                try {
                    String classObj = getName(fl.getType().getName());
                    fl.set(obj, Class.forName(classObj).newInstance());
                } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    /**
     * Имя типа из myApp.properties.
     * @param name - имя для инициализации поля в myApp.properties.
     * @return - возвращает имя типа.
     */

    private String getName(String name) {
        ClassLoader loader = getClass().getClassLoader();

        Properties prs = new Properties();

        try(InputStream io = loader.getResourceAsStream("myApp.properties")) {
            prs.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prs.getProperty(name);
    }

}
