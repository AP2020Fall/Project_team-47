package model.send.receive;

import model.others.Product;
import model.user.Seller;

import java.util.ArrayList;

public class CartInfo extends ServerMessage {
    private ArrayList<ProductInCart> products;
    private double price;


    public void addProductInfo(Product product, Seller seller, int numberInCart) {
        ProductInCart productInCart = new ProductInCart();
        productInCart.setNumberInCart(numberInCart);
        productInCart.setProduct(product);
        productInCart.setSeller(seller);
        products.add(productInCart);
    }

    public ArrayList<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductInCart> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private static class ProductInCart {
        private Seller seller;
        private Product product;
        private int numberInCart;

        public Seller getSeller() {
            return seller;
        }

        public void setSeller(Seller seller) {
            this.seller = seller;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getNumberInCart() {
            return numberInCart;
        }

        public void setNumberInCart(int numberInCart) {
            this.numberInCart = numberInCart;
        }
    }
}