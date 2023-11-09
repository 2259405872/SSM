package com.ys.spring.service.impl;

import com.ys.spring.service.BookService;
import com.ys.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
事务传播行为
当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中
运行，也可能开启一个新事务，并在自己的事务中运行。
@Transactional(propagation = Propagation.REQUIRED)，默认情况，表示如果当前线程上有已经开
启的事务可用，那么就在这个事务中运行。
@Transactional(propagation = Propagation.REQUIRES_NEW)，表示不管当前线程上是否有已经开启
的事务，都要开启新事务。
*/
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;
    @Override
    @Transactional(
            propagation = Propagation.REQUIRES_NEW//事务传播行为
    )
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
