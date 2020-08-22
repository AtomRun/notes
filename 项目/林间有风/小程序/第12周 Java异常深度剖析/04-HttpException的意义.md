# HttpException的意义

## 1. 配置文件与类对应

当配置文件与类对应的时候，我们操作类就像操作配置文件。

## 2. 配置项较多提取为配置文件

## 3. 异常处理流程

如果代码中需要异常，我们要新建一个异常类，继承HttpException然后我们传入code码，表示我们发生的是怎样的异常，我们只用传入code码，剩下的全局异常处理就会根据code码找到code对应的message

## 4. HttpExcption

叫HttpExcption的原因是因为所有异常都是根据Http状态码来区分的，并且类似NotFoundExcption，我们还要根据具体的业务异常来根据状态码创建不同的具体的异常。

NotFoundExcption可以作为订单未找到的异常，也可以作为资源未找到的异常。

