package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.BinanceFuturesAuthenticated;
import org.knowm.xchange.binance.BinanceFuturesExchange;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeFuturesInfo;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.BaseResilientExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;

/**
 * @author xingyu
 */
public class BinanceFuturesBaseService extends BaseResilientExchangeService<BinanceFuturesExchange> {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected final String apiKey;
    protected final BinanceFuturesAuthenticated binance;
    protected final ParamsDigest signatureCreator;

    protected BinanceFuturesBaseService(
            BinanceFuturesExchange exchange,
            BinanceFuturesAuthenticated binance,
            ResilienceRegistries resilienceRegistries) {

        super(exchange, resilienceRegistries);
        this.binance = binance;
        this.apiKey = exchange.getExchangeSpecification().getApiKey();
        this.signatureCreator =
                BinanceHmacDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    }

    public Long getRecvWindow() {
        return (Long)
                exchange.getExchangeSpecification().getExchangeSpecificParametersItem("recvWindow");
    }

    public SynchronizedValueFactory<Long> getTimestampFactory() {
        return exchange.getTimestampFactory();
    }

    public BinanceExchangeFuturesInfo getExchangeInfo() throws IOException {
        return decorateApiCall(binance::exchangeInfo)
                .withRetry(retry("exchangeInfo"))
                .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
                .call();
    }
}
