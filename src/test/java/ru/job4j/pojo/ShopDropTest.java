package ru.job4j.pojo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 0);
        MatcherAssert.assertThat(rsl[0].getName(), is("Bread"));
        MatcherAssert.assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 1);
        MatcherAssert.assertThat(rsl[0].getName(), is("Milk"));
        MatcherAssert.assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenArrayLengthIs4AndDeleteElementWithIndex1() {
        Product[] products = new Product[4];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        int index = 1;
        Product[] rsl = ShopDrop.delete(products, index);
        MatcherAssert.assertThat(rsl[index].getName(), is("Milk"));
        MatcherAssert.assertThat(rsl[2].getName(), is("Fish"));
        MatcherAssert.assertThat(rsl[products.length - 1], is(nullValue()));
    }

    @Test
    public void whenArrayLengthIs5AndDeleteElementWithIndex2() {
        Product[] products = new Product[5];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        products[4] = new Product("Fruit", 8);
        int index = 2;
        Product[] rsl = ShopDrop.delete(products, index);
        MatcherAssert.assertThat(rsl[1].getName(), is("Egg"));
        MatcherAssert.assertThat(rsl[index].getName(), is("Fish"));
        MatcherAssert.assertThat(rsl[3].getName(), is("Fruit"));
        MatcherAssert.assertThat(rsl[products.length - 1], is(nullValue()));
    }
}