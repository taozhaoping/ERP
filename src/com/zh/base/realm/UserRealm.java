package com.zh.base.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Authorities;
import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.User;
import com.zh.base.service.AuthoritiesService;
import com.zh.base.service.RoleService;
import com.zh.base.service.UserInfoService;


/**
 * @author 21829
 * 
 */
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
    private UserInfoService userInfoService;
    
	@Autowired
    private RoleService roleService;
    
	@Autowired
    private AuthoritiesService authoritiesService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        //角色集合
        Set<String> roles = new HashSet<String>();
        //权限集合
        Set<String> stringPermissions = new HashSet<String>();
        
        User user = new User();
        user.setLoginName(username);
        
        user = userInfoService.query(user);
        String roleId = user.getRoleId();
        if(null != roleId && !roleId.isEmpty()){
        	Role role = new Role();
        	role.setId(Long.valueOf(roleId));
        	role = roleService.query(role);
        	String roleName = role.getName();
        	if(roleName != null && !roleName.isEmpty()){
        		roles.add(roleName);
        	}
        	//权限集合
        	List<Authorities> authList = authoritiesService.queryListById(Long.parseLong(roleId));
        	for(Authorities auth : authList){
        		stringPermissions.add(auth.getPermission());
        	}
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(stringPermissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        
        User user = new User();
        user.setLoginName(username);
        user = userInfoService.query(user);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if("1".equals(user.getEnabled())) {
            throw new LockedAccountException(); //帐号没有激活
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getLoginName(), //用户名
                user.getUserPassword(), //密码
                //ByteSource.Util.bytes(user.getId()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public AuthoritiesService getAuthoritiesService() {
		return authoritiesService;
	}

	public void setAuthoritiesService(AuthoritiesService authoritiesService) {
		this.authoritiesService = authoritiesService;
	}

}
