package com.how2java.tmall.service;
 
import com.how2java.tmall.dao.ProductDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService  {
     
    @Autowired ProductDAO productDAO;
    @Autowired CategoryService categoryService;
 
    public void add(Product bean) {
        productDAO.save(bean);
    }
 
    public void delete(int id) {
        productDAO.deleteById(id);
    }
 
    public Product get(int id) {
        return productDAO.getOne(id);
    }
 
    public void update(Product bean) {
        productDAO.save(bean);
    }
 
    public Page4Navigator<Product> list(int cid, int start, int size,int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable =  PageRequest.of(start, size, sort);
        Page<Product> pageFromJPA =productDAO.findByCategory(category,pageable);
        List<Product> ps=new ArrayList<>();

        return new Page4Navigator<>(pageFromJPA,navigatePages);


    }
 
}