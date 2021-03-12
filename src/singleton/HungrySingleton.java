package singleton;

/**
 * @Author lixiang
 * @Date 2021/3/13
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();


    public static HungrySingleton getSingleton() {
        return hungrySingleton;
    }
}
