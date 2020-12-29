package org.knowm.xchange.binance;

import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.*;
import org.knowm.xchange.binance.dto.trade.*;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 需要认证的接口
 * @author xingyu
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceAuthenticated extends Binance {

    String SIGNATURE = "signature";
    String X_MBX_APIKEY = "X-MBX-APIKEY";

    /**
     * 下单 (TRADE)
     *
     * @param symbol    交易对
     * @param side 买卖方向 SELL, BUY
     * @param type 订单类型 LIMIT, MARKET, STOP, TAKE_PROFIT, STOP_MARKET, TAKE_PROFIT_MARKET, TRAILING_STOP_MARKET
     * @param timeInForce
     * @param quantity
     * @param price 可选，必须仅提供限价订单
     * @param newClientOrderId 客户自定义的唯一订单ID。 如果未发送，则自动生成
     * @param stopPrice 可选，与止损单一起使用
     * @param icebergQty 可选，与冰山订单一起使用
     * @param recvWindow 	赋值不能大于 60000
     * @param timestamp
     * @return BinanceNewOrder
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @POST
    @Path("api/v3/order")
    BinanceNewOrder newOrder(
            @FormParam("symbol") String symbol,
            @FormParam("side") OrderSide side,
            @FormParam("type") OrderType type,
            @FormParam("timeInForce") TimeInForce timeInForce,
            @FormParam("quantity") BigDecimal quantity,
            @FormParam("price") BigDecimal price,
            @FormParam("newClientOrderId") String newClientOrderId,
            @FormParam("stopPrice") BigDecimal stopPrice,
            @FormParam("icebergQty") BigDecimal icebergQty,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 测试下单 (TRADE)
     * 用于测试订单请求，但不会提交到撮合引擎
     *
     * @param symbol    交易对
     * @param side 买卖方向 SELL, BUY
     * @param type 订单类型 LIMIT, MARKET, STOP, TAKE_PROFIT, STOP_MARKET, TAKE_PROFIT_MARKET, TRAILING_STOP_MARKET
     * @param timeInForce
     * @param quantity
     * @param price
     * @param newClientOrderId 可选,, a unique id for the order. Automatically generated by
     *     default.
     * @param stopPrice 可选,, used with STOP orders
     * @param icebergQty 可选, used with icebergOrders
     * @param recvWindow 可选,
     * @param timestamp
     * @return Object
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @POST
    @Path("api/v3/order/test")
    Object testNewOrder(
            @FormParam("symbol") String symbol,
            @FormParam("side") OrderSide side,
            @FormParam("type") OrderType type,
            @FormParam("timeInForce") TimeInForce timeInForce,
            @FormParam("quantity") BigDecimal quantity,
            @FormParam("price") BigDecimal price,
            @FormParam("newClientOrderId") String newClientOrderId,
            @FormParam("stopPrice") BigDecimal stopPrice,
            @FormParam("icebergQty") BigDecimal icebergQty,
            @FormParam("recvWindow") Long recvWindow,
            @FormParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 查询订单 (USER_DATA)
     * 查询订单状态。
     *
     * @param symbol    交易对
     * @param orderId 可选,
     * @param origClientOrderId 可选,
     * @param recvWindow 可选, 赋值不得大于 60000
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return BinanceOrder
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("api/v3/order")
    BinanceOrder orderStatus(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") long orderId,
            @QueryParam("origClientOrderId") String origClientOrderId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 撤销订单 (TRADE)
     * 取消有效订单。
     * @param symbol    交易对
     * @param orderId 可选,
     * @param origClientOrderId 可选,
     * @param newClientOrderId 可选,用户自定义的本次撤销操作的ID(注意不是被撤销的订单的自定义ID)。如无指定会自动赋值
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return BinanceCancelledOrder
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @DELETE
    @Path("api/v3/order")
    BinanceCancelledOrder cancelOrder(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") long orderId,
            @QueryParam("origClientOrderId") String origClientOrderId,
            @QueryParam("newClientOrderId") String newClientOrderId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 撤销单一交易对的所有挂单 (TRADE)
     *
     * @param symbol    交易对
     * @param recvWindow 可选,
     * @param timestamp
     * @return List<BinanceCancelledOrder>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @DELETE
    @Path("api/v3/openOrders")
    List<BinanceCancelledOrder> cancelAllOpenOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 当前挂单 (USER_DATA)
     * 获取交易对的所有当前挂单， 请小心使用不带交易对参数的调用。
     *
     * @param symbol    交易对 可选,
     * @param recvWindow 可选,
     * @param timestamp
     * @return List<BinanceOrder>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("api/v3/openOrders")
    List<BinanceOrder> openOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 查询所有订单 (USER_DATA)
     *获取所有帐户订单； 有效，已取消或已完成。
     *
     * 如设置 orderId , 订单量将 >= orderId。否则将返回最新订单。
     * 一些历史订单 cummulativeQuoteQty < 0, 是指数据此时不存在。
     *
     * @param symbol    交易对
     * @param orderId 可选,
     * @param limit 可选,
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("api/v3/allOrders")
    List<BinanceOrder> allOrders(
            @QueryParam("symbol") String symbol,
            @QueryParam("orderId") Long orderId,
            @QueryParam("limit") Integer limit,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 账户信息 (USER_DATA)
     *
     * @param recvWindow 可选,
     * @param timestamp
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("api/v3/account")
    BinanceAccountInformation account(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 账户成交历史 (USER_DATA)
     *
     * @param symbol    交易对
     * @param startTime 可选,
     * @param endTime 可选,
     * @param limit 可选,, default 500; max 1000.
     * @param fromId 可选,, tradeId to fetch from. Default gets most recent trades.
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return List<BinanceTrade>
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("api/v3/myTrades")
    List<BinanceTrade> myTrades(
            @QueryParam("symbol") String symbol,
            @QueryParam("limit") Integer limit,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("fromId") Long fromId,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 提币
     * 提交提现请求。
     * @param asset
     * @param address
     * @param addressTag 可选, 某些币种例如 XRP,XMR 允许填写次级地址标签
     * @param amount
     * @param name 可选,, 地址的备注，填写该参数后会加入该币种的提现地址簿。地址簿上限为20，超出后会造成提现失败。地址中的空格需要encode成%20。
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @POST
    @Path("wapi/v3/withdraw.html")
    WithdrawRequest withdraw(
            @QueryParam("asset") String asset,
            @QueryParam("address") String address,
            @QueryParam("addressTag") String addressTag,
            @QueryParam("amount") BigDecimal amount,
            @QueryParam("name") String name,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 获取充值历史 (USER_DATA)
     *
     * @param asset 可选,
     * @param startTime 可选,
     * @param endTime 可选,
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return DepositList
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("wapi/v3/depositHistory.html")
    DepositList depositHistory(
            @QueryParam("asset") String asset,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;


    /**
     * 获取提币历史 (USER_DATA)
     *
     * @param asset 可选,
     * @param startTime 可选,
     * @param endTime 可选,
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("wapi/v3/withdrawHistory.html")
    WithdrawList withdrawHistory(
            @QueryParam("asset") String asset,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 小额资产转换BNB历史 (USER_DATA)
     *
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("/wapi/v3/userAssetDribbletLog.html")
    AssetDribbletLogResponse userAssetDribbletLog(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 资产利息记录 (USER_DATA)
     *
     * @param asset      可选,
     * @param startTime  可选,
     * @param endTime    可选,
     * @param recvWindow 可选,
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("/sapi/v1/asset/assetDividend")
    AssetDividendResponse assetDividend(
            @QueryParam("asset") String asset,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 查询子账户现货资金划转历史 (适用主账户)
     *
     * @param email 子账户邮箱 备注 Email地址作为请求参数，需要转译(encode)。比如 alice@test.com 转换成 alice%40test.com
     * @param startTime 默认返回100天内历史记录
     * @param endTime 默认返回100天内历史记录
     * @param page
     * @param limit
     * @param recvWindow
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException
     * @throws BinanceException
     */
    @GET
    @Path("/wapi/v3/sub-account/transfer/history.html")
    TransferHistoryResponse transferHistory(
            @QueryParam("email") String email,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("page") Integer page,
            @QueryParam("limit") Integer limit,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("/sapi/v1/sub-account/transfer/subUserHistory")
    List<TransferSubUserHistory> transferSubUserHistory(
            @QueryParam("asset") String asset,
            @QueryParam("type") Integer type,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime,
            @QueryParam("limit") Integer limit,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    @GET
    @Path("wapi/v3/depositAddress.html")
    /**
     * Fetch deposit address.
     *
     * @param asset
     * @param recvWindow
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    DepositAddress depositAddress(
            @QueryParam("asset") String asset,
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * 上架资产详情 (USER_DATA)
     *
     * @param recvWindow
     * @param timestamp
     * @param apiKey
     * @param signature
     * @return
     * @throws IOException IOException
     * @throws BinanceException BinanceException
     */
    @GET
    @Path("wapi/v3/assetDetail.html")
    AssetDetailResponse assetDetail(
            @QueryParam("recvWindow") Long recvWindow,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
            @HeaderParam(X_MBX_APIKEY) String apiKey,
            @QueryParam(SIGNATURE) ParamsDigest signature)
            throws IOException, BinanceException;

    /**
     * Returns a listen key for websocket login.
     *
     * @param apiKey the api key
     * @return
     * @throws BinanceException BinanceException
     * @throws IOException IOException
     */
    @POST
    @Path("/api/v3/userDataStream")
    BinanceListenKey startUserDataStream(@HeaderParam(X_MBX_APIKEY) String apiKey)
            throws IOException, BinanceException;

    /**
     * Keeps the authenticated websocket session alive.
     *
     * @param apiKey    the api key
     * @param listenKey the api secret
     * @return
     * @throws BinanceException BinanceException
     * @throws IOException IOException
     */
    @PUT
    @Path("/api/v3/userDataStream?listenKey={listenKey}")
    Map<?, ?> keepAliveUserDataStream(
            @HeaderParam(X_MBX_APIKEY) String apiKey, @PathParam("listenKey") String listenKey)
            throws IOException, BinanceException;

    /**
     * Closes the websocket authenticated connection.
     *
     * @param apiKey    the api key
     * @param listenKey the api secret
     * @return
     * @throws BinanceException BinanceException
     * @throws IOException IOException
     */
    @DELETE
    @Path("/api/v3/userDataStream?listenKey={listenKey}")
    Map<?, ?> closeUserDataStream(
            @HeaderParam(X_MBX_APIKEY) String apiKey, @PathParam("listenKey") String listenKey)
            throws IOException, BinanceException;
}
