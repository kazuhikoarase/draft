package s3.ws.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import s3.ws.Account;
import s3.ws.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	private List<Account> accounts = new ArrayList<Account>();
	public void insertAccount(Account acc) {
		accounts.add(acc);
	}
	public List<Account> getAccounts(String name) {
		List<Account> result = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (acc.getName().indexOf(name) != -1) {
				result.add(acc);
			}
		}
		return result;
	}
}

