package info.bitrich.xchangestream.util;

import info.bitrich.xchangestream.service.ConnectableService;
import org.knowm.xchange.ExchangeSpecification;

public class Events {

    /**
     * 特定于Exchange的参数，用于提供{@link Runnable}操作，以便在维护流连接的过程中启动任何API调用之前运行。
     *
     * <p>虽然某些交换允许双向流式通信，以便可以打开套接字然后进行身份验证，但其他交换则通过单独的API调用执行身份验证，该调用可以计入API速率限制。
     * 此外，许多交易所需要API调用才能获取流数据（如订单簿或帐户更新）的初始快照。
     * XChange要求开发人员自行管理速率，但xchange-stream必须自动启动这些API调用时，这是不可能的。
     * 此参数为开发人员提供了一种在这些API调用之前获取回调的方法，主要是在全球范围内应用此类速率限制。
     * 但是，原则上有更广泛的潜在用途。
     *
     * @see ConnectableService#BEFORE_CONNECTION_HANDLER which provides the same sort of hook for
     * socket reconnections. This also includes example usage.
     */
    public static final String BEFORE_API_CALL_HANDLER = "Before_API_Call_Event_Handler";

    /**
     * 返回{@link #BEFORE_API_CALL_HANDLER}事件的注册处理程序。
     *
     * @param exchangeSpecification The exchange specification.
     * @return The handler.
     */
    public static Runnable onApiCall(ExchangeSpecification exchangeSpecification) {
        Object onApiCall =
                exchangeSpecification.getExchangeSpecificParametersItem(BEFORE_API_CALL_HANDLER);
        return onApiCall == null ? () -> {
        } : (Runnable) onApiCall;
    }
}
