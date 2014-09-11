package s3.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName="AccountService",
	targetNamespace="http://ws.example.com/AccountService")
@SOAPBinding(style=Style.RPC,use=Use.LITERAL)
public class AccountServiceEndpoint 
/*extends SpringBeanAutowiringSupport */ {
	@Autowired
	private AccountService accountService;
	@WebMethod
	public void insertAccount(Account acc) {
		accountService.insertAccount(acc);
	}
	@WebMethod
	public Account[] getAccounts(String name) {
		List<Account> accounts = accountService.getAccounts(name);
		return accounts.toArray(new Account[accounts.size()]);
	}
}
