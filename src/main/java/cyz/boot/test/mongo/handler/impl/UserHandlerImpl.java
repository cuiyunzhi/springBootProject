package cyz.boot.test.mongo.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cyz.boot.test.common.utils.LoggerUtil;
import cyz.boot.test.mongo.dao.UserDao;
import cyz.boot.test.mongo.entity.UserEntity;
import cyz.boot.test.mongo.handler.UserHandler;

@Component
public class UserHandlerImpl implements UserHandler{
	@Autowired
    private UserDao userDao;
	@Override
	public void testSaveUser() throws Exception {
		LoggerUtil.info("testSaveUser begin...");
		UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userDao.saveUser(user);
        LoggerUtil.info("testSaveUser end...");
	}

	@Override
	public void findUserByUserName() {
		LoggerUtil.info("findUserByUserName begin...");
		UserEntity user= userDao.findUserByUserName("小明");
		LoggerUtil.info("findUserByUserName end..."+user);
	}

	@Override
	public void updateUser() {
		LoggerUtil.info("updateUser begin...");
		UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
        LoggerUtil.info("updateUser end...");
	}

	@Override
	public void deleteUserById() {
		LoggerUtil.info("deleteUserById begin...");
		userDao.deleteUserById(1l);
		LoggerUtil.info("deleteUserById end...");
	}

	@Override
	public void savePrimaryUser() {
		userDao.savePrimaryUser();
	}

	@Override
	public void queryPrimaryUser() {
		userDao.findPrimaryUserByUserName();
	}


	
	
}
