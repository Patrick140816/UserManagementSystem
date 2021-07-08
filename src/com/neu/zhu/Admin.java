package com.neu.zhu;

import java.util.LinkedList;
import java.util.Scanner;

public class Admin implements Administrator{
    @Override
    public void addUsers(LinkedList<Users> list) {
        Scanner input = new Scanner(System.in);
        Users newUser = new Users();

        System.out.println("请输入用户名：");
        newUser.setName(input.nextLine());

        System.out.println("请输入密码：");
        newUser.setPassword(input.nextInt());
        String none = input.nextLine();

        System.out.println("请输入邮箱：");
        newUser.setEmail(input.nextLine());
        newUser.setAuthority("普通用户");

        list.add(newUser);
        System.out.println("添加用户成功");
    }

    @Override
    public void deleteUsers(LinkedList<Users> list) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要删除用户的ID号码");
        int id = scan.nextInt();
        boolean sign = false;

        for (Users users : list) {
            if (list.indexOf(users) + 1 == id) {
                sign = true;
                list.remove(users);
                System.out.println("删除用户成功");
                break;
            }
        }
        if (sign == false)
            System.out.println("No data.");
    }

    @Override
    public void modifyUsers(LinkedList<Users> list) {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入要修改的用户的ID号码");
        int id = enter.nextInt();
        boolean flag = false;
        for (Users users : list) {
            if (list.indexOf(users) + 1 == id) {
                flag = true;
                System.out.println("请输入要修改的用户的姓名");
                users.setName(enter.nextLine());

                System.out.println("请输入要修改的用户的密码");
                users.setPassword(enter.nextInt());
                String none = enter.nextLine();

                System.out.println("请输入要修改的用户的邮箱");
                users.setEmail(enter.nextLine());

                do {
                    System.out.println("请输入要修改的用户的权限（管理员/普通用户）");
                    if ("管理员".equals(enter.nextLine())) {
                        users.setAuthority("管理员");
                    } else if ("普通用户".equals(enter.nextLine())) {
                        users.setAuthority("普通用户");
                    } else {
                        System.out.println("Input error!Please enter again.");
                        users.setAuthority(null);
                    }
                } while (users.getAuthority() != null);

                System.out.println("修改成功");
                break;
            }
        }
        if (flag == false)
            System.out.println("No data.");
    }

    @Override
    public void searchUsers(LinkedList<Users> list) {
        System.out.println("[1]查询全部用户\n[2]根据ID查询用户\n[3]根据姓名查询用户");
        System.out.print("请输入要做的操作：");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();

        switch (choose) {
            case 1 :
                for (int i = 0; i < list.size(); i++) {
                    Users users =  list.get(i);
                    System.out.println((list.indexOf(users) + 1) + "  " + users.toString());
                    System.out.println("====================");
                }
                break;
            case 2 :
                System.out.println("请输入要查询的ID");
                int id = input.nextInt();
                boolean sign = false;

                for (int i = 0; i < list.size(); i++) {
                    Users users =  list.get(i);
                    if (list.indexOf(users) + 1 == id) {
                        sign = true;
                        System.out.println((list.indexOf(users) + 1) + "  " + users.toString());
                        break;
                    }
                }
                if (sign == false)
                    System.out.println("No data.");
                break;
            case 3 :
                System.out.println("请输入要查询的用户名（支持模糊查询）");
                String none = input.nextLine();
                String str = input.nextLine();
                boolean mark = false;

                for (int i = 0; i < list.size(); i++) {
                    Users users =  list.get(i);
                    if (users.getName().contains(str)) {
                        mark = true;
                        System.out.println((list.indexOf(users) + 1) + "  " + users.toString());
                        System.out.println("====================");
                        break;
                    }
                }
                if (mark == false)
                    System.out.println("No data.");
                break;
            default :
                System.out.println("There isn't such function!\n");
                break;
        }
    }
}
