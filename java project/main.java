import java.util.Scanner;

public class main {
    static String[] name = new String[50];// static used for global declaration i.e used in function anywhere of that class in program
    static String[] pswrd = new String[50];

    static long[] account = new long[50];
    static int record = -1;  // if no login then initialize -1 , array me start 0 se hota h so  n-1 tk jayega 

    
    static boolean login = false;
    static long[] balance = new long[50];
    static int idx;  // idx joo login kiya uska index
    
          // login section
    static void new_login() {

        System.out.println("Enter name: ");
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        System.out.println("Enter password:");
        String psw = sc.nextLine();
        record++;
        name[record] = nm;
        pswrd[record] = psw;
        System.out.println(" \n\nYour account number is " + (823456 + record));// we give acc no by ourside
        account[record] = 823456 + record;
        System.out.println("You have succesfully created your account ");
    }

    public static void old_login() {
        if (record != -1) {
            System.out.println("\n\nEnter your existing account number: ");
            Scanner sc = new Scanner(System.in);
            long accNo = sc.nextLong();
            System.out.println("Enter your password : ");
            String psw = sc.next();
            int j = 0;
            int p = 0;
            while (j <= record) {
                if (account[j] == accNo && pswrd[j].equals(psw)) {
                    login = true;
                    idx = j;
                    p++;
                }
                j++;
            }
            if (p == 0) {
                System.out.println("Your account doesn't exist ");
            }

        } else {
            System.out.println("You have no existing data ");
        }
    }

    static void deposit() {

        System.out.println("Enter the amount you want to diposit");
        Scanner sc = new Scanner(System.in);
        long amount = sc.nextLong();
        if (amount > 0){
            balance[idx] = amount + balance[idx]; // phle se kuchh balance hoga 
            // why choose idx why not record ?? record wale me svi me add hoga 
            //  idx me login aur pss dono match krega to hm us particular insaan ka idx pta chalega


            System.out.println("Your balance is succesfully deposited ");
        } else {
            System.out.println("Please enter the valid amount ");// for entering -ve amount
        }

    }

    static void check_balance() {
        System.out.println("\n\nYour balance is " + balance[idx]); // display balance1
    }

    static void withdraw_money() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw ");
        long n = sc.nextLong();
        if (n > 0) { // if n<0 then balance cannot be withdraw it should be deposit .... balance[idx]
                     // -(-n)
            if (balance[idx] >= n) {
                balance[idx] = balance[idx] - n;
                System.out.println("\n\nSuccessfully Withdrawl \n Your current amount is:  " + balance[idx]);
            } else {
                System.out.println("Insufficient balance ");
            }
        } else {
            System.out.println("Please check your entered amount ");
        }

    }


    //   transaction section & delete an acc 

    


// record > 1 for transaction km se km 2
//     bhejne wale ka login 
//     acc no + loop for acc  no exist store indx
//     add index money on that index
//     jiska login h uska - kr denge 

static void transaction(){
    if(record<1){  
//   for 2 accont <1 means 0 & !
     System.out.println("Some error Occured");
       return;
    }
    int store_i = -1; // to get index for which balance has to be checked
    Scanner sc = new Scanner( System.in);
    System.out.println("Enter the account no: ");
    long n = sc.nextLong();
    int i = 0;
    for(;i<=record;i++) {
        if(n == account[i]){
             store_i =i;
             break;
        }
    }
    
     if(i>record) {
         System.out.println("doesn't exist your account");
         return; //wps usi fnc me chale jana jha se call hua tha ... void so no return type

     }
     System.out.println("Enter the amount of transaction ");
     int amt = sc.nextInt();
     if(balance[idx]>amt && amt>0){
     balance[idx] = balance[idx] - amt;
     balance[store_i] = balance[store_i] +amt ;
     System.out.println("Your transaction is succesfully completed");
     }else{
        System.out.println("Insufficient balance");
     }

}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" \n\n\n\t\t\t\t\t\t\t\t Welcome to our Hera pherry bank ");// emoji
        while (login != true) {

            System.out.println("\n\nfor Creating your account press  1");
            System.out.println("for logging account press  2");
            int choice = sc.nextInt();
            if (choice == 1) {
                new_login();
            } else if (choice == 2) {
                old_login();
            }
        }
        System.out.println("You have succesfully logged in ");
        while (true) {         // infinite loop - to repeat the option for deposit money
            System.out.println(" \n \n\n\n Press 0 for exit ");
            System.out.println(" Press 1 for deposit money  ");
            System.out.println(" Press 2 for checking balance ");
            System.out.println(" press 3 for withdraw money \n");
            System.out.println(" press 4 for transaction \n");
            
            int n = sc.nextInt();
            if (n == 1) {
                deposit();
            }
            if (n == 0)
                break;
            if (n == 2)
                check_balance();
            if (n == 3)
                withdraw_money();
            if(n == 4)
                 transaction();
        }

    }
}