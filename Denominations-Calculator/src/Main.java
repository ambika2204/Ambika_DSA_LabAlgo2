import denomimationCalculationService.DenominationCalculator;

public class Main {
    public static void main(String[] args) {
        DenominationCalculator denominationCalculator = new DenominationCalculator();
        Integer[] denominations = denominationCalculator.getDenominations();
        int paymentAmount = denominationCalculator.getPayableAmount();
        denominationCalculator.calculate(denominations, paymentAmount);
    }
}