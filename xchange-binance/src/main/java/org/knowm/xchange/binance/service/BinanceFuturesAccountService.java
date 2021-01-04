package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.BinanceFuturesAuthenticated;
import org.knowm.xchange.binance.BinanceFuturesExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.dto.account.FundingRecord.Status;
import org.knowm.xchange.service.account.AccountService;

public class BinanceFuturesAccountService extends BinanceFuturesAccountServiceRaw implements AccountService {

    public BinanceFuturesAccountService(
            BinanceFuturesExchange exchange,
            BinanceFuturesAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    /**
     * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6Completed)
     */
    private static Status withdrawStatus(int status) {
        switch (status) {
            case 0:
            case 2:
            case 4:
                return Status.PROCESSING;
            case 1:
                return Status.CANCELLED;
            case 3:
            case 5:
                return Status.FAILED;
            case 6:
                return Status.COMPLETE;
            default:
                throw new RuntimeException("Unknown binance withdraw status: " + status);
        }
    }

}
