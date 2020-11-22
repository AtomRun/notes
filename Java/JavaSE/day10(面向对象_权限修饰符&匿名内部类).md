## 面向对象_权限修饰符&匿名内部类

### 1. package 关键字的概述及其作用
    1. 为什么要有包
        1. 将字节码(.class)进行分类存放
        2. 包其实就是文件夹
    2. 包的概述
        1. 举例
            1. 学生：增加，删除，修改，查询
            2. 老师：增加，删除，修改，查询
        2. 方案1：按照功能划分
            1. com.leeup.add
                1. AddStudent
                2. AddTeacher
            2. com.leeup.delete
                1. DeleteStudent
                2. DeleteTeacher
            3. com.leeup.update
                1. UpdateStudent
                2. UpdateTeacher
            4. com.leeup.find
                1. FindStudent
                2. FindTeacher
        3. 方案2：按照模块分
            1. com.leeup.teacher
                1. AddTeacher
                2. DeleteTeacher
                3. UpdateTeacher
                4. FindTeacher
            2. com.leeup.student
                1. AddStudent
                2. DeleteStudent
                3. UpdateStudent
                4. FindStudent

### 2. 包的定义及其注意事项
    1. 定义包的格式
        1. package 包名
        2. 多级多用.分开即可
    2. 定义包的注意事项
        1. package语句必须是程序的第一条可执行的代码
        2. package语句在一个java文件中只能有一个
        3. 如果没有package，默认表示无包名
    3. 案例展示
        1. 包的定义及注意事项

### 3. 带包的编译和运行
    1. 如何编译运行带包的类
        1. javac编译的时候带上-d即可
            1. javac -d . HelloWorld.java
        2. 通过java命令执行
            1. java报名.HelloWorld

### 4. 不同包下类之间的访问
    1. 案例展示
        1. 不同包下类之间的访问

### 5. import关键字的概述和使用
    1. 案例展示
        1. 为什么要有import
            1. 其实就是让有包的类对调用者可见，不用写全类名了
    2. 导包格式
        1. import 包名
        2. 注意：
            1. 这种方式导入是到类的名称
            2. 虽然最后可以写*，但是不建议
    3. package,import,class 有没有顺序关系(面试题)
        1. 有

### 6. 四种权限修饰符的测试
    1. 案例展示
        1. 四种权限修饰夫
    2. 结论 
        1. 在不同包下的无关类，不允许访问，因为是protected修饰的
|           | 不同包下(无关类) | 本类 | 同一个包下(子类和无关类) | 不同包下(子类) |
| --------- | ---------------- | ---- | :----------------------- | :------------- |
| private   | Y                |      |                          |                |
| default   | Y                | Y    |                          |                |
| protected | Y                | Y    | Y                        |                |
| public    | Y                | Y    | Y                        | Y              |

### 7. 类及其组成所使用的常见修饰符

    1. 修饰符
        1. 权限修饰符：private,默认的，protected,public
        2. 状态修饰符：static,final
        3. 抽象修饰符：abstract
    2. 类
        1. 权限修饰符：默认修饰符，public
        2. 状态修饰符：final
        3. 抽象修饰符：static
        4. 用的最多的就是：public
    3. 成员变量
        1. 权限修饰符：private，默认的，protected，public
        2. 状态修饰符：static，final
        3. 用的最多的就是：public
    4. 构造方法
        1. 权限修饰符：private，默认的，protected，public
        2. 用的最多的就是：public
    5. 成员方法
        1. 权限修饰符：private，默认的，protected，public
        2. 状态修饰符：static，final
        3. 抽象修饰符：abstract
        4. 用的最多的就是：public
    6. 除此以外的组合规则：
        1. 成员变量：public static final
        2. 成员方法：
            1. public static
            2. public abstract
            3. public final

### 8. 内部类的概述和访问特点
    1. 内部类概述：
        1. 内部类访问特点
            1. 内部类可以直接访问外部类成员变量，包括私有
            2. 外部类要访问内部类成员，必须创建对象
            3. 外部类名.内部类名 对象名 = 外部类对象.内部类对象;
    2. 案例展示
        1. 内部类及其访问特点
```java
package com.leeup.javase.day10.成员内部类;


public class Demo1_InnerClass {

	public static void main(String[] args) {
		//如何让method方法执行,直接new不行，因为JVM不知道Inner是属于哪个类的Inner，要告诉他是属于Inner的
//		Inner inner = new Inner();
//		inner.method();
		/**
		 * 这里Inner是外部类的成员，把他看成外部类的成员就好了
		 * 要先new Outer对象
		 * 外部类访问内部类成员被必须创建对象，格式就如下
		 */
		Outer.Inner oiInner = new Outer().new Inner();//创建内部类对象
		oiInner.method();
		
	}
}

class Outer {
	
	private int num = 10;
	
	class Inner {
		public void method() {
			System.out.println("Hello World");
			/**
			 * 内部类可以访问外部类的私有成员
			 * 因为内部类相当于外部类的成员方法
			 */
			System.out.println(num);
		}
	}
}
```

### 9. 成员内部类私有使用
    1. private
```java
package com.leeup.javase.day10.成员内部类;


public class Demo2_InnerClass {

	public static void main(String[] args) {
		/**
		 * 当内部类私有的时候，这种访问方式不行，没办法根据父类new子类
		 */
//		Outer1.Inner oiInner = new Outer1().new Inner();
		/**
		 * 成员内部类被私有的时候，可以使用这种方式调用 
		 */
		Outer1 outer1 = new Outer1();
		outer1.print();
		
	}
}

class Outer1 {
	
	private int num = 10;
	
	private class Inner {
		public void method() {
			System.out.println(num);
		}
	}
	public void print() {
		/**
		 * 内部类相当于外部类的成员，即使是私有的，也是可以访问的
		 */
		Inner inner = new Inner();
		inner.method();
	}
}
```
### 10. 静态成员内部类
    1. static
    2. 成员内部类被静态修饰后的访问方式是：
        1. 外部类名.内部类名 对象名 = 外部类名.内部类对象;
```java
package com.leeup.javase.day10.静态内部类;

public class Demo1_InnerClass {

	public static void main(String[] args) {
		/**
		 * 如何去调用静态的成员内部类的方法
		 * 
		 * Outer.Inner中Outer是一个类名。Outerus.Inner是调用了Inner的一个构造
		 */
		Outer.Inner oInner = new Outer.Inner();
		oInner.method();
		
		/**
		 * 静态内部类的静态方法如何访问
		 */
		Outer.Inner2.print();
	}
}

class Outer{
	static class Inner {
		public void method() {
			System.out.println("method");
		}
	}
	
	static class Inner2{
		public static void print() {
			System.out.println("print");
		}
	}
}

```
### 11. 成员内部类的面试题
    1. 要求使用已知的变量，在控制台输出30，20，10
```java
package com.leeup.javase.day10.静态内部类;
/**
 * 要求使用已知的变量，在控制台输出30，20，10
 * @author 李闯
 *
 */
public class Test1_InnerClass {

	public static void main(String[] args) {
		Outer1.Inner oInner = new Outer1().new Inner();
		oInner.show();
	}
}
/**
 * 内部类之所以能获取外部类的成员，是因为，他们能获取到外部类的引用 外部类名.this
 * @author 李闯
 *
 */
class Outer1 {
	public int num = 10;
	class Inner {
		public int num = 20;
		public void show() {
			int num = 30;
			System.out.println(num);//就近原则直接给num即可
			System.out.println(this.num);//调用本类的num
			System.out.println(Outer1.this.num);//Outer1相当于限定了，告诉你是哪个类下的，即Outer下的this.num
		}
	}
}
```
### 12. 局部内部类访问局部变量的问题
    1. 案例展示
        1. 局部内部类访问局部变量必须用final修饰
        2. 局部内部类在访问他所在方法中的局部变量必须用final修饰，为什么？
            1. 因为当调用这个方法时,局部变量如果没有用final修饰,他的生命周期和方法的生命周期是一样的,当方法弹栈,这个局部变量也会消失,那么如果局部内部类对象还没有马上消失想用这个局部变量,就没有了,如果用final修饰会在类加载的时候进入常量池,即使方法弹栈,常量池的常量还在,也可以继续使用
            2. 但是jdk1.8取消了这个事情,所以我认为这是个bug,虽然取消,如果在书写代码时候,没有手动添加,系统底层也会默给你final
```java
package com.leeup.javase.day10.局部内部类;

public class Demo1_InnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
	}
}

/**
 * 局部内部类
 * @author 李闯
 *
 */
class Outer {
	/**
	 * 开发中很少见这种情况
	 */
	public void method() {
		
		/**
		 * 当调用本方法时，局部变量的生命周期和方法相同，
		 * 如果局部内部类对象还没有消失想用这个局部变量，就没办法了，
		 * 但是当final修饰的时候会保存在方法区的常量池内，使用即使方法弹栈，常量池的常量还在，可以继续使用
		 */
		int num = 10;
		
		class Inner {
			public void print () {
				System.out.println("Hello World");
				System.out.println(num);
			}
			
		}
		Inner inner = new Inner();
		inner.print();
	}
	
	public void run() {
		/**
		 * 局部内部类相当于局部变量
		 * 局部变量只在方法内有效，所以同理，访问方法中的类，无法直接访问
		 */
//		Inner i = new Inner();
//		i.print
	}
}
```
### 13. 匿名内部类的格式和理解
    1. 匿名内部类
        1. 就是内部类的简化写法
    2. 前提：存在一个类或者接口
        1. 这里的类可以是具体类也可以是抽象类
    3. 格式：
        new 雷鸣或者接口名(){
            重写方法;
        }
    4. 本质是什么呢？
        1. 是一个继承了该类或者实现了该接口的子类匿名对象
    5. 案例展示
        1. 按照要求来一个匿名内部类

### 14. 匿名内部类重写多个方法调用
    1. 案例展示
        1. 匿名内部类的方法调用
```java
package com.leeup.javase.day10.匿名内部类;

public class Demo1_NoNameInnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();
	}
}

interface Inter{
	public void print();
}

/**
 * 有名字的内部类
 * @author 李闯
 *
 */
class Outer {
	class Inner implements Inter{

		@Override
		public void print() {
			System.out.println("print");
		}
	}
	public void method() {
		Inner inner = new Inner();
		inner.print();
		
		/**
		 * 代表Inter的子类对象 
		 */
		new Inner().print();
		
		/**
		 * 匿名内部类与局部内部类相同，都存在于方法中
		 */
		new Inter() {	//实现Inter接口，必须要重写接口中的方法
			 
			@Override
			public void print() {
				System.out.println("print2");
			}
		}.print();;
		
	}
}
```
```java
package com.leeup.javase.day10.匿名内部类;

public class Demo2_NoNameInnerClass {

	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		outer1.method();
	}
}

interface Inter1 {
	public void show1();
	public void show2();
}

/**
 * 匿名内部类只针对重写一个方法时候使用，多个方法时应使用有名字的方法
 * 匿名内部类不能向下转型，因为没有子类类名 
 * @author 李闯
 *
 */
class Outer1 {
	
	public void method() {
		
		//较为臃肿
		/*new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show1();
		
		new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show2();*/
		
		new Inter1() {	//实现接口并且重写他的方法
			
			@Override
			public void show2() {
				System.out.println("show2");
			}
			
			@Override
			public void show1() {
				System.out.println("show1");
			}
		}.show2();
	}
}
```

### 15. 匿名内部类在开发中的应用
    1. 代码如下
        //这里写抽象类，接口都行
    	abstract class Person {
    		public abstract void show();
    	}
    
    	class PersonDemo {
    		public void method(Person p) {
    			p.show();
    		}
    	}
    
    	class PersonTest {
    		public static void main(String[] args) {
    			//如何调用PersonDemo中的method方法呢?
    			PersonDemo pd = new PersonDemo ();
    			
    		}
    	}
```java
package com.leeup.javase.day10.匿名内部类;

public class Test1_NoNameInnerClass {

	//如何调用PersonDemo中的method方法
	public static void main(String[] args) {
		PersonDemo personDemo = new PersonDemo();
//		personDemo.method(new Student());
		//使用匿名内部类如何做到？
		personDemo.method(new Person() {//继承Person类并且重写抽象类中的方法
			/**
			 * 匿名内部类在开发中的应用，当作参数传递(本质把匿名内部类看作一个对象)
			 */
			@Override
			public void show() {
				System.out.println("show");
			}
		});
	}
}

//这里写抽象了类，接口都行
abstract class Person {
	public abstract void show();
}

class PersonDemo {
	public void method(Person p) {		//Person p = new Student();
		
		p.show();
	}
}

class Student extends Person {

	@Override
	public void show() {
		System.out.println("show");
	}	
}
```
### 16. 匿名内部类的面试题
    1. 代码如下
        按照要求，补齐代码
            interface Inter { void show(); }
            class Outer { //补齐代码 }
            class OuterDemo {
                public static void main(String[] args) {
                    Outer.method().show();
                }
            }
            要求在控制台输出”HelloWorld”

### 17. day10总结
    1. 今天的知识点梳理一遍