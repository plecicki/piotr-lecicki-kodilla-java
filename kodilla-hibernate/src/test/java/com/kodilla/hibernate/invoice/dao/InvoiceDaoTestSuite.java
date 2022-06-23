package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Bike");
        Item item1 = new Item(new BigDecimal(6500),5,new BigDecimal(5000));
        Item item2 = new Item(new BigDecimal(3000), 1, new BigDecimal(2000));
        Item item3 = new Item(new BigDecimal(20000), 10, new BigDecimal(15000));
        Invoice invoice1 = new Invoice("12345");
        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product1.getItems().add(item3);
        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product1);
        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        //When
        invoiceDao.save(invoice1);
        int id = invoice1.getId();

        //Then
        Assertions.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
