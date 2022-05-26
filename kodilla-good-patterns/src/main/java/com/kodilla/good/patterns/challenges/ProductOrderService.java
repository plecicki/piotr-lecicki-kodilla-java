package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private Product product;
    private CommunicationWithClient communicationWithClient;

    public ProductOrderService(final Product product,
                               final CommunicationWithClient communicationWithClient) {
        this.product = product;
        this.communicationWithClient = communicationWithClient;
    }

    public void process(int items) {
        if (product.isAvailable()) {
            boolean bought = product.buying(items, product);
            if (bought) {
                communicationWithClient.send();
            }
        } else {
            System.out.println("Lack of product!\n");
        }
    }
}
