package com.poo;

import com.poo.banco.entity.Banco;
import com.poo.cliente.entity.Cliente;
import com.poo.conta.entities.Conta;
import com.poo.conta.entities.ContaCorrente;
import com.poo.conta.entities.ContaPoupanca;
import com.poo.conta.enums.TipoConta;
import com.poo.endereco.entity.Endereco;
import com.poo.infrastructure.exception.BankingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        Banco bank = new Banco();

        System.out.println("-------------------------------------GrowthBank-------------------------------------");
        do{
            System.out.println("1 - Create account");
            System.out.println("2 - Search account");
            System.out.println("3 - List accounts");
            System.out.println("4 - Deposit");
            System.out.println("5 - WithDrawn");
            System.out.println("6 - Transfer");
            System.out.println("7 - Transaction history");
            System.out.println("8 - Delete account");
            System.out.println("9 - Export accounts to CSV file");
            System.out.println("10 - Log out");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    try{
                        System.out.println("What's the type of your account? (CORRENTE/POUPANCA)");
                        TipoConta accountType = TipoConta.valueOf(sc.next().toUpperCase());

                        System.out.println("------------ Individul data ------------");
                        System.out.println("Enter your name: ");
                        String name = sc.next();
                        System.out.println("Enter your cpf: ");
                        String cpf = sc.next();
                        System.out.println("Enter your phone number: ");
                        String phone = sc.next();

                        System.out.println("------------ Address data ------------");
                        System.out.println("City: ");
                        String city = sc.next();
                        System.out.println("CEP: ");
                        Integer cep = sc.nextInt();
                        System.out.println("Street: ");
                        String street = sc.next();
                        System.out.println("State: ");
                        String state = sc.next();
                        System.out.println("House: ");
                        Integer house = sc.nextInt();

                        Endereco address = new Endereco(city, cep, street, state, house);
                        Cliente client = new Cliente(name, cpf, phone, address);

                        Integer accountId = (int) Math.floor(Math.random() * (100));
                        System.out.println("Your account Id is: " + accountId);

                        Float balance = 0.0f;

                        Conta newAccount; //nova instancia de conta
                        if (accountType.toString().equals("CORRENTE")){
                            newAccount = new ContaCorrente(client, accountId, balance, accountType);
                        } else{
                            newAccount = new ContaPoupanca(client, accountId, balance, accountType);
                        }
                        bank.addConta(newAccount);
                        System.out.println("Account created successfully!");
                    }catch (IllegalArgumentException e){
                        System.out.println("Invalid account type");
                    }catch (BankingException e){
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Enter your account's Id: ");
                    Integer searchAccountId = sc.nextInt();
                    bank.searchConta(searchAccountId);
                    break;
                case 3:
                    System.out.println("Listing all accounts:\n");
                    bank.listAccount();
                    break;
                case 4:
                    System.out.println("Enter your account ID: ");
                    int depositId = sc.nextInt();
                    System.out.println("Enter your deposit amount: ");
                    float deposit = sc.nextFloat();
                    for (Conta conta : bank.getAccounts()){
                        if(conta.getAccountId().equals(depositId)){
                            conta.deposit(deposit);
                            System.out.println("New balance: " + conta.getBalance());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter your account Id: ");
                    int withdrawId = sc.nextInt();
                    System.out.println("Enter your withdraw amount: ");
                    float withdraw = sc.nextFloat();
                    for (Conta conta : bank.getAccounts()){
                        if(conta.getAccountId().equals(withdrawId)){
                            conta.withdraw(withdraw);
                            System.out.println("New balance: " + conta.getBalance());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter your account Id: ");
                    Integer ownerId = sc.nextInt();
                    System.out.println("Recipient's ID: ");
                    Integer recipientId = sc.nextInt();

                    for(Conta ownerAccount : bank.getAccounts()){
                        if(ownerAccount.getAccountId().equals(ownerId)){
                            for (Conta recipientAccount : bank.getAccounts()){
                                if(recipientAccount.getAccountId().equals(recipientId)){
                                    System.out.println("Enter the transfer value: ");
                                    Float transferValue = sc.nextFloat();
                                    ownerAccount.transfer(ownerAccount, recipientAccount, transferValue);
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("--------------------- TRANSFER HISTORY ---------------------");
                    System.out.println("Enter the account Id: ");
                    Integer accountIdHistory = sc.nextInt();
                    for (Conta conta : bank.getAccounts()){
                        if(conta.getAccountId().equals(accountIdHistory)){
                            conta.listTransactionHistory();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Enter the account's Id: ");
                    Integer deleteId = sc.nextInt();
                    System.out.println("Are you sure do you want to delete this account? (Y/N)");
                    String choice = sc.next().toUpperCase();
                    if (choice.equals("Y")){
                        bank.deleteAccount(deleteId);
                    }else if(choice.equals("N")) {
                        System.out.println("Ok...");
                    }else {
                        System.out.println("Invalid option");
                    }
                    break;
                default:
                    System.out.println("Not valid option");
                    break;
            }
        }while(option != 0);
        sc.close();
    }
}