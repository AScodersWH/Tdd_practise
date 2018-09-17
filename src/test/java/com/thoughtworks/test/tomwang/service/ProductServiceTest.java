package com.thoughtworks.test.tomwang.service;

import com.thoughtworks.test.tomwang.model.Product;
import com.thoughtworks.test.tomwang.model.User;
import com.thoughtworks.test.tomwang.repository.UserRepository;
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
    private UserRepository userRepository;

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
        List<Product> deletedProducts = new ArrayList<>();
        deletedProducts.add(product2);
        products.add(product1);
        products.add(product2);
        User user = new User();

        user.setProducts(products);
        Mockito.when(userRepository.findOneById(1)).thenReturn(user);
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
        assertEquals(productService.getAllProducts(1),products);
    }

    @Test
    public void should_return_product_by_name(){
        Product product = new Product();
        product.setName("tom");
        product.setPrice("1231");
        assertEquals(productService.getOneByName(1,"tom"),product);
    }

    @Test
    public  void should_delete_product_by_name_successfully(){
        Product product1 = new Product();
        product1.setName("tom");
        product1.setPrice("1231");
        Product product2 = new Product();
        product2.setName("ellen");
        product2.setPrice("1314");
        List<Product> products = new ArrayList<>();
        List<Product> deletedProducts = new ArrayList<>();
        deletedProducts.add(product2);
        products.add(product1);
        products.add(product2);
        assertEquals(productService.deleteProductByName(1,"tom"),deletedProducts);
    }

    @Test
    public void should_store_successfully(){
        Product product1 = new Product();
        product1.setName("tom");
        product1.setPrice("1231");
        Product product2 = new Product();
        product2.setName("ellen");
        product2.setPrice("1314");
        Product product3 = new Product();
        product3.setName("wda");
        product3.setPrice("1231");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        assertEquals(productService.store(1,product3),products);
    }

    @After
    public void resetProduct(){
        Mockito.reset(userRepository);
    }
}
