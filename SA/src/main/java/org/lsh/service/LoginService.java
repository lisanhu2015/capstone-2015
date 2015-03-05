package org.lsh.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.lsh.model.User;
import org.lsh.util.db.HibernateUtils;
import org.lsh.util.model.LoginUser;
import org.lsh.utils.MessageQueue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lsh on 15/3/3.
 */
@Component
public class LoginService {

    @Autowired
    private HibernateUtils hibernateUtils;

    public void setHibernateUtils(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    public boolean Login(LoginUser user, MessageQueue queue) {
        String hql = "from User where userId = ? and password = ?";
        List result = hibernateUtils.query(hql, user.getUserId(),
                DigestUtils.sha256Hex(user.getPassword().toLowerCase()));

        hql = "from " + user.getRole() + " where userId = ?";
        List users = hibernateUtils.query(hql, user.getUserId());

        if (result.size() == 0 || users.size() == 0) {
            MessageQueue.add(queue, "general", "Invalid userId/password combination");
            return false;
        } else if (result.size() > 1 || users.size() > 1) {
            MessageQueue.add(queue, "internal", String.format("Internal database error: multiple user record for userId(%s)/password(%s)", user.getUserId(), user.getPassword()));
            return false;
        }


        return true;
    }

}
