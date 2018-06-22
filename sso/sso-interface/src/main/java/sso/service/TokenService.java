package sso.service;

import common.utils.MallResult;

/**
 * 根据token查询用户信息
 */
public interface TokenService {

    MallResult getUserByToken(String token);
}
