package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class AIBMain extends CoinType {
    private AIBMain() {
        id = "aib.main";

        addressHeader = 23;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 176;

        family = BitFamily.get();
        name = "AIB Bond";
        symbol = "AIB";
        uriScheme = "aibond";
        bip44Index = 2;   //// TODO: 2015/10/18  apply bip44
        unitExponent = 8;
        feePerKb = value(100000);
        minNonDust = value(1000); // 0.00001 AIB mininput
        softDustLimit = value(100000); // 0.001 AIB
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Asian Investment Bond Signed Message:\n");
    }

    private static AIBMain instance = new AIBMain();
    public static synchronized AIBMain get() {
        return instance;
    }
}
