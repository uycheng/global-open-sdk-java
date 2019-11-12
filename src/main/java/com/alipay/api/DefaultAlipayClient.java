package com.alipay.api;

import com.alipay.api.exception.AlipayApiException;
import com.alipay.api.net.DefaultHttpRPC;
import com.alipay.api.net.HttpRpcResult;

import java.io.IOException;
import java.util.Map;

public class DefaultAlipayClient extends BaseAlipayClient{

    public DefaultAlipayClient(String gatewayUrl, String merchantPrivateKey, String alipayPublicKey ){
        super(gatewayUrl, merchantPrivateKey, alipayPublicKey);
    }

    @Override
    public Map<String, String> buildCustomHeader() {
        return null;
    }

    public HttpRpcResult sendRequest(String requestUrl, String httpMethod, Map<String, String> header, String reqBody)throws AlipayApiException {
        HttpRpcResult httpRpcResult;
        try {
            httpRpcResult = DefaultHttpRPC.doPost(requestUrl, header, reqBody);
        } catch (IOException e){
            throw new AlipayApiException(e);
        }
        return httpRpcResult;
    }


}