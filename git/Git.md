# 使用Git之前必须做的最小配置

1. 配置user.name和user.email

```shell
$git config --global user.name = 'yourName'
$git config --global user.email = 'yourEmail'
```

2. 配置的作用？
   1. 用来记录谁在什么时间点做了什么变更，将修改人的信息和变更的信息绑定
   2. codeReview时如果带上了代码提交人的信息，例如Email，Git版本管控可以自动发邮件
3. global的作用？
   1. local:只对某个仓库有效
   2. global：对当前所有仓库有效
   3. system：对系统所有登录的用户有效
4. 显示config的配置，加--list

```#shell
$git config --list --global/local/system
```

# 建立Git仓库

## 两种场景

1. 把已有的项目代码纳入git管理

```shell
$cd 项目代码所在的文件夹
$git init 
```

2. 新建的项目直接用项目管理

```shell
$cd 某个文件夹
$git init your_project #会在当前目录下创建和项目名称同名的文件夹
$cd your_project
```

# 通过几次commit来认识工作区和暂存区

1. 工作目录 git add files 到暂存区
2. 暂存区git commit到版本历史

# 给文件夹重命名的简便方法

```shell
git mv readme readme.md
```

# 通过git log查看版本演进历史

```shell
git log --oneline #简洁的看版本历史
git log -n4 --oneline #最近的4个commit

```

