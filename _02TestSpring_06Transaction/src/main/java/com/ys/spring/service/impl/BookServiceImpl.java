package com.ys.spring.service.impl;

import com.ys.spring.dao.BookDao;
import com.ys.spring.dao.impl.BookDaoImpl;
import com.ys.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        Integer price=bookDao.getPriceByBookId(bookId);
        bookDao.updateStock(bookId);
        bookDao.updateBalance(bookId, price);
    }
}
