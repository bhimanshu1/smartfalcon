package org.example;

import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;

@Contract(
    name = "AssetTransfer",
    info = @Info(
        title = "AssetTransfer contract",
        description = "A smart contract for managing asset accounts",
        version = "0.0.1",
        license = @License(
            name = "Apache-2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0.html"
        ),
        contact = @Contact(
            email = "student@example.com",
            name = "University Student",
            url = "https://example.com"
        )
    )
)
@Default
public class AssetTransfer implements ContractInterface {

    // You can now define your @Transaction methods here
    // Example:
    // @Transaction(intent = Transaction.TYPE.SUBMIT)
    // public void createAsset(Context ctx, String id, String value) { ... }

}
