package cyz.boot.test.mongo.second.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cyz.boot.test.mongo.primary.entity.PrimaryMongoObject;

public interface SecondRepository extends MongoRepository<PrimaryMongoObject, String> {
}