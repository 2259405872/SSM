package com.ys.spring.service;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/*
添加事务注解
        因为service层表示业务逻辑层，一个方法表示一个完成的功能，因此处理事务一般在service层处理
        在BookServiceImpl的buybook()添加注解@Transactional
@Transactional标识在方法上，咋只会影响该方法
@Transactional标识的类上，咋会影响类中所有的方法

    1.只读
    对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这
    样数据库就能够针对查询操作来进行优化。
    2.超时
    事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间
    占用资源，大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。
    3.回滚策略
    声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
    可以通过@Transactional中相关属性设置回滚策略
    rollbackFor属性：需要设置一个Class类型的对象
    rollbackForClassName属性：需要设置一个字符串类型的全类名
    noRollbackFor属性：需要设置一个Class类型的对象
    rollbackFor属性：需要设置一个字符串类型的全类名
    事务隔离级别
    数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题。一个事
    务与其他事务隔离的程度称为隔离级别。SQL标准中规定了多种事务隔离级别，不同隔离级别对应不同
    的干扰程度，隔离级别越高，数据一致性就越好，但并发性越弱。
    隔离级别一共有四种：
        读未提交：READ UNCOMMITTED
        允许Transaction01读取Transaction02未提交的修改。
        读已提交：READ COMMITTED、
        要求Transaction01只能读取Transaction02已提交的修改。
        可重复读：REPEATABLE READ
        确保Transaction01可以多次从一个字段中读取到相同的值，即Transaction01执行期间禁止其它
        事务对这个字段进行更新。
        串行化：SERIALIZABLE
        确保Transaction01可以多次从一个表中读取到相同的行，在Transaction01执行期间，禁止其它
        事务对这个表进行添加、更新、删除操作。可以避免任何并发问题，但性能十分低下。


*/
@Transactional(
//        readOnly = true//只读
//        timeout = 5//查询超过5秒算作超时
//        noRollbackFor = ArithmeticException.class//遇到数学异常时不回滚
//        isolation = Isolation.DEFAULT//使用数据库默认的隔离级别
//        isolation = Isolation.READ_UNCOMMITTED//读未提交
//        isolation = Isolation.READ_COMMITTED//读已提交
//        isolation = Isolation.REPEATABLE_READ//可重复读
//        isolation = Isolation.SERIALIZABLE//串行化

)
public interface BookService {

    @Transactional
    void buyBook(Integer bookId, Integer userId);
}
