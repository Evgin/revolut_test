package com.revolut.test.repository.impl;

import com.revolut.test.model.Account;
import com.revolut.test.util.ConnectionPerThreadManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ConnectionPerThreadManager.class})
public class AccountRepositoryImplTest2 {

    @Before
    public void setup() {
        PowerMockito.mockStatic(ConnectionPerThreadManager.class);
    }


    @Test
    public void testGetAllAccounts() throws Exception {

        final Statement statement = mock(Statement.class);
        final Connection connection = mock(Connection.class);
        final ResultSet rs = mock(ResultSet.class);

        when(ConnectionPerThreadManager.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(rs);

        when(rs.next()).thenReturn(true).thenReturn(false);
        when(rs.getLong("id")).thenReturn(1L);
        when(rs.getBigDecimal("amount")).thenReturn(BigDecimal.ONE);


        final AccountRepositoryImpl repository = new AccountRepositoryImpl();
        List<Account> accountList = repository.getAllAccounts();

        assertFalse(accountList.isEmpty());

        Account account = accountList.get(0);
        assertNotNull(account);
        assertEquals(1L, account.getId());
        assertEquals(BigDecimal.ONE, account.getAmount());

    }

    @Test
    public void testGetAllAccounts_throwsException() throws Exception {

        final Statement statement = mock(Statement.class);
        final Connection connection = mock(Connection.class);
        final ResultSet rs = mock(ResultSet.class);

        when(ConnectionPerThreadManager.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenThrow(SQLException.class);

        final AccountRepositoryImpl repository = new AccountRepositoryImpl();
        List<Account> accountList = repository.getAllAccounts();

        assertTrue(accountList.isEmpty());

    }

    @Test(expected = NullPointerException.class)
    public void testGetAllAccounts_throwNPE() throws Exception {


        when(ConnectionPerThreadManager.getConnection()).thenReturn(null);


        final AccountRepositoryImpl repository = new AccountRepositoryImpl();
        List<Account> accountList = repository.getAllAccounts();

    }


}