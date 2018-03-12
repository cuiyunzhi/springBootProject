package cyz.boot.test.mongo.dao;

import cyz.boot.test.mongo.entity.UserEntity;

public interface UserDao {
	public void saveUser(UserEntity user);
	public UserEntity findUserByUserName(String userName);
	public void updateUser(UserEntity user);
	public void deleteUserById(Long id);
	public void findPrimaryUserByUserName();
	public void savePrimaryUser();
}
