package cyz.boot.test.mongo.handler;

public interface UserHandler {
	public void testSaveUser() throws Exception;
	public void findUserByUserName();
	public void updateUser();
	public void deleteUserById();
	
	public void savePrimaryUser();
	public void queryPrimaryUser();
}
