package pks.ent;

public class AnnotationProcessor {
    static Service ann;

    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            getAnn(Service.class);
        } else {
            sorry();
        }
    }

    static void getAnn(Class<?> service) {
        ann = service.getAnnotation(Service.class);
        System.out.println(ann.name());
    }

    static void sorry() {
        System.out.println("Sorry");
    }
}
