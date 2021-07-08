package com.neu.zhu;

import java.util.LinkedList;

public interface Administrator {
    public void addUsers(LinkedList<Users> list);
    public void deleteUsers(LinkedList<Users> list);
    public void modifyUsers(LinkedList<Users> list);
    public void searchUsers(LinkedList<Users> list);
}
