package s3.ws;

import java.util.List;

public interface AccountService {
	void insertAccount(Account account);
	List<Account> getAccounts(String name);
}