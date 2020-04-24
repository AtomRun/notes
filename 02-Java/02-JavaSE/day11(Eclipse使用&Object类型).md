## Eclipse使用&Object类型


### 01_Java开发工具(常见开发工具介绍)(了解)
* A:操作系统自带的记事本软件
* B:高级记事本软件
* C:集成开发环境 IDE
	* (Integrated Development Environment)
* D:Eclipse和MyEclipse的区别
	* a:Eclipse是一种可扩展的开放源代码的IDE。
	* b:Eclipse的特点描述
		* 免费
		* 纯Java语言编写
		* 免安装
		* 扩展性强
	* c:MyEclipse
		* 在Eclipse基础上追加的功能性插件，对插件收费
		* 在WEB开发中提供强大的系统架构平台
* E:下载 http://eclipse.org/
	* org是非盈利团体 
* F:安装
	* 绿色版	解压就可以使用(Eclipse)
	* 安装版   双击运行,一路next即可(JDK)
* G:卸载
	* 绿色版	直接删除文件夹即可
	* 安装版 专业卸载软件或者控制面板添加删除程序

### 02_Java开发工具(Eclipse中HelloWorld案例以及汉化)(了解)
* A:选择工作空间
	* 工作空间  其实就是我们写的源代码所在的目录
* B:用Eclipse来完成一个HelloWorld案例
	* 代码以项目为基本单位
	* 创建项目
	* 创建包
	* 创建类
	* 编写代码
* C:编译和运行
* D:Eclipse的汉化
	* 从Eclipse3.5开始，安装目录下就多了一个dropins目录,只要将插件解压后放到到该目录即可。
	* 同理，这种方式卸载插件也是特别的方便，推荐这种方式
* E:语法检查提示
	* 红色波浪线
		* 必须处理,否则编译通不过
	* 黄色波浪线	
		* 可以不搭理他 

### 03_Java开发工具(Eclipse的视窗和视图概述)(了解)
* A:视窗  每一个基本的窗体被称为视窗
	* PackageExplorer  显示项目结构，包，类，及资源
	* Outline   显示类的结构，方便查找，识别，修改
	* Console  程序运行的结果在该窗口显示
	* Hierarchy 显示Java继承层次结构，选中类后F4
* B:视图  是由某些视窗的组合而成的
	* Java视图
	* Debug视图

### 04_Java开发工具(Eclipse工作空间的基本配置)(掌握)
* A:程序的编译和运行的环境配置(一般不改)
	* window -- Preferences -- Java
	* 编译环境：Compiler	默认选中的就是最高版本。
	* 运行环境：Installed JREs	默认会找你安装的那个JDK。建议配置了Java的环境变量。
	* 问题：
		* 低编译，高运行。可以。
		* 高编译，低运行。不可以。
		* 建议，编译和运行的版本一致。
* B:如何去掉默认注释?
	* window -- Preferences -- Java -- Code Style -- Code Templates
	* 选择你不想要的内容，通过右边Edit编辑。
	* 注意：请只删除注释部分，不是注释部分的不要删除。
* C:行号的显示和隐藏
	* 显示：在代码区域的最左边的空白区域，右键 -- Show Line Numbers即可。
	* 隐藏：把上面的动作再做一次。
* D:字体大小及颜色
	* a:Java代码区域的字体大小和颜色：
		* window -- Preferences -- General -- Appearance -- Colors And Fonts --Java修改 -- Java Edit Text Font
	* b:控制台
		* window -- Preferences -- General -- Appearance -- Colors And Fonts -- Debug -- Console font
	* c:其他文件
		* window -- Preferences -- General -- Appearance -- Colors And Fonts -- Basic -- Text Font
* E:窗体给弄乱了，怎么办?
	* window -- Reset Perspective
* F:控制台找不到了，怎么办?
	* Window--Show View—Console
* G:取消悬浮提示
	* window -- Preferences -- Java--Editor--Hovers。右边将Combined Hover勾去掉。
	* 这样代码的悬浮框就不会自动出现了。如果想看提示，将光标悬浮在代码上，按F2即可。

### 05_Java开发工具(Eclipse中内容辅助键的使用)(掌握)
* A:Alt+/ 起提示作用
* B:main+alt+/,syso+alt+/,给出其他提示
* C:补充输出语句,选中需要输出的部分,alt+/选择最后一项即可
* C:定义自己的alt + /
	* windows--perference-Java-Editor-Templates--New

### 06_Java开发工具(Eclipse中快捷键的使用)(掌握)
* A:新建 ctrl + n
* B:格式化  ctrl+shift+f
* C:导入包  ctrl+shift+o 
* D:注释  ctrl+/,ctrl+shift+/,ctrl+shift+\
* E:代码上下移动 选中代码alt+上/下箭头
* F:查看源码  选中类名(F3或者Ctrl+鼠标点击)
* G:查找具体的类 ctrl + shift + t
* H:查找具体类的具体方法 ctrl + o
* I:给建议 ctrl+1,根据右边生成左边的数据类型,生成方法
* J:删除代码 ctrl + d
* K:抽取方法alt + shift + m 
* L:改名alt + shift + r 

### 07_Java开发工具(Eclipse中如何提高开发效率)(掌握)
* alt + shift + s
* A:自动生成构造方法
* B:自动生成get/set方法

### 08_Java开发工具(Eclipse中一个标准学生类及其测试)(掌握)
* A:案例演示
	* 用Eclipse实现标准学生类及其测试

### 09_Java开发工具(Eclipse中接口抽象类具体类代码体现)(掌握)
* A:案例演示
	* 用Eclipse实现接口抽象类具体类代码

### 10_Java开发工具(Eclipse中如何生成jar包并导入到项目中)(了解)
* A:jar是什么?
	* jar是多个class文件的压缩包。
* B:jar有什么用?
	* 用别人写好的东西	
* C:打jar包
	* 选中项目--右键--Export--Java--Jar--自己指定一个路径和一个名称--Finish
* D:导入jar包
	* 复制到项目路径下并添加至构建路径。


### 11_Java开发工具(Eclipse中如何删除项目和导入项目)(掌握)
* A:删除项目
	* 选中项目 – 右键 – 删除
		* 从项目区域中删除
		* 从硬盘上删除
* B:导入项目
	* 在项目区域右键找到import
	* 找到General，展开，并找到
	* Existing Projects into Workspace
	* 点击next,然后选择你要导入的项目
	* 注意：这里选择的是项目名称

### 12_Java开发工具(Eclipse中断点调试的基本使用)(了解)
* A:Debug的作用
	* 调试程序
	* 查看程序执行流程
* B:如何查看程序执行流程		
	* 什么是断点：
		* 就是一个标记，从哪里开始。
		
	* 如何设置断点：
		* 你想看哪里的程序，你就在那个有效程序的左边双击即可。
		
	* 在哪里设置断点：
		* 哪里不会点哪里。
		* 目前：我们就在每个方法的第一条有效语句上都加。
		
	* 如何运行设置断点后的程序：
		* 右键 -- Debug as -- Java Application
		
	* 看哪些地方：
		* Debug：断点测试的地方
			* 在这个地方，记住F6，或者点击也可以。一次看一行的执行过程。
		* Variables：查看程序的变量变化
		* ForDemo：被查看的源文件
		* Console：控制台
		
	* 如何去断点：
		* a:再次双击即可
		* b:找到Debug视图，Variables界面，找到Breakpoints，并点击，然后看到所有的断点，最后点击那个双叉。

### 13_Java开发工具(Eclipse查看Java中参数传递问题)(了解)
* A:断点演示
	* 断点查看Java中参数传递问题

### 14_常见对象(API概述)(了解)
* A:API(Application Programming Interface) 
	* 应用程序编程接口
* B:Java API
	* 就是Java提供给我们使用的类，这些类将底层的实现封装了起来，
	* 我们不需要关心这些类是如何实现的，只需要学习这些类如何使用。

### 15. Object类的概述
    1. Object类概述
        1. 类层次结构的根类
        2. 所有类都直接或者间接的继承自该类
    2. 构造方法
        1. public Object()
        2. 回想面向对象中为什么说：
        3. 子类的构造方法默认访问的是父类的无参构造方法

### 16. Object类的hashCode()方法
    1. 案例展示
        1. public int hashCode()
            1. 返回该对象的哈希码值，默认情况下，该方法会根据对象的地址来计算
            2. 不同对象的，hashCode()一般来说不会相同。但是，同一个对象的hashCode()值肯定相同
            3. 不是对象的实际地址值，可以理解为逻辑地址值
                1. 举例：物体和编号
```java
package com.leeup.javase.day11.object;

import com.leeup.javase.day11.object.test.Student;

/**
 * hashCode展示
 * @author 李闯
 *
 */
public class Demo1_HashCode {

	public static void main(String[] args) {
		Object object = new Object();
		int hashCode = object.hashCode();//hashCode方法返回值为int,使用int来接收
		System.out.println(hashCode);//输出结果是一个int值
		/**
		 * 创建对象，对象要进内存，进内存需要申请地址值，这个hashCode就是地址值
		 * hahsCode源码方法上的native表示借助本地系统资源帮我们算出hashCode的值
		 */
		
		Student s1 = new Student("张三",23);
		Student s2 = new Student("李四",24);
		
		/**
		 * 每个对象都有自己的hashCode值，不相同
		 */
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}
```

### 17. Object类的getClass()方法[在反射的时候掌握]
    1. 案例展示
        1. public final Class getClass()
            1. 返回此Object的运行时类
            2. 可以通过Class类中的一个方法，获取对象的真实类的全名称
                1. public String getName()
```java
package com.leeup.javase.day11.object;

import com.leeup.javase.day11.object.test.Student;

public class Demo2_GetClass {

	public static void main(String[] args) {
		Student s = new Student();
		Class clazz = s.getClass();//返回值是Class我们使用Class接收,获取该对象的字节码文件
		//s.getClass 等于 new Class()
		String name = clazz.getName();//获取类名
	}
}
```

### 18. Object类的toString()方法
    1. 案例展示
        1. public String toString()
        2. 返回该对象的字符串表示
    
        public String toString(){
            return name + "," +age;
        }
    
        3. 它的值等于
            getClass().getName() + "@" + Integer.toHexString(hashCode())
        4. 由于默认情况下的数据对我们来说没有意义，一般建议重写该方法
    2. 最终版
        1. 自动生成
```java
package com.leeup.javase.day11.object;

import com.leeup.javase.day11.object.test.Student;

public class Demo3_ToString {

	public static void main(String[] args) {
		Student student = new Student("张三",23);
		String str = student.toString();
		/**
		 * 当Student类中没有重写toString方法的时候
		 * com.leeup.javase.day11.object.test.Student@15db9742
		 * 左边是Student的类名，右边是
		 * 
		 * toString源码中
		 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * 将getClass,getName的内容连接起来了
		 * Integer.toHexString  以十六进制(基数16)无符号整数形式返回一个整数参数的字符串表示形式
		 * 即能将整数转换为16进制以字符串形式返回,在这里就是对hashCode进行转换
		 * 
		 * 这么些没有什么实际意义，其实这是重写了父类的toString方法
		 * 
		 * 
		 * 当Student重写了toString方法的时候
		 * 即输出大家好
		 * 
		 * 真正有意义的toString是在输出的时候将属性值显示出来即
		 * return "我的姓名是" +name + "，我的年龄是"+age
		 * 
		 * toString方法的作用：
		 * 更方便地显示属性值
		 * 而getXxx是为了获取值，可以显示也可以赋值，或者做其他操作
		 */
		
		
		System.out.println(str);
		
		/**
		 * 如果直接打印对象的引用即student会默认调用toString方法
		 */
		System.out.println(student);
	}
}
```

### 19. Object类的equals()方法
    1. 案例展示
        1. 指示其他某个对象是否与此对象"相等"
        2. 默认情况下比较的是对象的引用是否相同
        3. 由于比较对象的引用没有意义，一般建议重写该方法
```java
package com.leeup.javase.day11.object;

import com.leeup.javase.day11.object.test.Student;

/**
 * euqals方法，比较两个对象是否相等
 * @author 李闯
 *
 */
public class Demo4_Equals {

	public static void main(String[] args) {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("张三",23);
		
		boolean b = s1.equals(s2);
		/**
		 *     public boolean equals(Object obj) {
         *			return (this == obj);
    	 *		}
    	 * 即调用的的对象和传入的对象进行比较，s1调用的时候就是将地址值传给了this,s2传进来的时候j即将地址值
    	 * 赋值给了obj,所以就是s1与s2比较
		 * 结果是false因为euqals比较的是地址值
		 * 
		 * Object中的equals方法是比较对象地址值的，没有什么意义，我们需要重写他
		 * 因为在开发中我们通常比较的是对象的属性值，我们认为相同属性是同一个对象，这样我们就需要重写equals方法
		 * 我们在Student类中重写euqals方法
		 */
		System.out.println(b);
		
		
		//根据地址值判断两个对象是否相等，不相等
		System.out.println(s1 == s2);
		
		//重写equals之后比较的是对象中的属性值
	}
}
```

```java
package com.leeup.javase.day11.object.test;

public class Student {

	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
//		return "大家好";
		return "我的姓名是" +name + "，我的年龄是"+age;
	}
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//我们想比较对象中的属性值，那就是比较Student的name和age是否相同
		//如果都相同，我们就认为这两个对象"相同"，但是这是我们认为的，并不是同一个对象
		
		//String的equals此字符串与 指定的对象比较，当且仅仅当该参数不为null，并且是与此对象表示相同字符序列
		//的String对象时，结果才为true
		
		Student student = (Student)obj;
		return this.name.equals(student.name) && this.age == student.age;//基本数据类型不能调用方法的
	}
}
```

### 20. ==号和equals方法的区别
    1. 共同点：都可以用来做比较，返回值都是boolean类型
    2. ==号是一个比较运算符，即可以比较基本数据类型，也可以比较引用数据类型，基本数据类型比较的是值，引用数据类型比较的是地址值
    3. equals方法是一个方法,只能比较引用数据类型,所有的对象都会继承Object类中的方法,如果没有重写Object类中的equals方法,equals方法和==号比较引用数据类型无区别,重写后的equals方法比较的是对象中的属性

### 21. day11总结
