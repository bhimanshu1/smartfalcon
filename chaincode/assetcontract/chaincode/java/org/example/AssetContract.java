package org.example;

import java.util.List;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.shim.ChaincodeStub;

import com.owlike.genson.Genson;

@Contract(name = "AssetContract")
@Default
public class AssetContract implements ContractInterface {

    private final Genson genson = new Genson();
    @Transaction()
public void initLedger(final Context ctx) {
    ChaincodeStub stub = ctx.getStub();

    Asset[] sampleAssets = {
        new Asset("D001", "9000011111", "1111", 1000.0, "ACTIVE", 0.0, "NONE", "Account 1"),
        new Asset("D002", "9000022222", "2222", 2000.0, "ACTIVE", 0.0, "NONE", "Account 2"),
        new Asset("D003", "9000033333", "3333", 3000.0, "INACTIVE", 0.0, "NONE", "Account 3"),
        new Asset("D004", "9000044444", "4444", 4000.0, "ACTIVE", 0.0, "NONE", "Account 4"),
        new Asset("D005", "9000055555", "5555", 5000.0, "ACTIVE", 0.0, "NONE", "Account 5"),
        new Asset("D006", "9000066666", "6666", 6000.0, "ACTIVE", 0.0, "NONE", "Account 6"),
        new Asset("D007", "9000077777", "7777", 7000.0, "INACTIVE", 0.0, "NONE", "Account 7"),
        new Asset("D008", "9000088888", "8888", 8000.0, "ACTIVE", 0.0, "NONE", "Account 8"),
        new Asset("D009", "9000099999", "9999", 9000.0, "ACTIVE", 0.0, "NONE", "Account 9"),
        new Asset("D010", "9000010101", "1010", 10000.0, "ACTIVE", 0.0, "NONE", "Account 10"),
    };

    for (Asset asset : sampleAssets) {
        String json = genson.serialize(asset);
        stub.putStringState(asset.getDealerId(), json);
    }
}


    
    

    @Transaction()
    public void createAsset(final Context ctx, String dealerId, String msisdn, String mpin, String balance,
                            String status, String transAmount, String transType, String remarks) {

        ChaincodeStub stub = ctx.getStub();

        boolean exists = assetExists(ctx, dealerId);
        if (exists) {
            throw new RuntimeException("Asset already exists with Dealer ID: " + dealerId);
        }

        Asset asset = new Asset(dealerId, msisdn, mpin,
                Double.parseDouble(balance),
                status,
                Double.parseDouble(transAmount),
                transType, remarks);

        String assetJSON = genson.serialize(asset);
        stub.putStringState(dealerId, assetJSON);
    }

    @Transaction()
    public Asset readAsset(final Context ctx, String dealerId) {
        ChaincodeStub stub = ctx.getStub();
        String assetJSON = stub.getStringState(dealerId);

        if (assetJSON == null || assetJSON.isEmpty()) {
            throw new RuntimeException("Asset not found: " + dealerId);
        }

        Asset asset = genson.deserialize(assetJSON, Asset.class);
        return asset;
    }

    @Transaction()
    public void updateAsset(final Context ctx, String dealerId, String newBalance, String newStatus) {

        ChaincodeStub stub = ctx.getStub();
        String assetJSON = stub.getStringState(dealerId);

        if (assetJSON == null || assetJSON.isEmpty()) {
            throw new RuntimeException("Asset not found: " + dealerId);
        }

        Asset asset = genson.deserialize(assetJSON, Asset.class);
        asset.setBalance(Double.parseDouble(newBalance));
        asset.setStatus(newStatus);

        String updatedAssetJSON = genson.serialize(asset);
        stub.putStringState(dealerId, updatedAssetJSON);
    }

    @Transaction()
    public boolean assetExists(final Context ctx, String dealerId) {
        ChaincodeStub stub = ctx.getStub();
        String assetJSON = stub.getStringState(dealerId);
        return (assetJSON != null && !assetJSON.isEmpty());
    }
}
