# @RequestMapping
- Spring MVC使用@RequestMapping注解为控制器指定可
  以处理哪些URL请求
- 在控制器的类定义及方法定义处都可标注

## @RequestMapping标注在类定义处

- 提供初步的请求映射信息。相对于WEB应用的根目录

## @RequestMapping标注在方法处

- 提供进一步的细分映射信息。相对于类定义处的URL。若类定义处未标注@RequestMapping ,则方法处标记的URL相对于WEB应用的根目录

## @ReuqestMapping规定请求方式

1. Method：限定请求方式，例如METHOD=POST默认只接受POST请求，默认全部接受
   1. GET
   2. POST
   3. PUT
   4. DELETE
2. params：规定请求参数，可以多个，数组类型，例如params={"username"}
   1. 以上的含义就是请求的时候必须带上一个名为username的参数。没带都会404
   2. params={"!username"}，表示不带username能访问
   3. params={"username=123"}，带username并且值为123才能访问

## @RequestMapping规定请求头

- headers：和params一样能写简单的表达式

## @ReuqestMapping规定请求地址占位符

### URL地址可以写模糊的通配符:

- ? :能替代任意-一个字符
- *能替代任意多个字符，和一层路径
- **能替代多层路径

