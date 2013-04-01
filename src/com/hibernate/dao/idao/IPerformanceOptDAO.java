package com.hibernate.dao.idao;

import java.util.ArrayList;

import com.hibernate.beans.PerformanceOpt;

/**
 * ά���鼨Ч����������
 * @author wKF36120
 * @version 01 2011-04-22
 *
 */
public interface IPerformanceOptDAO {

	/**
	 * ���һ����Ч
	 * @throws Exception
	 */
	public void addPerformanceOpt(PerformanceOpt pfOpt) throws Exception;
	
	/**
	 * ɾ����Ч
	 * @throws Exception
	 */
	public void delPerformanceOpt(PerformanceOpt pfOpt) throws Exception;
	
	/**
	 * ����Ա��id���Ҽ�Ч
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ArrayList findPerformanceOptById(String staffId) throws Exception;
	
	/**
	 * ����Ա��id�������·ݲ���
	 * @param staffId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public PerformanceOpt findPerformanceOptById(String staffId,String month) throws Exception;	
	
	/**
	 * ����Ա�����Ʋ��Ҽ�Ч
	 * @param staffName
	 * @return
	 * @throws Exception
	 */
	public ArrayList findPerformanceOptByName(String staffName) throws Exception;
	
	/**
	 * �������м�Ч
	 * @return
	 * @throws Exception
	 */
	public ArrayList findAllPerformanceOpt() throws Exception;
	
	/**
	 * ���¼�Ч
	 * @param pfOpt
	 * @throws Exception
	 */
	public void updatePerformanceOpt(PerformanceOpt pfOpt) throws Exception;
}
