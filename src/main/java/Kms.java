import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DataKeySpec;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import javax.crypto.spec.SecretKeySpec;

class Kms {
    static SecretKeySpec getKeySpec() {
        AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
        final GenerateDataKeyRequest request = new GenerateDataKeyRequest()
                .withKeySpec("AES_128");

        final GenerateDataKeyResult response = kmsClient.generateDataKey(request);
        return new SecretKeySpec(response.getPlaintext().array(), "AES");
    }

    static int main(String[] args) {
        getKeySpec();
        return 0;
    }
}
