package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

import com.example.consumingwebservice.wsdl.NumberToWords;
import com.example.consumingwebservice.wsdl.NumberToWordsResponse;


public class Client extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public NumberToWordsResponse getNumberToWord(BigInteger n) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(n);
        log.info("Requestion location for " + n);
        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate()
            .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL", request,
                new SoapActionCallback("https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL"));
        return response;
    }
}