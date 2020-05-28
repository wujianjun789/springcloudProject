package com.windaka.suizhi.user.service;

import com.windaka.suizhi.api.common.Page;
import com.windaka.suizhi.api.oss.sys.HtMenu;
import com.windaka.suizhi.api.oss.sys.HtPermission;
import com.windaka.suizhi.api.user.AppUser;
import com.windaka.suizhi.api.user.LoginAppUser;
import com.windaka.suizhi.api.user.Role;
import com.windaka.suizhi.common.exception.OssRenderException;
import com.windaka.suizhi.user.model.BaseCommunity;
import com.windaka.suizhi.user.model.HtUser;
import com.windaka.suizhi.user.model.ext.ExtHtUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AppUserService {

    /**
     * 新增OSS用户
     *
     * @param appUser
     */
    String saveAppUser(AppUser appUser, Set<String> roleIds) throws OssRenderException;

    /**
     * 修改OSS用户
     *
     * @param appUser
     */
    String updateAppUser(AppUser appUser, Set<String> roleIds) throws OssRenderException;

    /**
     * @Author: hjt
     * @Date: 2018/12/18
     * @Description: 删除OSS用户
     */
    void deleteAppUser(String userId) throws OssRenderException;

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @param password
     * @return
     */
    LoginAppUser queryByUsername(String username, String password);

    /**
     * 根据用户ID查询用户
     *
     * @param userId
     * @return java.lang.Map
     */
    Map<String, Object> queryByUserId(String userId) throws OssRenderException;

    /**
     * 根据用户ID查询用户-返回实体
     *
     * @param userId
     * @return AppUser
     */
    AppUser queryByUserIdForAppUser(String userId) throws OssRenderException;

    /**
     * 设置用户角色
     *
     * @param userId
     * @param roleIds
     */
    void saveRoleToUser(String userId, Set<String> roleIds) throws OssRenderException;

    /**
     * 密码修改
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     */
    void updatePassword(String userId, String oldPassword, String newPassword) throws OssRenderException;

    /**
     * 查询用户列表，分页
     *
     * @param params
     * @return
     */
    Page<Map<String, Object>> queryList(Map<String, Object> params) throws OssRenderException;

    /**
     * 根据用户ID，查询用户角色
     *
     * @param userId
     * @return
     */
    Set<Role> queryRolesByUserIdForRole(String userId) throws OssRenderException;

    /**
     * 获取当前用户角色的菜单
     *
     * @param userId
     * @return
     */
    List<HtMenu> queryUserRoleMenus(String userId) throws OssRenderException;

    /**
     * 获取当前用户的菜单-管理员用
     *
     * @param
     * @return
     */
    List<HtMenu> queryAdminMenus() throws OssRenderException;

    /**
     * @Author: hjt
     * @Date: 2018/12/24
     * @Description: 获取当前用户操作按钮
     */
    Set<HtPermission> queryLoginUserPermissions() throws OssRenderException;

    LoginAppUser updateMe(Map<String, Object> map) throws OssRenderException;

    /**
     * 根据parentId查询下级区域信息
     *
     * @param parentId
     * @return
     * @throws OssRenderException
     */
    List<Map<String, Object>> queryAreaInfoByPid(String parentId) throws OssRenderException;

    /**
     * 给用户设置上小区
     *
     * @param userId
     * @param xqCodes
     * @throws OssRenderException
     */
    void saveXqToUser(String userId, Set<String> xqCodes) throws OssRenderException;

    /**
     * 给用户设置上小区(根据username)
     *
     * @param username
     * @param xqCodes
     * @throws OssRenderException
     */
    void saveXqToUserByUsername(String username, Set<String> xqCodes) throws OssRenderException;

    /**
     * 用户小区关系解绑(根据username)
     *
     * @param username
     * @param xqCodes
     * @throws OssRenderException
     */
    void deleteXqUserByUsername(String username, Set<String> xqCodes) throws OssRenderException;

    /**
     * 用户街道关系绑定
     *
     * @param map
     * @throws OssRenderException
     */
    void saveUserSubdistrict(Map<String, Object> map) throws OssRenderException;

    /**
     * 根据当前登录用户（管理员）查询其下所有区到小区的树状列表
     *
     * @return
     * @throws OssRenderException
     */
    List<Map<String, Object>> queryAreaToXq() throws OssRenderException;

    /**
     * 查询该区下的所有街道
     *
     * @return
     * @throws OssRenderException
     */
    List<Map<String, Object>> querySubdistrictByAreaId(String areaId) throws OssRenderException;

    /**
     * 查询街道下的所有小区
     *
     * @return
     * @throws OssRenderException
     */
    List<Map<String, Object>> queryXqBySubdistrictId(String areaId) throws OssRenderException;

    /**
     * 功能描述: 添加用户信息
     *
     * @auther: lixianhua
     * @date: 2020/4/22 9:13
     * @param:
     * @return:
     */
    int insertUser(ExtHtUser user) throws OssRenderException;
    /**
     * 功能描述: 根据userid获取用户信息
     * @auther: lixianhua
     * @date: 2020/4/22 14:00
     * @param:
     * @return:
     */
    ExtHtUser getUserByUserId(String userId);
    /**
     * 功能描述: 获取用户集合
     * @auther: lixianhua
     * @date: 2020/4/22 15:17
     * @param:
     * @return:
     */
    List<ExtHtUser> getUserList(ExtHtUser extHtUser);
    /**
     * 功能描述: 根据街道获取小区信息
     * @auther: lixianhua
     * @date: 2020/4/22 16:59
     * @param:
     * @return:
     */
    List<BaseCommunity> getXqBySub(String subdistrictId);
}
