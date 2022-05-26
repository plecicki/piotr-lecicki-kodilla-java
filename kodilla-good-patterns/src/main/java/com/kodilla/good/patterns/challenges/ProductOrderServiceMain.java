package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceMain {
    public static void main(String[] args) {
        StoreProductsDB storeProductsDB = new StoreProductsDB();

        Product bikeDto1 = storeProductsDB.getBike1();
        Product bikeDto2 = storeProductsDB.getBike2();
        Product bikeDto3 = storeProductsDB.getBike3();
        Product breadDto1 = storeProductsDB.getBread1();
        Product wristwatchDto1 = storeProductsDB.getWristwatch1();

        CommunicationWithClient SMSMessage = new SMSMessage();
        CommunicationWithClient MailMessage = new MailMessage();

        ProductOrderService productOrderService1 = new ProductOrderService(bikeDto1, SMSMessage);
        productOrderService1.process(1);

        ProductOrderService productOrderService2 = new ProductOrderService(bikeDto2, MailMessage);
        productOrderService2.process(4);

        ProductOrderService productOrderService3 = new ProductOrderService(bikeDto3, SMSMessage);
        productOrderService3.process(2);

        ProductOrderService productOrderService4 = new ProductOrderService(breadDto1, SMSMessage);
        productOrderService4.process(3);

        ProductOrderService productOrderService5 = new ProductOrderService(wristwatchDto1, MailMessage);
        productOrderService5.process(2);
    }
}
