package model.entities;

import excepitions.BusinessException;

public class Account {

  private Integer number;
  private String holder;
  private Double balance;
  private Double withdrawLimit;

  public Account() {}

  public Account(
    Integer number,
    String holder,
    Double balance,
    Double withdrawLimit
  ) {
    this.number = number;
    this.holder = holder;
    this.balance = balance;
    this.withdrawLimit = withdrawLimit;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getHolder() {
    return holder;
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Double getWithdrawLimit() {
    return withdrawLimit;
  }

  public void setWithdrawLimit(Double withdrawLimit) {
    this.withdrawLimit = withdrawLimit;
  }

  //==============================================================
  public void deposit(Double amount) {
    balance += amount;
  }

  public void withdraw(Double amount) {
    validateWithdraw(amount);
    balance -= amount;
  }

  // esse esquema de criar exceçoes personalizadas isso e bom para capturar
  //exceçoes espesificas dependendo de tratamentos diferentes que quiser dar
  private void validateWithdraw(double amount) {
    if (amount > getWithdrawLimit()) {
      throw new BusinessException(
        "Erro de saque: A quantia excede o limite de saque!"
      );
    }
    if (amount > getBalance()) {
      throw new BusinessException("Erro de saque: Saldo insificiente!");
      //olha que legal a minha exceçao e um void ela simplesmente lança exceçao se acontecer algum erro se nao lança nada
    }
  }
}
