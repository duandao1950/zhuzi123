package com.hibernate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.common.util.CommonUtils;
import com.hibernate.beans.Privilege;
import com.hibernate.dao.idao.IBaseSpringDAO;
import com.struts.util.Constants;

public class BaseSpringDAO extends JdbcDaoSupport implements IBaseSpringDAO{
	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<Privilege> getMenuList(String operId) throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" select c.privilege_id,c.privilege_name,c.porder,c.parent_porder,c.url,c.privilege_level ");
		sbf.append(" from OPER_PRIVILEGE c ");
		if (!Constants.LOGIN_ADMIN.equals(operId)) {
			sbf.append(" where c.privilege_id ");
			sbf
					.append(" in(select b.privilege_id from oper_roles_relation a,oper_privs b where a.role_id=b.role_id ");
			sbf.append(" and a.oper_id= '");
			sbf.append(operId).append("')");
		}
		sbf.append(" order by ordernumber ");

		/*
		 * String sql = "select
		 * c.privilege_id,c.privilege_name,c.porder,c.parent_porder,c.url,c.privilege_level
		 * from OPER_PRIVILEGE c where c.privilege_id in(select b.privilege_id
		 * from oper_roles_relation a,oper_privs b where a.role_id=b.role_id and
		 * a.oper_id= '" + operId + "') order by ordernumber"; String selSQL =
		 * MessageFormat.format(sql, new Object[] {operId});
		 */

		log.debug("sql is :" + sbf.toString());
		List<Privilege> list = this.getJdbcTemplate().query(sbf.toString(),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int row)
							throws SQLException {
						Privilege operPrivilege = new Privilege();
						operPrivilege.setPrivilegeId(rs
								.getString("privilege_id"));
						operPrivilege.setPrivilegeName(rs
								.getString("privilege_name"));
						operPrivilege.setPorder(rs.getString("porder"));
						operPrivilege.setParentPorder(rs
								.getString("parent_porder"));
						operPrivilege.setUrl(rs.getString("url"));
						operPrivilege.setPrivilegeLevel(rs
								.getString("privilege_level"));
						return operPrivilege;
					}
				});
		return list;
	}

	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List getRolesByOperId(String operId)
			throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" select b.role_id from oper_role b  ");
		sbf.append(" where b.role_id in( ");
		sbf.append(" select a.role_id from oper_roles_relation a where a.oper_id='");
		sbf.append(operId).append("')");

		log.debug("sql is :" + sbf.toString());
		List list = this.getJdbcTemplate().query(sbf.toString(),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int row)
							throws SQLException {
						return rs.getString("role_id");
					}
				});
		return list;
	}
	
	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	public void deleteOperatorRolesRelation(String operId,Integer roleId)
			throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" delete from oper_roles_relation where oper_id = '");
		sbf.append(operId).append("' and role_id = '").append(roleId).append("'");

		log.debug("sql is :" + sbf.toString());
		this.getJdbcTemplate().execute(sbf.toString());
	}
	
	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List getPrivilegesByRoleId(Integer roleId)
			throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" select b.privilege_id from oper_role a,oper_privs b where a.role_id=b.role_id and a.is_valid='1'");
		sbf.append(" and a.role_id='");
		sbf.append(roleId).append("'");

		log.debug("sql is :" + sbf.toString());
		List list = this.getJdbcTemplate().query(sbf.toString(),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int row)
							throws SQLException {
						return rs.getString("privilege_id");
					}
				});
		return list;
	}

	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	public void deleteRolePrivilegesRelation(Integer roleId,String privilegeId)
			throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" delete from oper_privs where role_id = '");
		sbf.append(roleId).append("' and privilege_id = '").append(privilegeId).append("'");

		log.debug("sql is :" + sbf.toString());
		this.getJdbcTemplate().execute(sbf.toString());
	}
	
	
	/**
	 * 获得操作员->角色->菜单->角色与菜单之间的关系
	 * 
	 * @param operId
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<Privilege> getPartPrivilegesByParentId(String parentId)
			throws SQLException {

		StringBuffer sbf = new StringBuffer();
		sbf.append(" select a.privilege_id,a.privilege_name,a.privilege_level from oper_privilege a  ");
		sbf.append(" where (a.parent_porder='");
		sbf.append(parentId).append("' or a.porder='").append(parentId).append("')");
		sbf.append(" order by ordernumber asc ");

		log.debug("sql is :" + sbf.toString());
		List list = this.getJdbcTemplate().query(sbf.toString(),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int row)
							throws SQLException {
						Privilege operPrivilege = new Privilege();
						operPrivilege.setPrivilegeId(rs.getString("privilege_id"));
						operPrivilege.setPrivilegeName(rs.getString("privilege_name"));
						operPrivilege.setPrivilegeLevel(rs.getString("privilege_level"));
						return operPrivilege;
					}
				});
		return list;
	}
	
	/**
     * 获得字典表信息
     * @author 
     * @return
     * @throws SQLException
     */
    public LinkedHashMap<String,String> getDicContenByDicName(String dicName) throws SQLException {
        StringBuffer str = new StringBuffer();
        str.append(" select a.id,b.value from DIC_KEY a,DIC_VALUE b where a.key = b.id ");
        str.append(" and a.table_name='");
        str.append(dicName).append("'");
        
        String language = CommonUtils.getDefaultLanguage();
        if (StringUtils.isNotBlank(language)){
        	str.append("and b.language=upper('").append(language).append("')");
        }
        str.append(" order by a.ordernumber");
        log.debug("sql is :"+str);
        
        final LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        this.getJdbcTemplate().query(str.toString(), new RowMapper() {
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                return map.put(rs.getString("ID"), rs.getString("value"));
            }
        });
        return map;
    }
	
    /**
     * 根据字典表名称和ID,获得字典表信息
     * @author
     * @return
     * @throws SQLException
     */
    public String loadDicContent(String dicName,String id) throws SQLException {
        StringBuffer str = new StringBuffer();
        str.append(" select b.value from DIC_KEY a,DIC_VALUE b where a.key=b.id ");
        str.append(" and a.table_name='").append(dicName).append("'");
        str.append(" and a.id='").append(id).append("'");
        
        String language = CommonUtils.getDefaultLanguage();
        if (StringUtils.isNotBlank(language)){
        	str.append(" and b.language=upper('").append(language).append("')");
        }
        str.append(" order by a.ordernumber");
        log.debug("sql is :"+str);
        
        List<String> list = this.getJdbcTemplate().query(str.toString(), new RowMapper() {
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                return rs.getString("value");
            }
        });
        return (list == null || list.size()==0)? "" : list.get(0);
    }
    
	/**
	 * 迭代出元数中的value集合
	 * 
	 * @param linkList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> linkedListToValueList(List linkList) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < linkList.size(); i++) {
			Iterator iterator = ((org.apache.commons.collections.map.ListOrderedMap) linkList
					.get(i)).values().iterator();
			while (iterator.hasNext()) {
				list.add(iterator.next().toString());
			}
		}
		return list;
	}
}