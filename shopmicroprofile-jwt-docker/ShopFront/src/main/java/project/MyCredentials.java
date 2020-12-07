/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@SessionScoped
@Named
public  class MyCredentials implements Serializable {
    
    private static String subject;
    private static List<String> groups;
    private static String loginStatus;
    private static String stausMessage;

    public MyCredentials() {
    }

    public static String getSubject() {
        return subject;
    }

    public  void setSubject( String subject) {
        this.subject = subject;
    }

    public static List<String> getGroups() {
        return groups;
    }

    public  void  setGroups(List<String> groups) {
        this.groups = groups;
    }

    public static String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public static String getStausMessage() {
        return stausMessage;
    }

    public void setStausMessage(String stausMessage) {
        this.stausMessage = stausMessage;
    }
    
    
}
