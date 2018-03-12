package cyz.boot.test.mongo.second.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "second_mongo")
public class SecondMongoObject {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}