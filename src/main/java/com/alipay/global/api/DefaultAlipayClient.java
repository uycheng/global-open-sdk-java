package com.alipay.global.api;

import java.util.Map;

import com.alipay.global.api.exception.AlipayApiException;
import com.alipay.global.api.net.DefaultHttpRPC;
import com.alipay.global.api.net.HttpRpcResult;

public class DefaultAlipayClient extends BaseAlipayClient {

    public DefaultAlipayClient(String gatewayUrl, String merchantPrivateKey, String alipayPublicKey) {
        super(gatewayUrl, merchantPrivateKey, alipayPublicKey);
    }

    @Override
    public Map<String, String> buildCustomHeader() {
        return null;
    }

    public HttpRpcResult sendRequest(String requestUrl, String httpMethod, Map<String, String> header, String reqBody) throws AlipayApiException {
        HttpRpcResult httpRpcResult;
        try {
            httpRpcResult = DefaultHttpRPC.doPost(requestUrl, header, reqBody);
        } catch (Exception e) {
            throw new AlipayApiException(e);
        }
        return httpRpcResult;
    }

}
