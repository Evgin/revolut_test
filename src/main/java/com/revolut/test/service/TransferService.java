package com.revolut.test.service;

import com.revolut.test.dto.AccountRequest;
import com.revolut.test.dto.AccountResponse;

public interface TransferService {

    /**
     * Method for transfer money
     *
     * @param request {@link AccountRequest}
     * @return {@link AccountResponse}
     */
    AccountResponse transferMoney(AccountRequest request);
}
