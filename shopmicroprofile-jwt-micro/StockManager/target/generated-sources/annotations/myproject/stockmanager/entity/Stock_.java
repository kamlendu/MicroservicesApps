package myproject.stockmanager.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import myproject.stockmanager.entity.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-03T17:08:06")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> quantity;
    public static volatile SingularAttribute<Stock, Product> productid;
    public static volatile SingularAttribute<Stock, Integer> stockid;

}