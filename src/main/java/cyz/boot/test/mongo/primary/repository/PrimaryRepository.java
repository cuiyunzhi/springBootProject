package cyz.boot.test.mongo.primary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cyz.boot.test.mongo.primary.entity.PrimaryMongoObject;

public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}