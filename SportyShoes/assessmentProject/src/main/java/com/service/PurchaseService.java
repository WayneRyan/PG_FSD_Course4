package com.service;

import com.bean.Category;
import com.bean.Purchase;
import com.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    public List<Purchase> getFilteredPurchases(Date startDate, Date endDate, Category category) {
        return purchaseDao.getFilteredPurchases(startDate, endDate, category);
    }
}
