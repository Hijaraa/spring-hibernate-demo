package org.example;

import org.example.dao.IDao;
import org.example.entities.Product;
import org.example.util.HibernateConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void testProductCRUD() {
        // Initialize Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        
        // Get ProductDao bean
        IDao<Product> productDao = context.getBean(IDao.class);
        assertNotNull("ProductDao should not be null", productDao);
        
        // Create a new product
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(99.99);
        
        // Test create
        boolean createResult = productDao.create(product);
        assertTrue("Product creation should succeed", createResult);
        assertNotEquals("Product ID should be set after creation", 0, product.getId());
        
        // Test findById
        Product foundProduct = productDao.findById(product.getId());
        assertNotNull("Product should be found by ID", foundProduct);
        assertEquals("Product name should match", "Test Product", foundProduct.getName());
        assertEquals("Product price should match", 99.99, foundProduct.getPrice(), 0.001);
        
        // Test update
        foundProduct.setName("Updated Product");
        foundProduct.setPrice(199.99);
        boolean updateResult = productDao.update(foundProduct);
        assertTrue("Product update should succeed", updateResult);
        
        // Verify update
        Product updatedProduct = productDao.findById(product.getId());
        assertEquals("Product name should be updated", "Updated Product", updatedProduct.getName());
        assertEquals("Product price should be updated", 199.99, updatedProduct.getPrice(), 0.001);
        
        // Test findAll
        List<Product> products = productDao.findAll();
        assertNotNull("Product list should not be null", products);
        assertFalse("Product list should not be empty", products.isEmpty());
        
        // Test delete
        boolean deleteResult = productDao.delete(updatedProduct);
        assertTrue("Product deletion should succeed", deleteResult);
        
        // Verify deletion
        Product deletedProduct = productDao.findById(product.getId());
        assertNull("Product should be null after deletion", deletedProduct);
    }
}