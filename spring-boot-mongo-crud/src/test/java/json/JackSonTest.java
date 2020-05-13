package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.maodun.mongo.pojo.TestDoc;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.util.List;

/**
 * @author tongjian
 * @version 1.0
 * @date 2020/5/13 9:06
 */
@JsonTest
public class JackSonTest {

    public static final String MutiJson = "[\n" +
            "    {\n" +
            "        \"id\": \"5eba870d4496ca66c2131e81\",\n" +
            "        \"docCode\": \"60b62383-020b-43d7-a198-e62a6d9f5ef2\",\n" +
            "        \"docText\": \"7177609f-0e1b-49e0-b200-5f9bc5254e84\",\n" +
            "        \"createTime\": \"2020-05-12 19:22:53\",\n" +
            "        \"creatorId\": \"maodun\",\n" +
            "        \"modifyTime\": null,\n" +
            "        \"modifierId\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"5eba870e4496ca66c2131e82\",\n" +
            "        \"docCode\": \"b3a35fc9-d1ae-4ae6-ac18-8430e44b4dac\",\n" +
            "        \"docText\": \"34de0743-42ab-4386-95bc-a2db0f692116\",\n" +
            "        \"createTime\": \"2020-05-12 19:22:54\",\n" +
            "        \"creatorId\": \"maodun\",\n" +
            "        \"modifyTime\": null,\n" +
            "        \"modifierId\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"5eba870e4496ca66c2131e83\",\n" +
            "        \"docCode\": \"584f737b-2af0-4763-9bf1-a348c4d321e8\",\n" +
            "        \"docText\": \"e55879f5-8f80-4b2b-8a5f-813ccfd7db74\",\n" +
            "        \"createTime\": \"2020-05-12 19:22:54\",\n" +
            "        \"creatorId\": \"maodun\",\n" +
            "        \"modifyTime\": null,\n" +
            "        \"modifierId\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"5eba870f4496ca66c2131e84\",\n" +
            "        \"docCode\": \"9a4a6cad-db29-41f9-a139-c4cc6f054168\",\n" +
            "        \"docText\": \"12024b85-ce76-4651-ae9d-e8c557f7bbc2\",\n" +
            "        \"createTime\": \"2020-05-12 19:22:55\",\n" +
            "        \"creatorId\": \"maodun\",\n" +
            "        \"modifyTime\": null,\n" +
            "        \"modifierId\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"5eba870f4496ca66c2131e85\",\n" +
            "        \"docCode\": \"ad45e22b-67f4-4276-8830-ae5ea0a0e7ce\",\n" +
            "        \"docText\": \"fbf8ad1b-d874-463f-babc-dcbd5bf71c09\",\n" +
            "        \"createTime\": \"2020-05-12 19:22:55\",\n" +
            "        \"creatorId\": \"maodun\",\n" +
            "        \"modifyTime\": null,\n" +
            "        \"modifierId\": null\n" +
            "    }\n" +
            "]";


    /**
     * string转Pojo集合
     */
    @Test
    public void string2ListTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 注意 TestDoc上的 @JsonFormat注解

            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, TestDoc.class);
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, TestDoc.class);
            List<TestDoc> testDocs = (List<TestDoc>) objectMapper.readValue(MutiJson, javaType);
            List<TestDoc> testDocs1 = (List<TestDoc>) objectMapper.readValue(MutiJson, collectionType);
            testDocs1.forEach(System.out::println);
            testDocs.forEach(System.out::println);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
