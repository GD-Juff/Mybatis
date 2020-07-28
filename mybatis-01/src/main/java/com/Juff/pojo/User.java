package com.Juff.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

//POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans
//0 其中有一些属性及其getter setter方法的类,没有业务逻辑
//有一个简单的运算属性也是可以的,但不允许有业务方法，也不能携带有connection之类的方法
//POJO实质上可以理解为简单的实体类，顾名思义POJO类的作用是方便程序员使用数据库中的数据表
//可以很方便的将POJO类当做对象来进行使用，当然也是可以方便的调用其get,set方法
@Alias("hello")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;


}
