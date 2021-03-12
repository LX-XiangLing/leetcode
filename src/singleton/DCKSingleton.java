package singleton;

/**
 * @Author lixiang
 * @Date 2021/3/13
 */
public class DCKSingleton {
    private volatile static DCKSingleton singleton;

    private DCKSingleton() {
    }

    public DCKSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DCKSingleton.class) {
                if (singleton == null) {
                    singleton = new DCKSingleton();
                }
            }
        }
        return singleton;
    }
}
