package ejbThreadLocal;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class ConfigurationConsumingEjb {
	@Resource private TransactionSynchronizationRegistry tsr;
	
	public String doSomething(){
		String idExtracted = (String)tsr.getResource("id");
		System.out.println("context id: "+ idExtracted);
		return idExtracted;		
	}
}
