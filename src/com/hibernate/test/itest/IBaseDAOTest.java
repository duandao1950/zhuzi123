package com.hibernate.test.itest;


public interface IBaseDAOTest{
	public void testFindAllByName() throws Exception;

	public void testFindById() throws Exception;

	public void testInsert() throws Exception;

	public void testUpdate() throws Exception;

	public void testDelete() throws Exception;
	
	public void testFindBySQLMap() throws Exception;
}
