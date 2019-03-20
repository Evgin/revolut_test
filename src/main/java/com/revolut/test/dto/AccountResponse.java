package com.revolut.test.dto;

import java.math.BigDecimal;

/**
 * Ответ по переводу средств
 */
public class AccountResponse {

    /**
     * Номер счета с которого был выполнен перевод
     */
    private long accountNumberTo;

    /**
     * Номер счета на который был выполнен перевод
     */
    private long accountNumberFrom;

    /**
     * Количество средств на аккаунте с короторого был выполнен перевод (остаток)
     */
    private BigDecimal accountAmountTo;

    /**
     * Количество средств на аккаунте куда был выполнен перевод
     */
    private BigDecimal accountAmountFrom;

    /**
     * Сумма перевода
     */
    private BigDecimal transferAmount;

    /**
     * Цель платежа
     */
    private String paymentPurpose;

    /**
     * причина отказа
     */
    private String rejectionReason;

    public long getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(long accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public BigDecimal getAccountAmountTo() {
        return accountAmountTo;
    }

    public void setAccountAmountTo(BigDecimal accountAmountTo) {
        this.accountAmountTo = accountAmountTo;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public long getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(long accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public BigDecimal getAccountAmountFrom() {
        return accountAmountFrom;
    }

    public void setAccountAmountFrom(BigDecimal accountAmountFrom) {
        this.accountAmountFrom = accountAmountFrom;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "accountNumberTo=" + accountNumberTo +
                ", accountNumberFrom=" + accountNumberFrom +
                ", accountAmountTo=" + accountAmountTo +
                ", accountAmountFrom=" + accountAmountFrom +
                ", transferAmount=" + transferAmount +
                ", paymentPurpose='" + paymentPurpose + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }

}
