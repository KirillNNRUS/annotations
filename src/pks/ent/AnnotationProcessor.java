package pks.ent;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectAnnotationClassService(SimpleService.class);
        inspectAnnotationClassService(LazyService.class);
        inspectAnnotationClassService(String.class);
        System.out.println("---");

        boolean isTrue = isClassHasInitAnnotationInPublicMethods(SimpleService.class);
        System.out.println(isTrue);
        printPublicClassMethods(SimpleService.class);
    }

    static Method[] getPublicMethodsClass(Class<?> service) {
        return service.getMethods();
    }

    static void printPublicClassMethods(Class<?> service) {
        Method[] temp = getPublicMethodsClass(service);
        System.out.println("---");
        System.out.println("Public Methods of the " + service.toString());
        for (Method m : temp) {
            System.out.println(m.toString());
        }
    }

    static boolean isClassHasInitAnnotationInPublicMethods(Class<?> service) {
        Method[] temp = getPublicMethodsClass(service);
        for (Method m : temp) {
            if (m.getDeclaredAnnotation(Init.class) != null) {
                System.out.println("@Init in the " + m.toString());
                return true;
            }
        }
        return false;
    }

    static void inspectAnnotationClassService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            getAnnotationClassName(service);
        } else {
            sorry();
        }
    }

    static void getAnnotationClassName(Class<?> service) {
        Service annotation = service.getAnnotation(Service.class);
        System.out.println(annotation.name());
    }

    static void sorry() {
        System.out.println("Sorry");
    }

}
