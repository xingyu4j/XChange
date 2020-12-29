package org.knowm.xchange;

import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.instrument.Instrument;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 为应用程序提供以下内容的接口：
 *
 * <ul>
 *   <li>XChange API的入口点
 * </ul>
 *
 * <p>使用者可以选择默认值（无参数）或配置的访问器
 */
public interface Exchange {

    /**
     * @return 用于此交换的Exchange规范
     */
    ExchangeSpecification getExchangeSpecification();

    /**
     * 元数据定义了交易所的一些半静态属性，例如货币对，交易费用等。
     *
     * @return The exchange's meta data
     */
    ExchangeMetaData getExchangeMetaData();

    /**
     * 返回CurrencyPair对象的列表。
     * 如果实现重写了`remoteInit`方法，则此列表可以最初来自加载的json文件，也可以来自远程调用。
     *
     * @return The exchange's symbols
     */
    List<CurrencyPair> getExchangeSymbols();

    /**
     * 返回Instrument对象的列表。
     * 如果实现重写了`remoteInit`方法，则此列表可以最初来自加载的json文件，也可以来自远程调用。
     *
     * @return 交易所的工具
     */
    default List<Instrument> getExchangeInstruments() {
        return new ArrayList<>(getExchangeSymbols());
    }

    /**
     * 随机数工厂用于创建随机数值。
     * 允许服务接受一个占位符，该占位符将在序列化和发送消息之前被生成的值替换。
     * 如果rest方法接受ValueFactory作为参数，则会对其进行评估，然后将消息序列化并在单个同步块中发送。
     *
     * @return 同步值工厂
     */
    SynchronizedValueFactory<Long> getNonceFactory();

    /**
     * 用于此交换的具有重试策略，速率限制器等的resilience4j注册中心。
     *
     * @return 弹性4j注册表
     * @throws NotYetImplementedForExchangeException 如果交换模块不支持弹性功能
     */
    default ResilienceRegistries getResilienceRegistries() {
        throw new NotYetImplementedForExchangeException();
    }

    /**
     * @return 如果没有创建，则在创建过程中使用的默认ExchangeSpecification
     * supplied
     */
    ExchangeSpecification getDefaultExchangeSpecification();

    /**
     * 应用任何特定于交易所的参数
     *
     * @param exchangeSpecification The {@link ExchangeSpecification}
     */
    void applySpecification(ExchangeSpecification exchangeSpecification);

    /**
     * 市场数据服务通常包括各种符号可用价格的定期更新列表
     *
     * <p>这是服务的非流式传输（阻止）版本
     *
     * @return 交易所的市场数据服务
     */
    MarketDataService getMarketDataService();

    /**
     * 交易服务通常提供对交易功能的访问
     *
     * <p>通常，访问权限受秘密API密钥和/或用户名密码身份验证的限制，通常会在{@link ExchangeSpecification}
     *
     * @return The exchange's trade service
     */
    TradeService getTradeService();

    /**
     * An account service typically provides access to the user's private exchange data
     *
     * <p>Typically access is restricted by a secret API key and/or username password authentication
     * which are usually provided in the {@link ExchangeSpecification}
     *
     * @return The exchange's account service
     */
    AccountService getAccountService();

    /**
     * Initialize this instance with the remote meta data. Most exchanges require this method to be
     * called before {@link #getExchangeMetaData()}. Some exchanges require it before using some of
     * their services.
     */
    void remoteInit() throws IOException, ExchangeException;
}
