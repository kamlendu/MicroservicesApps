package event.microservices.savings.acct.entities;

import event.microservices.savings.acct.entities.AcctHolder;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-01T13:04:12")
@StaticMetamodel(SavingsAcct.class)
public class SavingsAcct_ { 

    public static volatile SingularAttribute<SavingsAcct, Double> acctBalance;
    public static volatile SingularAttribute<SavingsAcct, AcctHolder> acctholderId;
    public static volatile SingularAttribute<SavingsAcct, Long> id;
    public static volatile SingularAttribute<SavingsAcct, BigInteger> checkingAcctNbr;
    public static volatile SingularAttribute<SavingsAcct, BigInteger> acctNbr;

}