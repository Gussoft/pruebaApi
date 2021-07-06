package com.gussoft.controlles;

public class HashRequest {
    private String hash;
    private String signedHash;

    public HashRequest() {

    }

    public HashRequest(String hash, String signedHash) {
        this.hash = hash;
        this.signedHash = signedHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSignedHash() {
        return signedHash;
    }

    public void setSignedHash(String signedHash) {
        this.signedHash = signedHash;
    }
}
