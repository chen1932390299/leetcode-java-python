package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.log4j.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class HttpDemo {
    private static Logger LOGGER = Logger.getLogger(HttpDemo.class);
    private static CloseableHttpResponse response;
    private static HttpEntity entity;


    public static CloseableHttpClient sslIgnoreClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        // TODO GET IGNORE SSL CloseableClient
        CloseableHttpClient client = null;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {

            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();
        client = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        return client;
    }

    public static String doGet(String url, Map<Object, Object> header) throws KeyStoreException, IOException,
            KeyManagementException, NoSuchAlgorithmException {
        // TODO get request that setHeader by header is null or not
        String result = null;  // initialize result
        CloseableHttpClient request = sslIgnoreClient();
        HttpGet msg = new HttpGet(url);
        if (header != null) {
            header.forEach((key, value) -> {
                msg.addHeader(key.toString(), value.toString());
            });

        }
        response = request.execute(msg);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        }
        return result;
    }


    public static String doPost(String url, String body, Map<Object, Object> header) throws KeyStoreException, IOException,
            KeyManagementException, NoSuchAlgorithmException {
        // TODO json body request
        String result = null;
        CloseableHttpClient request = sslIgnoreClient();
        HttpPost msg = new HttpPost(url);
        if (header != null) {
            header.forEach((key, value) -> {
                msg.addHeader(key.toString(), value.toString());
            });
        }
        msg.setEntity(new StringEntity(body));
        response = request.execute(msg);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        }
        return result;
    }


    static String doPostParam(String url, Map<Object, Object> header, Map<Object, Object> params) throws KeyStoreException, IOException,
            KeyManagementException, NoSuchAlgorithmException {
        // TODO form-data post request
        String result = null;
        CloseableHttpClient request = sslIgnoreClient();
        HttpPost msg = new HttpPost();
        if (header != null) {
            header.forEach((key, value) -> {
                msg.addHeader(key.toString(), value.toString());
            });
        }
        List<BasicNameValuePair> paramList = new ArrayList<>();
        params.forEach((key, value) -> {
            paramList.add(new BasicNameValuePair(key.toString(), value.toString()));
        });
        HttpEntity formEntity = new UrlEncodedFormEntity(paramList, "utf-8");
        msg.setEntity(formEntity);
        response = request.execute(msg);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        }
        return result;
    }


    static String postFileImage(String url, Map<Object, Object> textBody, List<String> fileList, Map<Object, Object> header, int ttl) throws KeyStoreException, IOException,
            KeyManagementException, NoSuchAlgorithmException {
        // TODO UPLOAD IMAGES OR FILES ,msg.setHeader(key,value);
        String result = null;
        CloseableHttpClient request = sslIgnoreClient();
        HttpPost msg = new HttpPost();
        if (header != null) {
            header.forEach((key, value) -> {
                msg.addHeader(key.toString(), value.toString());
            });
        }
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(ttl).setSocketTimeout(ttl).build();
        msg.setConfig(requestConfig);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        fileList.forEach(item -> {
            File f = new File(item);
            try {
                builder.addBinaryBody(
                        "file",
                        new FileInputStream(f),
                        ContentType.APPLICATION_OCTET_STREAM,
                        f.getName()
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        textBody.forEach((key, value) -> {
            builder.addTextBody(String.valueOf(key), String.valueOf(value), ContentType.TEXT_PLAIN);
        });

        msg.setEntity(builder.build());
        response = request.execute(msg);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            entity = response.getEntity();
            long length = entity.getContentLength();
            byte[] res = null;
            res = EntityUtils.toByteArray(entity);
            result = new String(res, StandardCharsets.UTF_8);
        }

        return result;

    }

}
