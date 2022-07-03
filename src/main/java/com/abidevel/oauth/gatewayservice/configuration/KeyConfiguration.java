package com.abidevel.oauth.gatewayservice.configuration;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyConfiguration {
    private final KeyProperty keyProperty;

    public KeyConfiguration (KeyProperty keyProperty) {
        this.keyProperty = keyProperty;
    }

    @Bean
    RSAPublicKey getRSAPublicKey () throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(keyProperty.getPublicKey())));
       
    }
}
