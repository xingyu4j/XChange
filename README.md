## [![XChange](https://raw.githubusercontent.com/knowm/XChange/develop/etc/XChange_64_64.png)](http://knowm.org/open-source/xchange) XChange

[![Discord](https://img.shields.io/discord/778301671302365256?logo=Discord)](https://discord.gg/n27zjVTbDz)
![Build Status develop](https://img.shields.io/travis/knowm/XChange/develop?label=develop)

XChange是一个Java库，提供了一个简单且一致的API，可与60多个比特币和其他加密货币交易所进行交互，从而为交易和访问市场数据提供了一致的接口。
## Important!

比特币的世界瞬息万变，XChange也不例外。 对于最新的错误修复和功能，您应该使用[快照罐]（https://oss.sonatype.org/content/groups/public/org/knowm/xchange/）或从“开发”分支进行构建。 有关使用Maven进行构建的更多详细信息，请参见下文。 要报告错误并查看人们当前正在处理的问题，请参阅[问题页面]（https://github.com/knowm/XChange/issues）。
## Description

XChange是一个提供简单且一致的API的库，用于与各种加密货币交易所进行交互。

基本用法非常简单：创建一个“ Exchange”实例，获取适当的服务，并请求数据。 下面将逐步详细介绍更复杂的用法。

## Example 1: Public Market Data

```java
Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class);
MarketDataService marketDataService = bitstamp.getMarketDataService();
Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
System.out.println(ticker.toString());
```

## Example 2: Private Account Info

要使用需要身份验证的API，请ExchangeSpecification使用您的API凭据创建一个，并将其传递给createExchange()。例：
```java
ExchangeSpecification exSpec = new BitstampExchange().getDefaultExchangeSpecification();
exSpec.setUserName("34387");
exSpec.setApiKey("a4SDmpl9s6xWJS5fkKRT6yn41vXuY0AM");
exSpec.setSecretKey("sisJixU6Xd0d1yr6w02EHCb9UwYzTNuj");
Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(exSpec);
```

注意：大多数交易所使用API​​密钥和秘密密钥，而其他交易所（例如Bitstamp上的用户名或Coinbase Pro上的密码）则是特定于交易所的。有关将密钥添加到的更多示例ExchangeSpecification，包括将密钥存储在配置文件中，请参阅“常见问题”。

获得身份验证后Exchange，即可使用私有API服务AccountService和TradeService来访问私有数据：
```java
// Get the account information
AccountService accountService = bitstamp.getAccountService();
AccountInfo accountInfo = accountService.getAccountInfo();
System.out.println(accountInfo.toString());
```

所有交换实现都公开相同的API，但是如果需要，您也可以直接从各个交换中访问基础的“原始”数据。
## Example 3: Streaming data and websockets

T上面的API通常在所有交易所中都得到完全支持，并且最适合偶尔请求和以相对较长的时间间隔进行轮询。但是，许多交易所严重限制了发出这些请求的频率，如果需要最新信息，则建议您使用其websocket API。

对于较少的交换，StreamingExchange也可以使用基于websocket的API。这使用反应性流，使您可以有效地订阅与数千个硬币对有关的更改，而无需使用大量线程。

您将需要为正在使用的交换导入其他依赖项（请参见下文），然后示例用法如下：
```java
// Use StreamingExchangeFactory instead of ExchangeFactory
StreamingExchange exchange = StreamingExchangeFactory.INSTANCE.createExchange(BitstampStreamingExchange.class);

// Connect to the Exchange WebSocket API. Here we use a blocking wait.
exchange.connect().blockingAwait();

// Subscribe to live trades update.
Disposable subscription1 = exchange.getStreamingMarketDataService()
    .getTrades(CurrencyPair.BTC_USD)
    .subscribe(
        trade -> LOG.info("Trade: {}", trade),
        throwable -> LOG.error("Error in trade subscription", throwable));

// Subscribe order book data with the reference to the subscription.
Disposable subscription2 = exchange.getStreamingMarketDataService()
    .getOrderBook(CurrencyPair.BTC_USD)
    .subscribe(orderBook -> LOG.info("Order book: {}", orderBook));

// Wait for a while to see some results arrive
Thread.sleep(20000);

// Unsubscribe
subscription1.dispose();
subscription2.dispose();

// Disconnect from exchange (blocking again)
exchange.disconnect().blockingAwait();
```

如果支持交换，则通过身份验证与主API的工作方式相同ExchangeSpecification。有关受支持内容的更多信息，请参见Wiki。
## More information

Now go ahead and [study some more examples](http://knowm.org/open-source/xchange/xchange-example-code), [download the thing](http://knowm.org/open-source/xchange/xchange-change-log/) and [provide feedback](https://github.com/knowm/XChange/issues).

More information about reactive streams can be found at the [RxJava wiki](https://github.com/ReactiveX/RxJava/wiki).

## Features

- [x] MIT license
- [x] consistent API across all implemented exchanges
- [x] active development
- [x] very minimal 3rd party dependencies
- [x] modular components

## More Info

Project Site: <http://knowm.org/open-source/xchange>  
Example Code: <http://knowm.org/open-source/xchange/xchange-example-code>  
Change Log: <http://knowm.org/open-source/xchange/xchange-change-log/>  
Java Docs: <http://knowm.org/javadocs/xchange/index.html>

## Wiki

- [Home](https://github.com/knowm/XChange/wiki)
- [FAQ](https://github.com/knowm/XChange/wiki/Frequently-Asked-Questions)
- [Design Notes](https://github.com/knowm/XChange/wiki/Design-Notes)
- [Milestones](https://github.com/knowm/XChange/wiki/Milestones)
- [Exchange Support](https://github.com/knowm/XChange/wiki/Exchange-support)
- [New Implementation Best Practices](https://github.com/knowm/XChange/wiki/New-Implementation-Best-Practices)
- [Installing SSL Certificates into TrustStore](https://github.com/knowm/XChange/wiki/Installing-SSL-Certificates-into-TrustStore)
- [Getting Started with XChange for Noobies](https://github.com/knowm/XChange/wiki/Getting-Started-with-XChange-for-Noobies)
- [Code Style](https://github.com/knowm/XChange/wiki/Code-Style)

## Continuous Integration

[![Build Status](https://travis-ci.org/knowm/XChange.png?branch=develop)](https://travis-ci.org/knowm/XChange.png)
[Build History](https://travis-ci.org/knowm/XChange/builds)

## Getting Started

### Non-Maven

- XChange Release Jars: http://search.maven.org/#search%7Cga%7C1%7Cknowm%20xchange
- XChange Snapshot Jars: https://oss.sonatype.org/content/groups/public/org/knowm/xchange/

### Maven

The XChange release artifacts are hosted on Maven Central.

Add the following dependencies in your pom.xml file. You will need at least xchange-core. Add the additional dependencies for the exchange modules you are interested in (XYZ shown only for a placeholder). There is example code for all the modules in xchange-examples.

```xml
<dependency>
  <groupId>org.knowm.xchange</groupId>
  <artifactId>xchange-core</artifactId>
  <version>5.0.4</version>
</dependency>
<dependency>
  <groupId>org.knowm.xchange</groupId>
  <artifactId>xchange-XYZ</artifactId>
  <version>5.0.4</version>
</dependency>
```

If it is available for your exchange, you may also want to use the streaming API:

```xml
<dependency>
  <groupId>org.knowm.xchange</groupId>
  <artifactId>xchange-stream-XYZ</artifactId>
  <version>5.0.4</version>
</dependency>
```

For snapshots, add the following repository to your pom.xml file.

```xml
<repository>
  <id>sonatype-oss-snapshot</id>
  <snapshots/>
  <url>https://oss.sonatype.org/content/repositories/snapshots</url>
</repository>
```

The current snapshot version is:

    5.0.5-SNAPSHOT

## Building with Maven

run unit tests: `mvn clean test`  
run unit and integration tests: `mvn clean verify -DskipIntegrationTests=false`  
install in local Maven repo: `mvn clean install`  
create project javadocs: `mvn javadoc:aggregate`  
generate dependency tree: `mvn dependency:tree`  
check for dependency updates: `mvn versions:display-dependency-updates`  
check for plugin updates: `mvn versions:display-plugin-updates`  
code format: `mvn com.coveo:fmt-maven-plugin:format`

## Bugs

Please report any bugs or submit feature requests to [XChange's Github issue tracker](https://github.com/knowm/XChange/issues).

## Contributing

If you'd like to submit a new implementation for another exchange, please take a look at [New Implementation Best Practices](https://github.com/knowm/XChange/wiki/New-Implementation-Best-Practices) first, as there are lots of time-saving tips!

For more information such as a contributor list and a list of known projects depending on XChange, visit the [Main Project Wiki](https://github.com/knowm/XChange/wiki).
