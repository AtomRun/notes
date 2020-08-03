# Mybatis Plus的Example

```java
@Transactional(propagation = Propagation.SUPPORTS)
@Override
public boolean queryUsernameIsExist(String username) {
    // 使用Example进行查询，即使用条件查询，初始化Example的时候要传入要查询的是哪一个实体类
    Example userExample = new Example(Users.class);
    //创建一个条件
    Example.Criteria userCriteria = userExample.createCriteria();
    //通过userCriteria创建条件
    //两个属性，1：要和实体中哪一个字段进行对比，2：传入的值
    userCriteria.andEqualTo("username",username);
    //调用根据条件查询一个的方法
    Users result = usersMapper.selectOneByExample(userExample);
    // 判断返回结果
    return result == null ? false : true;
}
```