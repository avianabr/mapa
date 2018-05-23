package model.bean;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class SCABeanTest {

	public static void main(String[] args) {
		Context ctx = null;

		Hashtable ht = new Hashtable();
		ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		//ht.put(Context.PROVIDER_URL, "t3://localhost:7003,localhost:7004,localhost:7005");
		ht.put(Context.PROVIDER_URL, args[0]);
		
		

		try {
			ctx = new InitialContext(ht);
			// Use the context in your program
			SCABeanRemote scaBean = null;
			scaBean = (SCABeanRemote) ctx.lookup("sca-ear-sca-ejb-SCABean#model.bean.SCABeanRemote");
			scaBean.criarUsuario(new Long(args[1]), args[2], args[3], args[4]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ctx.close();
			} catch (Exception e) {
				// a failure occurred
				e.printStackTrace();
			}
		}


	}

}
