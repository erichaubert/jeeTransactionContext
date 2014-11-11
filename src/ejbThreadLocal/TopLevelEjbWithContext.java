package ejbThreadLocal;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class TopLevelEjbWithContext {
	@Resource private TransactionSynchronizationRegistry tsr;
	@Inject ConfigurationConsumingEjb ejb;
	
	public String executeWork(String id){
		tsr.putResource("id", id);
		return "I am returning this: "+ejb.doSomething();
	}
}
