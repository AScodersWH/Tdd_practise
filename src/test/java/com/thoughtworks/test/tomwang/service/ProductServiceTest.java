package com.thoughtworks.test.tomwang.service;

import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setProduct(){
        Product product1 = new Product();
        product1.setName("tom");
        product1.setPrice("1231");
        Product product2 = new Product();
        product2.setName("ellen");
        product2.setPrice("1314");
        List<Product> products = new ArrayList<>();

        products.add(product1);
        products.add(product2);
        Mockito.when(productRepository.findAll()).thenReturn(products);
        Mockito.when(productRepository.findOneByName("ellen")).thenReturn(product2);
        Mockito.when(productRepository.findOneByName("tom")).thenReturn(product1);

    }

    @Test
    public void should_return_all_products(){
        Product product1 = new Product();
        product1.setName("tom");
        product1.setPrice("1231");
        Product product2 = new Product();
        product2.setName("ellen");
        product2.setPrice("1314");
        List<Product> products = new ArrayList<>();

        products.add(product1);
        products.add(product2);
        assertEquals(productService.getAllProducts(),products);
    }

    @Test
    public void should_return_product_by_name(){
        Product product = new Product();
        product.setName("tom");
        product.setPrice("1231");
        assertEquals(productService.getOneByName("tom"),product);
    }

    @After
    public void resetProduct(){
        Mockito.reset(productRepository);
    }
}
