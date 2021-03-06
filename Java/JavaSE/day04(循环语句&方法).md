## 循环&方法
### 1. 循环结构概述和for语句的格式及其使用
    1. 循环结构的分类
    2. for,while,do...while 
    3. 循环结构for语句的格式：
		for(初始化表达式;条件表达式;循环后的操作表达式) {
			循环体;
		}
    1. 执行流程：
        1. 执行初始化语句
        2. 执行判断条件语句,看其返回值是true还是false
        3. 如果是true，就继续执行
        4. 如果是false，就结束循环
        5. 执行循环体语句;
        6. 执行循环后的操作表达式
        7. 回到2继续。
    2. 案例演示
        1. 在控制台输出10次"helloworld"
	
### 2. 循环结构for语句的练习之获取数据
    1. 案例演示
        1. 需求：请在控制台输出数据1-10
        2. 需求：请在控制台输出数据10-1
    2. 注意事项
        1. 判断条件语句无论简单还是复杂结果是boolean类型。
        2. 循环体语句如果是一条语句，大括号可以省略；如果是多条语句，大括号不能省略。建议永远不要省略。
    3. 一般来说：有左大括号就没有分号，有分号就没有左大括号
        1. 例如 for(int i =1;i<=10; i++);{
        2. System.out.println("i ="+i);
        3. }
        4. 如果加了分号，那么分号之前的表达式也会执行并且循环直到条件不满足跳出，跳出时i就被释放了，这时候执行输出语句i就是没有被声明的。

### 3.循环结构for语句的练习之求和思想
    1. 案例演示
        1. 需求：求出1-10之间数据之和
    2. 学生练习
        1. 需求：求出1-100之间偶数和
        2. 需求：求出1-100之间奇数和

### 4. 循环结构for语句的练习之水仙花
    1. 案例演示
        1. 需求：在控制台输出所有的”水仙花数”
        2. 所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身。
        3. 举例：153就是一个水仙花数。
        4. 153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
```java
package com.leeup.javase;
/**
 * 控制台输出所有的水仙花数
 * 
 * 水仙花数即一个三位数，其个位数字的立方和等于该数本身
 * 举例153就是一个水仙花数
 * 
 * @author 李闯
 * 153 = 1*1*1 + 5*5*5 + 3*3*3  = 1 + 125 + 27 = 53
 * 分析
 * 1. 100-999之间
 * 2. 获取每一个位数的值，百位，十位，个位
 * 3. 判断各个位上的立方和是否等于这个数，如果等于打印
 */
public class Test3_Flower {

	public static void main(String[] args) {
		for (int i = 100; i <=999; i++) {   //获取100-999之间的数
			int ge = i%10;//				//123 % 10  余3
			int shi = i / 10 % 10; 			//i/10;12  12%10; 2
			int bai = i/10/10 % 10;			//i/10;12  12/10; 1  1%10; 1
			
			if (ge * ge * ge + shi * shi * shi +bai * bai * bai == i) {
				System.out.println(i);
			}
		}
	}
	
}
```
### 5. 循环结构for语句的练习之统计思想
    1. 案例展示
        1. 需求：统计“水仙花数”有多少个
```java
package com.leeup.javase;

/**
 * 水仙花数有多少个
 * 分析：
 * 1. 需要有一个变量记录住水仙花数的个数
 * 2. 获取到所有的三位数
 * 3. 判断是不是水仙花数
 * 4. 如果满足条件是水仙花数，计数器就自增
 * @author 李闯
 *
 */
public class Test3_FlowerCount {

	public static void main(String[] args) {
		int count = 0;   //计数器
		
		for (int i = 100; i <= 999; i++) {
			int ge  = i%10;
			int shi = i/10%10;
			int bai = i/10/10%10;
			
			if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
				count +=1;
			}
		}
		System.out.println(count);
	}
}
```
### 6. 循环结构while语句的格式和基本使用
    1. 循环结构while语句的格式： 
        while循环的基本格式：
        while(判断条件语句){  
            循环体语句;       
        } 

        完整格式：

        初始化语句;
        while(判断条件语句){
            循环体语句;
            控制条件语句;
        }
    2. 执行流程
        1. 执行初始化语句
        2. 执行判断条件语句，看其返回值是true还是false
            1. 如果是true，就继续执行
            2. 如果是false，就结束循环
        3. 执行循环语句
        4. 执行控制条件语句
        5. 回到2继续
    3. 案例展示
        1. 需求：请在控制台输出数据0-10

```java
package com.leeup.javase.day02;
/**
 * 按照上述流程执行while输出数据0-10
 * @author 李闯
 *
 */
public class Demo1_While {
	public static void main(String[] args) {
		int x = 1;
		while (x<=10) {
			System.out.println("x = "+x);
			x++;
		}
	}
}
```
### 7. 循环结构while语句的练习  
    1. 求和思想
        1. 求1-100之和
    2. 统计思想
        1. 统计"水仙花数"共有多少个
```java
package com.leeup.javase.day02;
/**
 * 1. 求和思想
        1. 求1-100之和
   2. 统计思想
        1. 统计"水仙花数"共有多少个
 * @author 李闯
 *
 */
public class Test1_While {
	public static void main(String[] args) {
		//求和
		int sum = 0;
		int i = 1;
		while(i<=100) {
			sum+=i;			//sum = sum + i
			i++;			//让变量i自增
		}
		System.out.println(sum);
		
		//统计水仙花数
		int count = 0; 		//定义计数器
		int j = 100;            //定义初始化值
		while (i<=999) {
			int ge = i%10;
			int shi =  i/10%10;
			int bai = i/100;
			
			if (i == ge*ge*ge+shi*shi*shi+bai*bai*bai) {
				count ++;
			}
			i++;
		}
		System.out.println(count);
	}
}
```
```java
package com.leeup.javase.day02;
/**
 * 屌丝为了追求女神，写了一段代码示爱，但是女神也会java,改动了一个拒绝了屌丝
 * @author 李闯
 *
 */
public class DiaosiCode {

	public static void main(String[] args) {
		int j = 1;
		while (j<=10000); { 
			//加了分号，那么上面的语句是while语句，下面的并不属于while语句，条件一直满足，一直判断，下面就不会执行
			//即 有分号不能有左大括号，有左大括号不能有分号
			System.out.println("I love you !!!");
			j++;
		}
	}
}

```

### 8. 循环结构do...while语句的格式和基本使用
    1. 循环结构do...while语句的格式
        
        do {
            循环体语句;    
        }while(判断条件语句);

        完整格式：
        初始化语句;
        do{
            循环体语句;
            控制条件语句;
        }whil(判断条件语句)
    2. 执行流程
        1. 执行初始化语句
        2. 执行循环体语句
        3. 执行控制条件语句
        4. 执行判断条件语句，看其返回值是true还是false
            1. 如果是true，就继续执行
            2. 如果是false，就结束循环
        5. 回到2继续
    3. 案例展示
        1. 需求：请在控制台输出数据1-10
```java
package com.leeup.javase.day02;
/**
 * do_while执行流程
 * 在控制台输出数据1-10
 * @author 李闯
 *
 */
public class Demo1_DoWhile {

	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("i = "+i);
			i++;
		} while (i<=10);
	}
}
```

### 09. 循环结构三种循环语句的区别
    1. 案例展示
        1. 三种循环语句的区别：
            1. do...while循环至少执行一次循环体
            2. 而for，while循环必须先判断条件是否成立，然后决定是否执行循环体语句
    2. 案例展示
        1. for循环和while循环的区别：
            1. 如果你想在循环结束后，继续使用控制条件的那个变量，用while循环，否则用for循环，不知道用谁就用for循环。因为变量及早的从内存消失，可以提高内存的使用效率。
```java
package com.leeup.javase.day02;
/**
 * 三种循环结构的不同
 * @author 李闯
 *
 */
public class Demo2_Defferent {

	public static void main(String[] args) {
		/**
		 * do while 和 while的区别
		 * do while 至少会执行一次，但是while和for一样必须先判断条件是否成立，再执行循环体
		 */
		int i = 11;
		do {
			System.out.println(i);
			i++;
		} while (i<=10);
		
		System.out.println("=========分割线=========");
		
		int j = 11;
		while (j<=10) {
			System.out.println(j);
			j++;
		}
		
		for (int d = 1; d < 10; d++) {
			System.out.println(d);
		}
		//System.out.println(d);for语句在执行完之后，里面的变量会被释放掉，在这里在使用d就使用不到了
		System.out.println("=========分割线=========");
		
		int d = 1;
		while (d<=10) {
			System.out.println(d);
			d++;
		}
		System.out.println("=========分割线=========");
		System.out.println(d);	//while语句在执行后，初始化变量还可以继续使用。
	}
}

```
### 10. 循环结构注意事项之死循环
    1. 一定要注意控制条件语句控制的那个变量的问题，不要弄丢了，否则就容易死循环
    2. 两种最简单的死循环格式
        while(true){
            ...
        }  

        for(;;){
            ...    
        }
```java
package com.leeup.javase.day02;
/**
 * 无限循环
 * @author 李闯
 *
 */
public class Test1_ForEverCycle {

	public static void main(String[] args) {
		
		//while语句的无限循环
		while (true) {
			System.out.println("hello world");
		}
		//System.out.println("hello world"); //因为上面的语句是无限循环，一直执行，而这条语句永远都执行不到，所以这条语句不允许被书写
	//但无限循环可以使用控制语句，满足某种语句跳出循环，没有满足就一直循环	
		
		//for语句的无限循环
		for(;;) {
			System.out.println("Hello World");
		}
	}
}
```
### 11. 循环结构循环嵌套输出4行5列的星星
    1. 案例展示
        1. 需求：请输出一个4行5列的星星(*)图案。
            如图：
                    *****
                    *****
                    *****
                    *****
                    
                注意：
                    System.out.println("*");和System.out.print("*");的区别
    2. 结论：
        1. 外循环控制行数，内循环控制列数
```java
package com.leeup.javase.day02;
/**
 * for循环嵌套
 * 需求：输出一个4行5列的星星(*)图案
 * 	如图：
 * 		*****
 * 		*****
 * 		*****
 * 		*****
 * 
 * 注意：System.out.println("*");和System.out.print("*");的区别
 * 区别，println 每次输出之后后买能自动加个换行，print不加换行，
 * @author 李闯
 *
 */
public class Demo1_ForFor {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {			//外循环

			System.out.println("i = "+ i);
			for (int j = 1; j <= 3; j++) {		//内循环
				System.out.println("j = "+ j);
			}
		
		}
		
		for (int i = 1; i <= 4; i++) {			//外循环决定行数
			for (int j = 0; j <= 5; j++) {		//内循环决定列数
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
```
### 12. 循环结构嵌套输出正三角形
    1. 案例展示
        1. 需求：输出下列形状
        *
		**
		***
		****
		*****
```java
package com.leeup.javase.day02;
/**
    1. 需求：输出下列形状
    *
	**
	***
	****
	*****
 * @author 李闯
 *
 */
public class Demo2_ForFor {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {  		//外循环决定行数
			for (int j = 0; j <= i; j++) {	//内循环决定列数
				System.out.print("*");
			}
			System.out.println();			//将光标换到下一行的行首
		}
	}
}

```
### 13. 循环结构九九乘法表
    1. 案例演示
        1. 需求：在控制台输出九九乘法表
```java
package com.leeup.javase.day02;
/**
 * 控制台输出九九乘法表
 * @author 李闯
 * 1 * 1 = 1
 * 1 * 2 = 2  2 * 2 = 4
 * 1 * 3 = 3  2 * 3 = 6  3 * 3 = 9
 * 
 */
public class Demo3_For99 {

	public static void main(String[] args) {
		  for (int i = 1; i <= 9; i++) {   //行数
			for (int j = 1; j <= i; j++) { //列数
				System.out.print(j + "*" + i +"="+(i*j)+'\t');
			}
			System.out.println();
		}
	}
}

```
    2. 代码优化
        注意：
        '\x'  x代表任意，这种做法叫做转义字符
        '\t'  tab键的位置
        '\r'  回车
        '\n'  换行
        '\"'  
        '\''  

### 14. 控制跳转语句break语句
    1. break的使用场景
        1. 只能在switch和循环中
    2. 总结:跳出整个循环
```java
package com.leeup.javase.day02;
/**
 * break 的使用场景
 * 	只能在switch和循环中
 * @author 李闯
 *
 */
public class Demo1_Break {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				break; //跳出循环
			}
			System.out.println("x = "+i);
		}
	}
}
```

### 15. 控制跳转语句continue语句
    1. continue的使用场景
        1. 只能在循环中
    2. 总结 终结本次循环，继续下次循环
```java
package com.leeup.javase.day02;
/**
 * continue的使用场景
 * 	只能在循环中
 * @author 李闯
 *
 */
public class Demo2_Continue {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				continue; //终止本次循环，继续下次循环
			}
			System.out.println("x = "+i);
		}
	}
}
```
### 16. 控制跳转语句标号 
    1. 标号:标记某个循环对其控制
    2. 标号组成规则：其实就是合法的标识符
```java
package com.leeup.javase.day02;
/**
 * 
 * @author 李闯
 *
 */
public class Demo3_Mark {

	public static void main(String[] args) {
		outer:for (int i = 1; i <= 10; i++) {  //a就是标号[只要是合法标识符即可]，一般使用标号是多层循环的时候，即想要跳出指定循环
			System.out.println("i = "+ i);
			inner:for (int j = 1; j <=10; j++) {
				System.out.println("j = " + j);
				break outer; //在哪个循环体，就跳出哪个循环体，在这里跳出内循环，跳出内循环没有什么意义，一般是用来跳出外循环
			}
			
			
			System.out.println("大家好");
			http://www.baidu.com  		//在这里是个号，但是//后是一个单行注释，不会执行。这里http: 相当于给这个输出语句做了个标号
			System.out.println("才是真的好");
		}
	}
}
```

### 17.控制调整语句练习
    1. 练习题

		for(int x=1; x<=10; x++) {
			if(x%3==0) {
				//在此处填写代码
			}
			System.out.println("你好");
		}
		
		我想在控制台输出2次:"你好"
		我想在控制台输出7次:"你好"
		我想在控制台输出13次:"你好"
```java
package com.leeup.javase.day02;
/**
 * 输出2次你好
 * 输出7次你好
 * 输出13次你好
 * @author 李闯 
 *
 */
public class Test1 {
	public static void main(String[] args) {
		for (int i = 1; i <=10; i++) {
			 if (i%3==0) {
//				break;			//两次你好i%3==0第三次时break跳出
//				continue;		//使用continue跳出本次循环，当i的值为3，6，9的时候都满足会跳出，所以会输出7次
				System.out.println("你好");   //10里只有3，6，9能够%3==0,所以额外会输出三次，加上下面十次共13次
			}
			 System.out.println("你好");
		}
	}
}
``` 

### 18. 控制跳转语句return语句
    1. return的作用
        1. 返回
        2. 其实它的作用不是结束循环的，而是结束方法的
    2. 案例展示
        1. return和break以及continue的区别?
        2. return是结束方法
        3. break是跳出循环
        4. continue是终止本次循环继续下次循环
```java
package com.leeup.javase.day02;
/**
 * 控制跳转语句return语句和break区别
 * @author 李闯
 *
 */
public class Demo4_Return {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i==4) {
				System.out.println(i);
//				break;  //i==4时循环结束了,代码继续向下执行 ,循环结束了会被输出
				return; //用来返回方法，将主方法返回了，停止了，在break和return后有代码时体现较为明显
			}
		}
		System.out.println("循环结束了");
	}
}
```

### 19. 方法概述和格式说明
    1. 为什么要有方法
        1. 提高代码的复用性
    2. 什么是方法
        1. 完成特定功能的代码块
    3. 方法的格式

        修饰符 返回值类型 方法名(参数类型 参数名1,参数类型 参数名2...){
            方法体语句
            return 返回值;
        }

    4. 方法的格式说明
        1. 修饰符：目前就用public static 后面我们再详细的讲解其他的修饰符
        2. 返回值类型：就是功能结果的数据类型
        3. 方法名：符合命名规则即可，方便我们的调用
        4. 参数
            1. 实际参数：就是实际参与运算的
            2. 形式参数：就是方法定义上的，用于接收实际参数的
        5. 参数类型：就是参数的数据类型
        6. 参数名：就是变量名
        7. 方法体语句：就是完成功能的代码
        8. return：结束方法的
        9. 返回值：就是功能的结果，由return带给调用者

### 方法之求和案例及其调用
    1. 如何写一个方法
    2. 案例展示
        1. 求两个数据之和的案例
```java
package com.leeup.javase.day02.方法;
package com.leeup.javase.day02.方法;
/**
 * 利用方法求两个数的和
 * @author 李闯
 *
 */
public class Demo2_Sum {

	public static void main(String[] args) {
		int result = sum(12, 44); 			//1. 调用add方法，将12，20，分别传递给a,b,这里给的参数就是实际参数 	 
		System.out.println(result);			//4. 方法返回的结果返回给result并输出
	}
	
	/**
	 * 求两个整数的和
	 * 1. 整数的和结果还是整数
	 * 2. 有两个未知内容参与运算
	 * 
	 * 如何写方法?
	 * 1. 明确返回值类型，在这里即int
	 * 2. 方法名字，要起到见名知意，即sum
	 * 3. 明确参数列表，这里对两个整数进行运算，即int a ,int b [形式参数，用来接收调用方法时传的值]
	 * 3.1  参数类型即 int
	 * 3.2  参数名即 a,b
	 */
	public static int sum(int a, int b) {	//2. 赋值a = 10, b = 20;
		return a+b;							//3. 执行语句把a,b相加并返回
	}
	
	/**
	 * 使用开饭店：厨师的案例来讲解方法的使用/便利
	 * 
	 * 盘子 [返回类型] 炒菜[方法名](油,调料,米,菜[形式参数，等待实际参数填入]){
	 * 		炒菜的动作[方法体操作语句]
	 * 		return 一盘菜[返回值和返回类型的类型保持一致]
	 * }
	 */
	
	/***
	 * 调用方法
	 * 
	 * //盘子 = 炒菜(地沟油,苏丹红,镉大米,烂白菜[实际参数]);  注：返回值类型是什么，我们就要用什么类型去接收
	 */
}

}
```
### 21. 方法的注意事项
    1. 方法调用
        1. 单独调用，一般来说没有意义，所以不推荐
```java
sum(12, 44); 	//单独调用，一般不建议，有返回值的方法的单独调用,没有意义
```
        2. 输出调用，但是不够好，因为我们可能需要针对结果进行进一步的操作
```java
System.out.println(sum(3, 5));  //这样调用是可以,但是如果需要这个结果不推荐这样调用
```
        3. 赋值调用，推荐方案[将得到的结果赋值给定义的变量，方便对其操作和取值]
```java
int result = sum(12, 44);
System.out.println(result);
```
    1. 案例展示
        1. 方法不调用不执行[例如：厨师在没客人的时候就闲着，来了客人再去炒菜。即方法在被调用的时候才会执行]
        2. 方法与方法是平级关系，不能做嵌套定义[例如：厨师具备炒菜的功能，还具备洗衣服的功能， 但是厨师不能炒菜的时候洗衣服或者洗衣服的时候炒菜，这两者应该是并列关系,不能嵌套使用]
        3. 方法定义的时候参数之间用逗号隔开
        4. 方法调用的时候不用再传递数据类型[在调用方法时不需要再传递参数的类型，这里传递参数相当于给形式参数赋值，即类型其实已经被定义好，我们只需要传递参数即可]
        5. 如果方法有明确返回值类型，一定要有return 带回一个值[除void不需要返回值外，只要定义了返回值类型，就必须使用return语句带回相应类型的参数]

### 22. 方法的练习
    1. 案例演示
        1. 需求：键盘录入两个数据，返回两个数中的较大值
    2. 案例演示
        1. 需求：键盘录入两个数据，比较两个数是否相等
```java
package com.leeup.javase.day02.方法;

import java.util.Scanner;

/**
 * 1. 案例展示
 * 	需求:键盘接收两个数据,返回两个数中的较大值
 * 2. 案例展示
 * 	需求:键盘录入两个数据,比较两个数是否相等
 * @author 李闯
 *
 */
public class Test1_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//1. 创建键盘录入对象
		
		System.out.println("请输入第一个整数!");
		int x = sc.nextInt();				//2. 键盘录入的值存储在x中
		System.out.println("请输入第二个整数!");
		int y = sc.nextInt();
		
		int max = getMax(x, y);
		System.out.println("您输入的的最大值为"+max);
		
		
		boolean b =isEquals(x, y);
		System.out.println(b == true?"您输入的两个数相同":"您输入的两个数不同");
	}
	
	/**
	 * 方法返回两个整数值中的较大值
	 * 分析
	 * 1. 明确返回值类型 int 
	 * 2. 明确参数列表,两个int整数
	 */
	public static int getMax(int a,int b) {
		return a > b ? a:b;
	}
	
	/**
	 * 方法比较两个数是否相等
	 * 分析:
	 * 1. 明确返回值类型 boolean
	 * 2. 明确参数列表,两个int类型
	 */
	public static boolean isEquals(int a,int b) {
		return a == b;//a==b 即true,a!=b 即false
	}
}
```

### 23. 方法之输出星形及其调用
    1. 案例演示
        1. 需求：根据键盘录入的行数和列数，在控制台输出星形
    2. 方法调用：(无返回值,void)
    3. 单独调用
    4. 输出调用(错误)
    5. 赋值调用(错误)
```java
package com.leeup.javase.day02.方法;

import java.util.Scanner;

/**
 * 案例展示
 * 		需求:根据键盘录入的行数和列数,在控制台输出星形
 * 方法调用
 * 		单独调用
 * 		输出调用[错误]
 * 		赋值调用[错误]
 * 		
 * 根据情况来看只能使用单独调用最合适
 * 返回值是void的方法,只能单独调用,并不能输出或者
 * @author 李闯
 *
 */
public class Demo3_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("请输入行数");
		int row = sc.nextInt();  
		System.out.println("请输入列数");
		int column = sc.nextInt();
		
		getStar(row, column);
	}
	
	/**
	 * 控制台输出矩形星形
	 * 分析:
	 * 	返回值类型:经分析,没有具体的返回值类型,即可使用void
	 * 	参数类型:行与列为int类型参数
	 * 
	 * 
	 */
	public static void getStar(int a,int b) {
		for (int i = 1; i <=a; i++) {
			//行数
			for (int j = 1; j <=b; j++) {
				//列数
				System.out.print("*");
			}
			System.out.println();//内循环结束即换行一次
		}
		return ;//如果返回值类型是void,return可以省略,即使省略系统也会默认给加上,形式是 return;
	}
}
```

### 24. 方法的练习
    1. 案例演示
        1. 需求：根据键盘录入的数据输出对应的乘法表
```java
package com.leeup.javase.day02.方法;
/**
 * 案例展示
 * 		需求:根绝键盘录入的数据输出对应的九九乘法表
 * @author 李闯
 *
 */

import java.util.Scanner;

public class Test2_Method {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("请输入一个1-9之间的整数");
		
		int x = sc.nextInt();
		print99(x);
	}
	
	/**
	 * 输出对应的九九乘法表
	 * 分析
	 * 		1. 返回值类型:void
	 * 		2. 参数列表:只需要一个int数
	 */
	public static void print99(int a) {
		for (int i = 1; i < a; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(j + "*" + i + "=" + (i * j)+"\t");
			}
			System.out.println();
		}
	}
}
```

### 25. 方法重载概述和基本使用
    1. 方法的重载和概述
        1. 求和案例
            1. 2个整数
            2. 3个整数
            3. 4个整数
        2. 方法重载
            1. 在同一个类中，方法名相同，参数列表不同，与返回值类型无关
            2. 参数列表不同
                1. 参数个数不同
                2. 参数类型不同
                3. 参数的顺序不同

### 26. 方法重载练习比较数据是否相等
    1. 案例演示
        1. 需求：比较两个数据是否相等。
        2. 参数类型分别为两个int类型，两个double类型，并在main方法中进行测试

### 27. day04总结
    1. 把今天的知识点总结一遍。