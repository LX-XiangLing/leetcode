package singleton;

/**
 * @Author lixiang
 * @Date 2021/3/13
 */
public class StaticInnerSingleton {
    private static class SingletonHandler {
        private static StaticInnerSingleton singleton = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHandler.singleton;
    }
}
