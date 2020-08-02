package com.oc.p12.Bean.Dto.Adress;

public class AdressRequest {

    public int accountId;

    public int carTravelId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCarTravelId() {
        return carTravelId;
    }

    public void setCarTravelId(int carTravelId) {
        this.carTravelId = carTravelId;
    }

    @Override
    public String toString() {
        return "AdressRequest{" +
                "accountId=" + accountId +
                ", carTravelId=" + carTravelId +
                '}';
    }
}
