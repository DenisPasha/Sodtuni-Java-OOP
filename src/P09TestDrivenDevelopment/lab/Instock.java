package P09TestDrivenDevelopment.lab;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    List<Product> productList;



    public Instock() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public boolean contains(Product product) {
        return productList.contains(product);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean productIsFound = false;
        for (Product currentProduct : productList) {
            if (currentProduct.label.equals(product)) {
                currentProduct.setQuantity(quantity);
                productIsFound = true;
                break;
            }

        }
        if (!productIsFound) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Product find(int index) {
        if (index >= 0 && index < productList.size()){
            return productList.get(index);
        }else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public Product findByLabel(String label) {
        boolean productIsFound = false;
        Product product = null;
        for (Product currentProduct : productList) {
            if (currentProduct.getLabel().equals(label)) {
                product = currentProduct;
                productIsFound = true;
            }
        }
        if (!productIsFound) throw new IllegalArgumentException();
        else return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {

        if (productList.size() >= count){
            List<Product> collect = productList.stream().sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
            List<Product> collect1 = collect.stream().limit(count).collect(Collectors.toList());
            return collect1;
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product>productsToReturn = new ArrayList<>();

        for (Product currentProduct : productList) {
            if (currentProduct.getPrice() > lo && currentProduct.getPrice() <= hi) {
                productsToReturn.add(currentProduct);
            }
        }
        productsToReturn.sort(Comparator.comparing((Product::getPrice)).reversed());
        return productsToReturn;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> collect = productList.stream().filter(product -> product.getPrice() == price).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count <= productList.size()){
            List<Product> collect = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
            List<Product> collect1 = collect.stream().limit(count).collect(Collectors.toList());
            return collect1;
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {

        List<Product> collect = productList.stream().filter(product -> product.getQuantity()==quantity).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
