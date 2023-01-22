package P09TestDrivenDevelopment;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InstockTest {


    Instock stock = new Instock();
    public void addProducts(){
        Product product = new Product("Rice",2.2,5);
        Product product1 = new Product("Bread",1.2,10);
        stock = new Instock();
        stock.add(product);
        stock.add(product1);
    }


    @Test
    public void testContainsAndAddProduct(){
        Product product = new Product("Rice",2.2,5);
        Product product1 = new Product("Bread",1.2,10);
        ProductStock stock = new Instock();
        stock.add(product);
        stock.add(product1);

        Assert.assertTrue(stock.contains(product));
        Assert.assertTrue(stock.contains(product1));
    }

    @Test
    public void testGetCountReturnsCorrectSize(){
        addProducts();
        Assert.assertEquals(2,stock.getCount());
    }

    @Test
    public void testFind(){
        addProducts();
        Product product = stock.find(1);
        Assert.assertEquals("Bread",product.getLabel());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testFindWhenIndexOutOfBounds(){
        addProducts();
        stock.find(100);

    }

    @Test
    public void testIfProductQuantityHasUpdated(){
        addProducts();
        stock.changeQuantity("Rice",15);
        int rice = stock.getProductList().stream().filter(product -> product.getLabel().equals("Rice"))
                .findFirst().get().getQuantity();

        Assert.assertEquals(15,rice);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowsException(){
        addProducts();
        stock.changeQuantity("Baklava",15);
    }

    @Test
    public void testFindProductByLabelFindsCorrectProduct(){
        addProducts();

        Product rice = stock.findByLabel("Rice");
        Product wantedProduct = stock.getProductList().get(0);
        Assert.assertEquals(wantedProduct,rice);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFindProductThrowsExceptionWhenEnteredInvalidProduct(){
        addProducts();
        Product baklava = stock.findByLabel("Baklava");
    }

    @Test
    public void findFirstByAlphaOrderReturnsCorrectData(){
        addProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(2);
        List<String>labelsList = new ArrayList<>();

        for (Product product: iterable) {
            labelsList.add(product.getLabel());
        }
        Assert.assertEquals(2,labelsList.size());

    }
    @Test
    public void findFirstByAlphaOrderReturnsEmpty(){
        addProducts();
        Iterable<Product> firstByAlphabeticalOrder = stock.findFirstByAlphabeticalOrder(3);
        int counter = 0;
        for (Product product : firstByAlphabeticalOrder) {
            counter++;
        }
        Assert.assertEquals(0,counter);
    }

    @Test
    public void testFindAllInRangeWithValidData(){
        Product product = new Product("Baklava",14.00,3);
        Product product1 = new Product("Musaka",16.00,3);
        Product product2= new Product("Kashkaval",1.00,3);

        stock.add(product);
        stock.add(product1);
        stock.add(product2);
        Iterable<Product> allInRange = stock.findAllInRange(10.2, 20.20);

        int counter = 0;
        for (Product products : allInRange){
            counter++;
        }
        Assert.assertEquals(2,counter);
    }

    @Test
    public void testFindAllByPrice(){
        addProducts();
        int count = 0;
        Iterable<Product> allByPrice = stock.findAllByPrice(21);
        for (Product product : allByPrice){
            count++;
        }
        Assert.assertEquals(0,count);
    }

    @Test
    public void testFindFirstMostExpensiveProductsValidNumber(){
        addProducts();
        Product product = new Product("Karamel",45.4,121);
        stock.add(product);

        Iterable<Product> firstMostExpensiveProducts = stock.findFirstMostExpensiveProducts(1);
        List<Product> foundProducts = new ArrayList<>();

        for (Product product1 : firstMostExpensiveProducts){
            foundProducts.add(product1);
        }

        List<Product> collect = stock.getProductList().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
        List<Product> collect1 = collect.stream().limit(1).collect(Collectors.toList());

        Assert.assertArrayEquals(collect1.toArray(),foundProducts.toArray());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowsException(){
        addProducts();
        stock.findFirstMostExpensiveProducts(8);
    }

    @Test
    public void testFindAllByQuantityValid(){
        addProducts();
        Iterable<Product> allByQuantity = stock.findAllByQuantity(10);
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : allByQuantity){
            foundProducts.add(product);
        }
        Product product = new Product("Bread",1.2,10);

        Assert.assertEquals(product.getLabel(),foundProducts.get(0).getLabel());
        Assert.assertEquals(product.getPrice(),foundProducts.get(0).getPrice(),1.2);
        Assert.assertEquals(product.getQuantity(),foundProducts.get(0).getQuantity());

    }
}