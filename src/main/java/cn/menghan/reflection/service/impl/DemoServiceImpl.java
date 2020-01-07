package cn.menghan.reflection.service.impl;

import cn.menghan.reflection.annotation.OauthOrg;
import cn.menghan.reflection.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author by liu.hongda
 * @date 2020/1/7 10:56
 */
@Service
public class DemoServiceImpl implements DemoService {

    @OauthOrg
    @Override
    public String saveDemo(String orgName) {
        if (orgName.equals("person")) {
            return "yes";
        }
        return "no";
    }
}
