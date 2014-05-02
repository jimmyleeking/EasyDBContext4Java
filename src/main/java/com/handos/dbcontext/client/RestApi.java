package com.handos.dbcontext.client;

/**
 * Created by jimmylee on 5/1/14.
 */
public class RestApi {
    private String applicationKey;
    private String applicationId;
    private String baseUrl;
    private String InsertUri;
    public String getApplicationId() {
        return applicationId;
    }

    public String getApplicationKey() {
        return applicationKey;
    }
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }


    public String getBaseUrl() {
        return baseUrl;
    }




    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public String getInsertUri() {
        return InsertUri;
    }

    public void setInsertUri(String insertUri) {
        InsertUri = insertUri;
    }
}
