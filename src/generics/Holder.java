package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/6 8:29
 */
public class Holder<T> {
    private T value;
    public Holder() {}

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public void set1(Object val){
        value = (T)val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        // Holder<Fruit> Fruit = Apple; // Holder<Apple>无法向上转型为Holder<Fruit> 因为泛型不支持协变
        Holder<? extends Fruit> fruit = Apple; // Holder<Apple>允许向上转型为Holder<? extends Fruit>
        Fruit p = fruit.get(); //get方法只返回Fruit类型，因为编译器从<? extends Fruit>唯一确定的信息就是Fruit，如果编译器了解更多具体信息，那么就可以转型到具体的某种Fruit类型
        d = (Apple)fruit.get(); // Returns ‘Object’
        try {
            Orange c = (Orange)fruit.get(); // 这样转型没有警告，但存在ClassCastException风险
        } catch(Exception e) { System.out.println(e); }
        // fruit.set(new Apple()); //无法使用set方法 因为此时fruit的set()方法参数为? extends Fruit，因此无法传入任何类型的实参
        // fruit.set(new Fruit()); //无法使用set方法
        fruit.set1(new Apple()); //使用set1方法可以，因为set1参数是用Object来接受
        System.out.println(fruit.equals(d)); // OK 因为参数列表为Object类型
    }
}
