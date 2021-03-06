package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型与协变 (由于泛型不支持协变，因此使用通配符解决转型问题)
 * @author: hxw
 * @date: 2018/12/3 23:42
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        //List<Fruit> flist = new ArrayList<Apple>();  Compile Error: incompatible types:
        // 从上面一行代码知道泛型不支持协变，我们也可以这样理解，假设允许泛型协变，当List<Apple>成功转型为List<Fruit>，那么他就可以add任何Fruit的子类型了，当你尝试添加一个Orange到这List<Fruit>这明显就是错误的
        //上面无法直接向数组那样，但如果加上通配符，就允许,但是这样做就无法向其添加任何类型的对象
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:编译错误无法添加任何对象
        // 因为此时add()方法的参数变成? Extends Fruit,编译器并不知道这是什么类型，所以无法'安全'的向其中添加对象,因此add 方法不能添加任何有意义的元素
        //flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // 合法却无意义
        // We know that it returns at least Fruit: 但允许你返回对象
        Fruit f = flist.get(0);
        //List<T extends Fruit> h = new ArrayList<>();//注意这种写法是错误的，List已经是一个泛型类了，在创建List对象时向泛型中再传入泛型，明显不对,只有在声明时才能使用泛型参数T，例如下面的
        //泛型方法，以及常见的泛型类，在创建泛型类的实例时，泛型必须传入的是特定的类型，要不就不传，决不能再次传入泛型。

    }

    public static <T extends Fruit> void test(){

    }
}

