package com.pluralsight.collections._6_maps;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(final Product productToAdd)
    {
        for(Product product : products) {
            if(product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("Unable to add product, duplicate id for " + productToAdd);
            }
        }

        products.add(productToAdd);
    }

    @Override
    public Product lookupById(final int id)
    {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
