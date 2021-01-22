package com.accenture.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.api.service.AccountsService;
import com.accenture.model.Account;
import com.accenture.model.Error;
import com.accenture.model.User;

@Component
class AccountsApiDelegateImpl implements V1ApiDelegate {
	@Autowired
	AccountsService service;

	@Override
	public ResponseEntity<Account> v1AccountsUserIdGet(Integer userId) {
		Account account = new Account();
		User user = service.getUser(userId);
		if (user != null) {
			account.setId(userId);
			account.setUser(user);
		}else {
			account.setId(userId);
			Error error = new Error();
			error.setCode(001);
			error.setMessage("Account " + userId + " not found.");
			account.setError(error);
			return new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
}
