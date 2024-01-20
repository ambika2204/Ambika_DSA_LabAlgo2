import paymoney.dailytarget.DailyTargetService.DailyTargetDeterminer;

public class Main {
    public static void main(String[] args) {
        DailyTargetDeterminer dailyTargetDeterminer = new DailyTargetDeterminer();
        int[] dailyTransacVal = dailyTargetDeterminer.getDailyTransactionValues();
        int targetVal = dailyTargetDeterminer.getDailyTargetValue();
        dailyTargetDeterminer.determineTargetCompletion(dailyTransacVal, targetVal);
    }
}