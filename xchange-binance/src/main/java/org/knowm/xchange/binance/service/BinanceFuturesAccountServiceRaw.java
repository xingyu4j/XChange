package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.BinanceFuturesAuthenticated;
import org.knowm.xchange.binance.BinanceFuturesExchange;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.BinanceFuturesAccountInformation;
import org.knowm.xchange.client.ResilienceRegistries;

import java.io.IOException;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;

public class BinanceFuturesAccountServiceRaw extends BinanceFuturesBaseService {

    public BinanceFuturesAccountServiceRaw(
            BinanceFuturesExchange exchange,
            BinanceFuturesAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {
        super(exchange, binance, resilienceRegistries);
    }

    public BinanceFuturesAccountInformation account() throws BinanceException, IOException {
        return decorateApiCall(
                () -> binance.account(getRecvWindow(), getTimestampFactory(), apiKey, signatureCreator))
                .withRetry(retry("account"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER), 5)
                .call();
    }

    // the /wapi endpoint of binance is not stable yet and can be changed in future, there is also a
    // lack of current documentation

}
