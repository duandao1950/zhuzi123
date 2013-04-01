package com.hibernate.bo;

import java.util.ArrayList;

import com.hibernate.beans.PerformanceOpt;
import com.hibernate.bo.ibo.IPerformanceOptBo;
import com.hibernate.dao.idao.IPerformanceOptDAO;

public class PerformanceOptBo implements IPerformanceOptBo {

	private IPerformanceOptDAO pfoptDao;
	
	public IPerformanceOptDAO getPfoptDao() {
		return pfoptDao;
	}

	public void setPfoptDao(IPerformanceOptDAO pfoptDao) {
		this.pfoptDao = pfoptDao;
	}

	public void addPerformanceOpt(PerformanceOpt pfOpt) throws Exception {
		
		pfoptDao.addPerformanceOpt(pfOpt);

	}

	public void delPerformanceOpt(PerformanceOpt pfOpt) throws Exception {

		pfoptDao.delPerformanceOpt(pfOpt);
	}

	public ArrayList findAllPerformanceOpt() throws Exception {

		return pfoptDao.findAllPerformanceOpt();
	}

	public ArrayList findPerformanceOptById(String staffId)
			throws Exception {

		return pfoptDao.findPerformanceOptById(staffId);
	}

	public ArrayList findPerformanceOptByName(String staffName)
			throws Exception {

		return pfoptDao.findPerformanceOptByName(staffName);
	}

	public void updatePerformanceOpt(PerformanceOpt pfOpt) throws Exception {

		pfoptDao.updatePerformanceOpt(pfOpt);
	}

	public PerformanceOpt findPerformanceOptById(String staffId, String month)
			throws Exception {
		return pfoptDao.findPerformanceOptById(staffId, month);
	}

}
