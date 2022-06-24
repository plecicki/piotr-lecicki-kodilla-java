package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

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
        Optional<Invoice> invoiceFromDB = invoiceDao.findById(id);

        Assertions.assertNotEquals(0, id);
        Assertions.assertTrue(invoiceFromDB.isPresent());
        for(int i=0; i<3; i++) {
            Assertions.assertEquals("Bike", invoiceFromDB.get().getItems().get(i).getProduct().getName());
        }
        Assertions.assertEquals(0, new BigDecimal(6500).compareTo(invoiceFromDB.get().getItems().get(0).getPrice()));
        Assertions.assertEquals(0, new BigDecimal(3000).compareTo(invoiceFromDB.get().getItems().get(1).getPrice()));
        Assertions.assertEquals(0, new BigDecimal(20000).compareTo(invoiceFromDB.get().getItems().get(2).getPrice()));
        Assertions.assertEquals(5, invoiceFromDB.get().getItems().get(0).getQuantity());
        Assertions.assertEquals(1, invoiceFromDB.get().getItems().get(1).getQuantity());
        Assertions.assertEquals(10, invoiceFromDB.get().getItems().get(2).getQuantity());
        Assertions.assertEquals(0, new BigDecimal(5000).compareTo(invoiceFromDB.get().getItems().get(0).getValue()));
        Assertions.assertEquals(0, new BigDecimal(2000).compareTo(invoiceFromDB.get().getItems().get(1).getValue()));
        Assertions.assertEquals(0, new BigDecimal(15000).compareTo(invoiceFromDB.get().getItems().get(2).getValue()));

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
