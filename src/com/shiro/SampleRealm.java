package com.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Component;

import com.hibernate.beans.Role;
import com.hibernate.beans.User;
import com.hibernate.bo.RoleBo;

@Component
public class SampleRealm extends AuthorizingRealm {
	private RoleBo roleBo;
	public RoleBo getRoleBo() {
		return roleBo;
	}
	public void setRoleBo(RoleBo roleBo) {
		this.roleBo = roleBo;
	}

	@SuppressWarnings("deprecation")
	public SampleRealm() {
        setName("SampleRealm"); //This name must match the name in the User class's getPrincipals() method
        setCredentialsMatcher(new Sha256CredentialsMatcher());
	}

	//��ȡ��֤����Ϣ���û��Ľ�ɫ�����е�Ȩ��
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		try {
			List<Role> roles = roleBo.getRoles(userId);
	        if( roles != null ) {
	            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	            for(Role role : roles) {
	                info.addRole(role.getRoleName());
	                info.addStringPermissions(role.getPermissions());
	            }
	            return info;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		try {
			//��֤ǰ����
	        UsernamePasswordToken authtoken = (UsernamePasswordToken) token;
	        User user = (User) roleBo.findAllByUsername(User.class,authtoken.getUsername());
	        if( user != null ) {
	            //��֤�󷵻���֤��Ϣ
	            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    /**
	 * �����û���Ȩ��Ϣ����.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
	    SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
	    clearCachedAuthorizationInfo(principals);
	}

	/**
	 * ��������û���Ȩ��Ϣ����.
	 */
	public void clearAllCachedAuthorizationInfo() {
	    Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
	    if (cache != null) {
	        for (Object key : cache.keys()) {
	            cache.remove(key);
	        }
	    }
	} 
}
