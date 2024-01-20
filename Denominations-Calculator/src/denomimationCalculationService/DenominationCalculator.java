package denomimationCalculationService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DenominationCalculator {

    public int noOfDenominationsAvailable;
    public int payableAmt;
    public Integer[] denominationValue;
    Scanner scanner = new Scanner(System.in);

    public Integer[] getDenominations() {
        int i = 0;
        System.out.println("enter the number of denominations available.");
        noOfDenominationsAvailable = scanner.nextInt();
        denominationValue = new Integer[noOfDenominationsAvailable];
        System.out.println("Enter the denomination values");
        for (Integer denomination : denominationValue) {
            System.out.println("Denomination " + (i + 1) + "/" + noOfDenominationsAvailable);
            denominationValue[i] = scanner.nextInt();
            i++;
        }
        return denominationValue;
    }

    public int getPayableAmount() {
        System.out.println("Enter the payable amount");
        payableAmt = scanner.nextInt();
        return payableAmt;
    }

    public void calculate(Integer[] denominations, int paymentAmount) {
        Arrays.sort(denominations, Collections.reverseOrder());
        int denominationIndex = 0;
        Integer balanceAmount = 0;
        int tempPayableAmt = paymentAmount;
        boolean exactDenominationsSupplied = false;

        while (denominationIndex < denominations.length) {
            Integer denomination = denominations[denominationIndex];
            Integer noOfTimesDenominations = tempPayableAmt / denomination;
            balanceAmount = tempPayableAmt % denomination;

            if (noOfTimesDenominations != 0) {
                System.out.println("Denomination : " + denomination + "NoOfTimes : " + noOfTimesDenominations);
            }

            if (balanceAmount == 0) {
                exactDenominationsSupplied = true;
            }
            tempPayableAmt = balanceAmount;
            denominationIndex++;
        }

        if (exactDenominationsSupplied) {
            System.out.println("Able to provide the exact denominations");
        } else {
            System.out.println("Unable to provide the exact denominations");
            System.out.println("Balance Amount " + balanceAmount);
        }
    }
}