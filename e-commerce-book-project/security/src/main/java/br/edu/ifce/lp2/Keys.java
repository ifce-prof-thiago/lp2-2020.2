package br.edu.ifce.lp2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class Keys {

    private final static String values[] = {
            "ccbf31df-380b-4b47-a4a2-5ab9716cfa58",
            "4e4d29ce-2c79-4eda-981c-0ed46d497630",
            "eb424079-4567-4ef4-973a-e270baf9cdc5",
            "43f76c64-be29-4a28-9b60-fe69efc499a6",
            "b3e19e13-62d0-4854-a082-ebd588daf6e0",
            "42cd5f64-4776-4233-a454-35ee81f81bea",
            "4298e393-8b2e-4b12-aee1-108336dbab2e",
            "f1af19f4-b460-4712-846b-e7702b0bf055",
            "1fba7adc-0153-4101-ad3e-b69181c08bd3",
            "0e273f1b-e9c0-4410-944e-295c7ffd222f",
            "3e356076-013c-4208-b86a-36fdb34fe26e",
            "1a7d47ab-d853-4bc7-ac14-40fc10df0104",
            "e075547e-5e79-466d-a562-5f3a1bf2e9b9",
            "1d0d4ee5-1fb7-4f90-a11f-eb5d10b90daf",
            "6c5e17fa-8f8c-49a2-a1d0-049753c9202e",
            "1510312d-6936-43df-b34c-cb0d2d10e418",
            "bf386a3c-1287-4221-8a19-cff6371d5903",
            "6f614a39-4181-4655-b04d-d506b07eb3cf",
            "0e8c6656-43b0-426b-ba33-fd0e73249814",
            "4e19360b-0abe-464a-a876-a93f124936ad",
            "a9871d6c-fbcf-4a89-817e-cc00eaa9ff7b",
            "aa57e164-1e0d-4004-ad5d-e7b3ef83588a",
            "5a78cc79-0781-40e7-985e-2d7393e2e511",
            "7b7e438b-8cf2-43f0-b293-3f8ea22070bf",
            "0de47639-00db-4e4f-aea2-a4d994c15ac9",
            "e4388f70-4f5b-4f60-b8e0-2a8fef57a3b9",
            "83f71850-75ca-4ad8-b76f-b2eded273c99",
            "5229b33c-7277-4e9f-97a3-1a82afce2711",
            "f56a73d4-9c44-4594-a372-4003d440a20e",
            "76417539-f8de-4b58-8150-e108c038a6f5",
            "04069870-cb1b-4838-8cff-26ee62326e31",
            "d8231956-9f4e-4e04-93d8-daee5a266230",
            "d34f2a50-b706-4f7c-b6a1-d865e80d6a0f",
            "3d9342a8-1049-4db3-976f-9905fc99b827",
            "60b314dc-29b6-4758-ab89-3e2e2f02c3bf",
            "6cc98092-dcc3-4a2a-ac96-58896873630c",
            "9a68529d-0936-47de-9032-4cb4756652f1",
            "ed3dda39-6a9d-4b99-883a-dcb97c82cc6c",
            "28f5d598-105e-4f6b-a049-57e7040c9e88",
            "c7d16304-e31b-4e9d-92e0-53b981adb01e",
            "57507bcf-2a01-4640-9582-a8488090ef34",
            "4631ce95-d270-4585-9f15-7b83a0581ae8",
            "f9602c37-e553-4bb1-ada3-5354b4e485bf",
            "b299832b-aeb8-4fe0-b0c3-0272add05e60",
            "067911b5-ae37-4659-b96b-1b8612de1de0",
            "3925e32e-9df9-4d52-99fb-8fb5b755c562",
            "ffcca8e9-6185-49df-bc7c-95e1583aed8a",
            "b68baa93-82c3-46d4-a67a-0eb0cf3cac8e",
            "46c4c0a1-4d76-47bc-b781-4d02b5cfff52",
            "f7ce9cfd-26f7-411c-b058-5275fea42f7e",
            "37d728e4-1cac-4813-9a04-80a47e022e80",
            "d9e27eef-86b3-4f26-a7ae-7c20b3d56d1b",
            "36c4256e-bfcb-4347-be51-7fae42702a7b",
            "d541e65d-e3ee-4da0-8c4c-8d477a05983a",
            "0946cfd7-b58e-4ad9-af21-06b4e904f9e3",
            "c229c79b-1f0b-4b15-bbc4-5228be2a03ca",
            "ed1e3491-9c3e-4487-a2e6-8ec1a6d74187",
            "05488288-dc38-4792-9902-3851f6730e13",
            "4924ccfd-89cd-4349-956c-c1d9a516316a",
            "5942d003-2040-4859-a59b-b86516691c45",
            "c8c1bffd-d55b-46e9-bf5b-3fa304e68ef2",
            "5e792d16-7609-49d4-9414-59b01b0d514e",
            "bbba8a29-1513-4bde-ab99-8f81fedc7f31",
            "959236a0-e28a-407f-89d6-9e50d5d2a0c9",
            "be910d71-8e31-4562-b3e2-f9856782b309",
            "d9bb1426-2cac-4c3e-8416-30a2a77367b0",
            "1e533597-f489-4432-a855-095536f350d7",
            "ffa9edc7-afcc-4339-981d-09ee6f65928a",
            "e4270332-6589-4291-8ed5-4328dd27087d",
            "7a3ae65b-6c60-4ef4-9a08-827a14c3ee02",
            "962ac031-355f-4727-a544-3deac620ee74",
            "6808e759-bbe3-42be-8c5e-11fabcc53a8d",
            "1ee97824-2742-4c7b-856e-8aeb5d7d923a",
            "4e8085a5-1f17-41d6-9d30-a00fe480be00",
            "2452ff19-8e02-4fc2-8258-b17983bff9e5",
            "72a4003e-b844-4fa1-888b-fa98e2ac68ce",
            "4e4d6afb-9610-4deb-a7a2-c19b4b9b356e",
            "37406c55-d412-4863-8c00-ec43dfba6735",
            "2463432e-34a3-44cb-8f7e-2327daad3b5f",
            "a77f23e4-f3e2-4c7c-b8d9-f93b37335c48",
            "7a1788b7-bc69-49cf-bcc4-057154ed03cc",
            "e60f1dd3-cec7-4125-be3f-9de4778b950a",
            "0dcafc81-2716-43fb-9538-657502c08e5b",
            "112243d8-fda7-4500-aac3-1dbeb707e72d",
            "6ff21ec3-6b4a-47ad-9c64-463a208cae79",
            "478b74aa-7421-4510-ba12-462bd4784e0d",
            "dcda521b-e5b3-487c-b461-7d47b597fc1e",
            "b707014b-0c03-4c38-9145-8fd0b6b14510",
            "46ade3e0-64b4-48d3-aafd-769c7d79ad26",
            "920ce948-3fd8-4554-a3d3-62c3a9400da9",
            "0ce44d00-71e6-4374-9cd1-9322c4bdf47e",
            "4267949d-9c8c-47bc-bab3-9d0a844f53cf",
            "d46fa067-e054-4322-89ff-04d041a7ad36",
            "c21cbc7b-c741-4499-9dc6-951d9fda1e81",
            "63ba13e1-17be-4a2f-abe6-bfcfacb0296d",
            "ec01729b-6f7e-4e13-9472-bc8097d432d0",
            "50710f9d-6f0b-4ffd-9294-2967fcafe6de",
            "25040863-4743-4000-85a6-bc0d5457656f",
            "e6ba00c0-378e-4aa9-922c-b6eba86bfb5a",
            "dd9eddad-9964-4293-8749-01df5d90c9be"
    };

    public static int randomIndex() {
        return new SecureRandom().nextInt(values.length);
    }

    public static byte[] get(int index, String fingerprint) {
        if (index < 0 || index >= values.length)
            throw new IllegalArgumentException("Key is not accessible!");

        return toSha512(values[index], fingerprint);
    }

    private static byte[] toSha512(String input, String fingerprint) {

        try {

            var md = MessageDigest.getInstance("SHA-512");
            md.update(fingerprint.getBytes(StandardCharsets.UTF_8));
            var bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

            var sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString().getBytes();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Bad input");
    }


}
