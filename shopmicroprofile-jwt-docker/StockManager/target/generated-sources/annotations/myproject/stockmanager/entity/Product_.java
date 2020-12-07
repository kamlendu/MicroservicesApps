package myproject.stockmanager.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import myproject.stockmanager.entity.Stock;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-25T21:44:50")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> productid;
    public static volatile CollectionAttribute<Product, Stock> stockCollection;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, String> productname;
    public static volatile SingularAttribute<Product, String> description;

}