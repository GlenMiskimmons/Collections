package com.pluralsight.collections._6_maps;

public interface ProductLookupTable
{
    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}
