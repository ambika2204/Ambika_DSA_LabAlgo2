package paymoney.dailytarget.DailyTargetService;

import java.util.Scanner;

public class DailyTargetDeterminer {

    Scanner scanner = new Scanner(System.in);
    int[] dailyTransaction;
    int dailyTarget;

    public int[] getDailyTransactionValues() {
        int i = 0;
        System.out.println("Enter the number of transactions.");
        int noOfTransaction = scanner.nextInt();
        dailyTransaction = new int[noOfTransaction];
        System.out.println("Enter the values for " + noOfTransaction + " transactions.");
        for (int transactionVal : dailyTransaction) {
            System.out.println("Transaction value " + (i + 1) + "/" + noOfTransaction);
            dailyTransaction[i] = scanner.nextInt();
            i++;
        }
        return dailyTransaction;
    }

    public int getDailyTargetValue() {
        System.out.println("Enter the target value.");
        dailyTarget = scanner.nextInt();
        return dailyTarget;
    }

    public void determineTargetCompletion(int[] dailyTransaction, int targetValue) {

        boolean isTargetAchieved = false;
        int transactionSum = 0;

        for (int j = 0; j < dailyTransaction.length; j++) {
            if (dailyTransaction[j] >= targetValue || transactionSum >= targetValue) {
                System.out.println("Target is completed after " + (j + 1) + " transaction.");
                isTargetAchieved = true;
                break;
            } else if (isTargetAchieved) {
                transactionSum = transactionSum + dailyTransaction[j];
                if (transactionSum >= dailyTarget) {
                    isTargetAchieved = true;
                    System.out.println("Target is completed after " + (j + 1) + " transaction.");
                    break;
                }
            }
        }
        if (!isTargetAchieved) {
            System.out.println("Target ios not completed.");
        }
    }
}
