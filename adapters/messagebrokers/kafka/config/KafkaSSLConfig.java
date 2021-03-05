package br.com.b3.pip.gerenciarrecurso.adapters.messagebrokers.kafka.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KafkaSSLConfig {
	@Value("${kafka-ssl.use-ssl}")
    private Boolean useSSL;

    @Value("${kafka-ssl.trust-store-location}")
    private String trustStoreLocation;

    @Value("${kafka-ssl.trust-store-password}")
    private String trustStorePassword;

    @Value("${kafka-ssl.key-store-location}")
    private String keyStoreLocation;

    @Value("${kafka-ssl.key-store-password}")
    private String keyStorePassword;

    @Value("${kafka-ssl.key-password}")
    private String keyPassword;

    public Map<String, Object> getSSLConfig(){

        Map<String, Object> sslProps = new HashMap<>();

        if(useSSL != null && useSSL) {
            sslProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
            sslProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, getCertificatePath(trustStoreLocation));
            sslProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, trustStorePassword);
            sslProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, getCertificatePath(keyStoreLocation));
            sslProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, keyStorePassword);
            sslProps.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, keyPassword);
            sslProps.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
        }

        return sslProps;
    }

    private String getCertificatePath(String pathsString){

        if (pathsString == null || pathsString.length() == 0) {
            throw new RuntimeException("Invalid certificate path.");
        }

        String realPath = null;
        if(pathsString.contains(",")) {
            List<String> pathsArray = Arrays.asList(pathsString.split(","));

            if (pathsArray == null || pathsArray.size() == 0) {
                throw new RuntimeException("Invalid certificate path.");
            }

            for (int i = 0; i < pathsArray.size(); ++i) {
                realPath = testPath(pathsArray.get(i));
                if(realPath != null){
                    break;
                }
            }
        } else {
            realPath = testPath(pathsString);
        }

        if(realPath == null){
            throw new RuntimeException("Invalid certificate path.");
        }

        return realPath;
    }

    public String testPath(String path){
        File sourceFile = new File(path.trim());
        if (sourceFile.exists()) {
            try {
                return sourceFile.getCanonicalPath();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public Boolean getUseSSL() {
        if(useSSL == null) {
            useSSL = false;
        }
        return useSSL;
    }
}
