package pks.ent;

@Service(name = "Crazy LazyService")
public class LazyService {

    @Init
    public void lazyInit() throws Exception {
        System.out.println("LazyService lazyInit");
    }
}
