package singleton;

/**
 * @Author lixiang
 * @Date 2021/3/13
 */
public class LazySingleton {
    private static LazySingleton singleton;

    public LazySingleton() {
    }

    public static LazySingleton getSingleton() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
