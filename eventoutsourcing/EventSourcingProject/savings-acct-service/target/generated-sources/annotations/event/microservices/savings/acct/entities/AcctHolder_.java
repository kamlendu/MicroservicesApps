package event.microservices.savings.acct.entities;

import event.microservices.savings.acct.entities.SavingsAcct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-01T13:04:12")
@StaticMetamodel(AcctHolder.class)
public class AcctHolder_ { 

    public static volatile SingularAttribute<AcctHolder, String> firstName;
    public static volatile SingularAttribute<AcctHolder, String> lastName;
    public static volatile CollectionAttribute<AcctHolder, SavingsAcct> savingsAcctCollection;
    public static volatile SingularAttribute<AcctHolder, Long> id;

}