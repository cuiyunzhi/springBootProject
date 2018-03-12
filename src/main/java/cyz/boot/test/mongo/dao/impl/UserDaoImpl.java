package cyz.boot.test.mongo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.mongo.dao.UserDao;
import cyz.boot.test.mongo.entity.UserEntity;
import cyz.boot.test.mongo.primary.entity.PrimaryMongoObject;
import cyz.boot.test.mongo.primary.repository.PrimaryRepository;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private PrimaryRepository primaryRepository;

    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("userName").is(userName));
        UserEntity user =  mongoTemplate.findOne(query , UserEntity.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    @Override
    public void updateUser(UserEntity user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
    
    @Override
    public void findPrimaryUserByUserName(){
    	List<PrimaryMongoObject> list= primaryRepository.findAll();
    	LoggerUtil.info("查询结果：{}", list.size()==0?"":list.get(0).toString());
    }
    @Override
    public void savePrimaryUser(){
    	primaryRepository.save(new PrimaryMongoObject(null, "第一个库的对象"));
    }
}