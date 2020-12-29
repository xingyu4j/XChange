package org.knowm.xchange.binance;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.*;
import org.knowm.xchange.binance.dto.meta.BinanceTime;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeFuturesInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * @author xingyu
 * @Description 币安合约
 * @date 2020-12-29 15:22
 **/
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceFutures {
    /**
     * 测试服务器连通性
     *
     * @return Object
     * @throws IOException IOException
     */
    @GET
    @Path("fapi/v1/ping")
    Object ping() throws IOException;

    /**
     * 获取服务器时间
     * 测试能否联通 Rest API 并 获取服务器时间。
     * @return BinanceTime
     * @throws IOException IOException
     */
    @GET
    @Path("fapi/v1/time")
    BinanceTime time() throws IOException;

    /**
     * 交易规范信息
     *
     * @return BinanceExchangeInfo
     * @throws IOException IOException
     */
    @GET
    @Path("fapi/v1/exchangeInfo")
    BinanceExchangeFuturesInfo exchangeInfo() throws IOException;
    /**
     * 深度信息
     * @param symbol    交易对
     * @param limit 可选, default 100 max 5000. Valid limits: [5, 10, 20, 50, 100, 500, 1000,
     *     5000]
     * @return BinanceOrderbook
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/depth")
    BinanceOrderbook depth(@QueryParam("symbol") String symbol, @QueryParam("limit") Integer limit)
            throws IOException, BinanceException;

    /**
     * 近期成交(归集)
     * 归集交易与逐笔交易的区别在于，同一价格、同一方向、同一时间的trade会被聚合为一条
     * 如果发送startTime和endTime，间隔必须小于一小时。
     * 如果没有发送任何筛选参数(fromId, startTime,endTime)，默认返回最近的成交记录
     *
     * @param symbol    交易对
     * @param limit 可选, 默认 500; 最大 1000.
     * @return  List<BinanceAggTrades>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/trades")
    List<BinanceAggTrades> aggTrades(
            @QueryParam("symbol") String symbol,
            @QueryParam("limit") Integer limit)
            throws IOException, BinanceException;

    /**
     * K线数据
     *
     * 每根K线代表一个交易对。
     * 每根K线的开盘时间可视为唯一ID
     * 如果未发送 startTime 和 endTime ，默认返回最近的交易。
     * @param symbol    交易对
     * @param interval 时间间隔
     * @param limit 可选, default 500; max 500.
     * @param startTime 可选,
     * @param endTime 可选,
     * @return K线数据
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/klines")
    List<Object[]> klines(
            @QueryParam("symbol") String symbol,
            @QueryParam("interval") String interval,
            @QueryParam("limit") Integer limit,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime)
            throws IOException, BinanceException;

    /**
     * 24hr 价格变动情况
     * 24 小时滚动窗口价格变动数据。 请注意，不携带symbol参数会返回全部交易对数据，不仅数据庞大，而且权重极高
     *
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/ticker/24hr")
    List<BinanceFuturesTicker24h> ticker24h() throws IOException, BinanceException;

    /**
     * 24hr 价格变动情况
     *
     * @param symbol    交易对
     * @return BinanceTicker24h
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/ticker/24hr")
    BinanceFuturesTicker24h ticker24h(@QueryParam("symbol") String symbol)
            throws IOException, BinanceException;


    /**
     * 最新价格
     * 获取交易对最新价格
     * @return BinancePrice
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/ticker/price")
    BinanceFuturesPrice tickerPrice(@QueryParam("symbol") String symbol)
            throws IOException, BinanceException;


    /**
     * 最新价格
     * 不发送交易对参数，则会返回所有交易对信息
     *
     * @return List<BinancePrice>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/ticker/price")
    List<BinanceFuturesPrice> tickerAllPrices() throws IOException, BinanceException;


    /**
     * 当前最优挂单
     *
     * @return List<BinancePriceQuantity>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("fapi/v1/ticker/bookTicker")
    List<BinanceFuturesPriceQuantity> tickerAllBookTickers() throws IOException, BinanceException;
}
