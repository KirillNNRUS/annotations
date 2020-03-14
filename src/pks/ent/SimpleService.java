package pks.ent;

@Service(name = "Super Simple Service")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("SimpleService initService");
    }

    public void dumbTemp() {
        System.out.println("SimpleService dumbTemp");
    }
}
