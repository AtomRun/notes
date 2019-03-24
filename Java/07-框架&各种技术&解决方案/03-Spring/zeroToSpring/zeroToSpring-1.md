## 单元测试
### 单元测试的误区
- 编译通过不就行了吗？
- 测试是测试小组的事，程序员应该做些更有趣的事,比如学习新技术
- 我写完代码已经手工测试过了，为什么还要写单元测试？
- 我用调试器把所有的分支都走过了，肯定没问题，提交！
- 管它什么单元测试，时间已经不多了，经理催得紧，先做个丑陋的修改，让它工作，有时间再改吧。
- 写测试太麻烦了，得准备一大堆数据，不值
- 那些测试运行时间太长了。

### 什么是单元测试？
- 单元测试是开发人员编写的一小段代码，用于检验被测代码的一个明确功能的小模块是否正确。
    - 通常是用来判断某个类和函数的行为
    - 白盒测试
        - 即开发人员已经很清楚的知道，程序的内部逻辑是什么，有哪些分支或者异常，函数之间的调用关系是什么，比如哪里用if，那里是while，哪里用do while等等，在这种情况下，对功能进行测试，我们称之为“白盒测试”
    - 黑盒测试
        - 即不知道内部实现是什么，只知道对外提供的接口，这个软件像一个黑盒一样，只对外暴露出了一些API，对外暴露了一些功能，我们通过使用这些功能，去看它和我们的预料的是不是一致的，这就是黑盒测试
    - **开发人员**是最大的受益者
-  总结： 我们的单元测试，其实是白盒测试。

### 举例
```java
public class Calculator {

    public int evaluate(String expr){

        //对expr进行解析，执行运算，实现代码略过
        int result = ...
        return result;
    }
}
```
"10+20-5" ->25 <br/>
"(20-10)*5+6/3" -> 52

- 这个方法会对字符串进行解析，把它变成一个数，或压入栈，进行处理计算，让后返回，比如返回25或者52。
- 现在问题是，我们将代码写完了，我们如何保证这段代码实现了我们要求的功能呢？，或者说怎么判断它是正确的呢。
    - 一种办法是，人肉测试，我们使用main中手工运行，观察结果即可。如下：
```java
public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int result = calculator.evaluate("10+20-5");
    System.out.println(result);

    result = calculator.evaluate("(20-10)*5+6/3");
    System.out.println(result);
}
```
- 但是如果只有一个类采用这个方法完全可以，但是如果有几十几百个类，不能将其都运行一边，更麻烦的事，类与类之间都是有关联的，如果你修改了类x，x影响了y，y影响了z，这就很麻烦了。
- 所以我们能不能有一个框架帮我们自动运行这些类呢？答案自然是肯定的，大名鼎鼎的Juint就可以帮助我们解决这个问题。 
- 使用@Test注解修饰方法，Juint就会知道这是一个测试用例，就会在后续的运行中，执行这个测试用例
```java
    @Test
    public void testEvaluate1(){
        Calculator calculator = new Calculator();
        int result = calculator.evaluate("10+20-5");
        // 确定这个表达式的结果是25
        Assert.assertEquals(25,result);
        //这个 Assert.assertEquals 就是让Juint来替我们人类判断，期待值和实际值。
        //如果这两个值不同，那么juint会给我们报错，如果相等即通过。
    }

    @Test
    public void testEvaluate2(){
        Calculator calculator = new Calculator();
        int result = calculator.evaluate("(20-10)*5+6/3");
        Assert.assertEquals(52,result);
    }
```
- 只要我们按照规定来写代码，剩下的就交给框架了。框架能找到测试用例，然后执行测试用例，来检查实际值和期待值是否一样。

### 成百上千的测试用例如何组织？
![image](https://github.com/AtomRun/notes/blob/master/noteimages/zeroToSpring/1.png)
- 将其分门别类地组织起来，Juint给我们提供了一个Suite的东西，即一个套件，它可以一层一层的将测试用例组织起来，组织成一个数。
- 右边的图有个叫AllTest.java的类，左边显示它用了一个注解@RunWith，所以我们知道了，这个类用于Suite.class这个类来运行，即作为一个套件来执行。
- 那么这个套件下有哪些测试类呢？他们有V1-V4AllTest，也就是说上面的AllTest分别把下面的每个包的AllTest包括了进来。当运行上面的AllTest时，会把下面的每一个AllTest都执行了。
- 那么V4AllTest又将它包下的类所有测试类装载进去了，通过这种分层的方式，一个包下有AllTest,最顶层也有AllTest，这样就把所有的测试用例组织起来了。
- 这样一来的好处就是，可以运行单独的测试用例，比如ClassReaderTest,可以只运行一个，如果点v4Test就运行包下的，如果是顶层的就是全部运行。
- 其实这种suite的方式就是设计模式中的组合模式的使用。

### Junit的几种断言
> 断言非常重要，没有断言，这些框架就无法为我们自动检查结果对不对
- 常用的断言如下：
```java
Assert.assertEquals(expected,actual);
//两个数值是否Equals
Assert.assertTrue(condition);
//是否为true
Assert.assertNotNull(object);
//判断一个对象是否为Null
Assert.assertArrayEquals(expecteds,actuals);
//判断两个数据是否相等
```

### 如何对Exception进行测试
> 比如有时候，我们给一个类的方法提供一些输入值后，它也许不满足的它的条件，会抛出异常，那对于异常该怎么进行测试呢？
- 如下例子：我们的计算器，传入的表达式10/0，除数为0，就会抛出算数异常，
```java 
@Test
public void testEvaluteWrongExpression(){
    Calculator cal = new Calculator();
    try{
        int result = cal.envalute("10/0");
    }catch(ArithmeticException e){
        //代码应该进入这个分支
    }
    //如果走到这里，说明计算器实现的不准确。
    Assert.fail();//强制测试用例失败
}
```
- 如果你想使用注解的话也可以，Juint4提供了注解，exception=ArithmeticException.class，程序里就不用做try catch了，相对来说比较简单。
```java
@Test(exception=ArithmeticException.class)
public void testEvaluteWrongExpression(){
    Calculator cal = new Calculator();
    int result = cal.envalute("10/0");
}
```

### 两个特殊的方法
- 这两个方法也是使用特殊的标记来标注的，@Before和@After
```java
public class CalculatorTest {
    @Before
    public void setUp(){
        //每个测试用例执行前都会被调用一次
    }
    @After
    public void tearDown(){
        //每个测试用例执行后都会被调用一次
    }
    @Test
    public void testEvaluate1(){
        //测试用例的代码
    }
    @Test
    public void testEvaluate2(){
        //测试用例的代码
    }
}
```