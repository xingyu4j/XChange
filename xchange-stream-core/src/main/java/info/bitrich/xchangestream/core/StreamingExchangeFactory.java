package info.bitrich.xchangestream.core;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.utils.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工厂提供以下内容 {@link StreamingExchange}:
 *
 * <ul>
 *   <li>使用运行时依赖项管理特定交易所实现的创建
 * </ul>
 */
public enum StreamingExchangeFactory {
  /**
   * 实例
   */
    INSTANCE;


    private final Logger LOG = LoggerFactory.getLogger(ExchangeFactory.class);

    /**
     * Constructor
     */
    private StreamingExchangeFactory() {
    }

    /**
     * 创建没有默认ExchangeSpecification的Exchange对象
     *
     * <p>使用交换实现类的名称对工厂进行参数化。 这必须是扩展的类 {@link org.knowm.xchange.Exchange}.
     *
     * @param exchangeClassName the fully-qualified class name of the exchange
     * @return 使用默认配置的新交换实例 {@link
     * org.knowm.xchange.ExchangeSpecification}
     */
    public StreamingExchange createExchangeWithoutSpecification(String exchangeClassName) {

        Assert.notNull(exchangeClassName, "exchangeClassName cannot be null");

        LOG.debug("Creating default exchange from class name");

        final Class<? extends StreamingExchange> exchangeClass =
                exchangeClassForName(exchangeClassName);
        return createExchangeWithoutSpecification(exchangeClass);
    }

    private static Class<? extends StreamingExchange> exchangeClassForName(String exchangeClassName) {
        // 尝试创建交换提供程序的实例
        try {

            // 尝试在类路径上找到交换提供者
            Class<?> exchangeProviderClass = Class.forName(exchangeClassName);

            // 测试该类实现Exchange
            if (StreamingExchange.class.isAssignableFrom(exchangeProviderClass)) {
                return (Class<? extends StreamingExchange>) exchangeProviderClass;
            } else {
                throw new ExchangeException(
                        "Class '" + exchangeClassName + "' does not implement Exchange");
            }
        } catch (ReflectiveOperationException e) {
            throw new ExchangeException("Problem creating Exchange ", e);
        }
    }

    public StreamingExchange createExchangeWithoutSpecification(
            Class<? extends StreamingExchange> exchangeClass) {
        Assert.notNull(exchangeClass, "exchangeClass cannot be null");
        LOG.debug("Creating default exchange from class name");

        // 尝试创建交换提供程序的实例
        try {
            // 通过默认构造函数实例化并使用默认交换规范
            return exchangeClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new ExchangeException(
                    "Problem creating Exchange for class: " + exchangeClass.getName(), e);
        }
    }

    /**
     * 创建具有默认ExchangeSpecification的交易所对象
     *
     * <p>使用交换实现类的名称对工厂进行参数化。 这必须是扩展的类 {@link org.knowm.xchange.Exchange}.
     *
     * @param exchangeClassName the fully-qualified class name of the exchange
     * @return a new exchange instance configured with the default {@link
     * org.knowm.xchange.ExchangeSpecification}
     * @see this#createExchange(Class) Use createExchange by class for better performance
     */
    public StreamingExchange createExchange(String exchangeClassName) {

        Assert.notNull(exchangeClassName, "exchangeClassName cannot be null");

        LOG.debug("Creating default exchange from class name");

        StreamingExchange exchange = createExchangeWithoutSpecification(exchangeClassName);
        exchange.applySpecification(exchange.getDefaultExchangeSpecification());
        return exchange;
    }

    /**
     * 创建具有默认ExchangeSpecification的Exchange对象
     *
     * <p>The factory is parameterised with the name of the exchange implementation class. This must
     * be a class extending {@link org.knowm.xchange.Exchange}.
     *
     * @param exchangeClass the exchange to create
     * @return a new exchange instance configured with the default {@link
     * org.knowm.xchange.ExchangeSpecification}
     */
    public StreamingExchange createExchange(Class<? extends StreamingExchange> exchangeClass) {

        Assert.notNull(exchangeClass, "exchangeClass cannot be null");

        LOG.debug("Creating default exchange from class name");

        StreamingExchange exchange = createExchangeWithoutSpecification(exchangeClass);
        exchange.applySpecification(exchange.getDefaultExchangeSpecification());
        return exchange;
    }

    public StreamingExchange createExchange(ExchangeSpecification exchangeSpecification) {

        Assert.notNull(exchangeSpecification, "exchangeSpecfication cannot be null");

        LOG.debug("Creating exchange from specification");

        // Attempt to create an instance of the exchange provider
        Class<?> exchangeProviderClass = exchangeSpecification.getExchangeClass();
        try {
            // Test that the class implements Exchange
            if (Exchange.class.isAssignableFrom(exchangeProviderClass)) {
                // Instantiate through the default constructor
                StreamingExchange exchange =
                        (StreamingExchange) exchangeProviderClass.getConstructor().newInstance();
                exchange.applySpecification(exchangeSpecification);
                return exchange;
            } else {
                throw new ExchangeException(
                        "Class '" + exchangeProviderClass.getName() + "' does not implement Exchange");
            }
        } catch (ReflectiveOperationException e) {
            throw new ExchangeException("Problem starting exchange provider ", e);
        }

        // Cannot be here due to exceptions

    }
}
