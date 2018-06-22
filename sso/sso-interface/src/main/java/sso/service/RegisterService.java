package sso.service;

import common.utils.MallResult;
import pojo.TbUser;

public interface RegisterService {

    MallResult checkData(String param, int type);
    MallResult register(TbUser user);
}
