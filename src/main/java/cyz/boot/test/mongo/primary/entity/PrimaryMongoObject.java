package cyz.boot.test.mongo.primary.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "first_mongo")
public class PrimaryMongoObject {

    @Id
    private String id;

    private String value;

    public PrimaryMongoObject(String id, String value) {
		this.id= id;
		this.value = value;
	}

	@Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}