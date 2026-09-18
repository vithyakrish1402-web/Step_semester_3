package inheritance.assigment_problems;

import java.util.Arrays;

public class LateFeeLedger {

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}
