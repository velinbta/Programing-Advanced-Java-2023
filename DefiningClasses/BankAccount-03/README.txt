3. Bank Account
Create class BankAccount.

The class should have private fields for:
Id: int (Starts from 1 and increments for every new account)
Balance: double
Interest rate: double (Shared for all accounts. Default value: 0.02)

The class should also have public methods for:
setInterestRate(double interest): void (static)
getInterest(int years): double
deposit(double amount): void

Create a test client supporting the following commands:
Create
Deposit {Id} {Amount}
SetInterest {Interest}
GetInterest {ID} {Years}
End

Examples:

Input 1:
Create
Deposit 1 20
GetInterest 1 10
End

Output 1:
Account ID1 created
Deposited 20 to ID1
4.00

Input 2:
Create
Create
Deposit 1 20
Deposit 3 20
Deposit 2 10
SetInterest 1.5
GetInterest 1 1
GetInterest 2 1
GetInterest 3 1
End

Output 2:
Account ID1 created
Account ID2 created
Deposited 20 to ID1
Account does not exist
Deposited 10 to ID2
30.00
15.00
Account does not exist

Input 3:
Create
Deposit 1 200
Deposit 1 300
SetInterest 1
GetInterest 1 10
GetInterest 2 1
End

Output 3:
Account ID1 created
Deposited 200 to ID1
Deposited 300 to ID1
5000.00
Account does not exist