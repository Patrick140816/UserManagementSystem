package com.neu.zhu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Patrick Zhu
 * @since 2021.7.7
 */
public class Application {
    public static void main(String[] args) {
        LinkedList<Users> list = new LinkedList<Users>();
        // 首先创建一个管理员账户
        Users administrator = new Users();
        administrator.setName("Administrator");
        administrator.setPassword(3705);
        administrator.setAuthority("管理员");
        list.add(administrator);

        while (true) {
            System.out.println("Welcome to use neusoft user management system");
            System.out.println("=============================================");
            System.out.println("[1]用户登录");
            System.out.println("[2]用户注册");
            System.out.println("[3]退出程序");
            System.out.print("Please choose the number of the function:");
            Scanner enter = new Scanner(System.in);
            int operation = enter.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("用户登录界面");
                    System.out.println("==========");
                    loginInterface(list);
                    break;
                case 2:
                    System.out.println("用户注册界面");
                    System.out.println("==========");

                    Users user = new Users();
                    Scanner input = new Scanner(System.in);
                    System.out.println("请输入您的用户名");
                    user.setName(input.nextLine());

                    System.out.println("请输入您的数字密码");
                    user.setPassword(input.nextInt());
                    String none = input.nextLine();

                    System.out.println("请输入您的邮箱");
                    user.setEmail(input.nextLine());
                    user.setAuthority("普通用户");

                    System.out.println("用户注册成功");
                    list.add(user);
                    break;
                case 3:
                    System.out.println("System exit.");
                    System.exit(0);
                default:
                    System.out.println("There isn't such function!\n");
                    break;
            }
        }
    }

    /**
     * 该方法传递一个用户链表list，用来实现用户管理系统的登录功能
     * @param list 用户链表
     */
    static void loginInterface(LinkedList<Users> list) {
        if (list.size() == 0) {
            System.out.println("There's no data in the LinkedList.\n");
        } else {
            boolean loginSuccess = false;
            Scanner input = new Scanner(System.in);
            System.out.println("请输入您的用户名");
            String id = input.nextLine();
            System.out.println("请输入您的数字密码");
            int pwd = input.nextInt();

            for (Users users : list) {
                loginSuccess = loginAuthentication(id, pwd, users);

                if (loginSuccess) {
                    System.out.println("登录成功。。。");
                    System.out.println("============");
                    System.out.println("欢迎登录主窗体");
                    if ("管理员".equals(users.getAuthority())) {
                        System.out.println(users.getName() + "您好；您的权限是：管理员");
                        System.out.println("===============");
                        boolean mark = true;
                        while (mark) {
                            System.out.println("[1]添加用户\n[2]删除用户\n[3]修改用户\n[4]查询用户\n[5]程序退出");

                            int operation = input.nextInt();
                            Admin admin = new Admin();
                            switch (operation) {
                                case 1 :
                                    addUsersMethod(admin, list);
                                    break;
                                case 2 :
                                    deleteUsersMethod(admin, list);
                                    break;
                                case 3 :
                                    modifyUsersMethod(admin, list);
                                    break;
                                case 4 :
                                    searchUsersMethod(admin, list);
                                    break;
                                case 5 :
                                    System.out.println("管理员退出");
                                    mark = false;
                                    break;
                                default :
                                    System.out.println("该功能不存在\n");
                                    break;
                            }
                        }
                    } else if ("普通用户".equals(users.getAuthority())) {
                        System.out.println(users.getName() + "您好；您的权限是：普通用户");
                        System.out.println("===============");

                        boolean flag = true;
                        while (flag == true) {
                            System.out.println("[1]修改自己的信息");
                            System.out.println("[2]查询自己的信息");
                            System.out.println("[3]程序退出");

                            int choose = input.nextInt();
                            switch (choose) {
                                case 1:
                                    System.out.println("您现在的信息是：");
                                    System.out.println((list.indexOf(users) + 1) + "  " + users.toString());
                                    System.out.println("============");
                                    Scanner enter = new Scanner(System.in);
                                    System.out.println("请输入要修改的姓名");
                                    users.setName(enter.nextLine());

                                    System.out.println("请输入要修改的密码");
                                    users.setPassword(enter.nextInt());
                                    String none = enter.nextLine();

                                    System.out.println("请输入要修改的邮箱");
                                    users.setEmail(enter.nextLine());

                                    System.out.println("修改成功");
                                    break;
                                case 2:
                                    System.out.println(list.indexOf(users) + "  " + users.toString());
                                    break;
                                case 3:
                                    System.out.println("普通用户退出");
                                    flag = false;
                                    break;
                                default:
                                    System.out.println("There isn't such function!\n");
                                    break;
                            }
                        }
                    }
                    break;
                }
            }
            if (loginSuccess == false) {
                System.out.println("该用户不存在，登录失败。");
            }
        }
    }

    static boolean loginAuthentication(String id, int number, Users user) {
        if ((id.equals(user.getName())) && (user.getPassword() == number)) {
            return true;
        } else
            return false;
    }

    /**
     * 该方法传递一个对象admin和一个链表list，用来间接调用Admin类中的非静态方法向list链表中添加普通用户信息
     * @param admin
     * @param list 用户链表
     */
    static void addUsersMethod(Admin admin, LinkedList<Users> list) {
        admin.addUsers(list);
    }
    static void deleteUsersMethod(Admin admin, LinkedList<Users> list) {
        admin.deleteUsers(list);
    }
    static void modifyUsersMethod(Admin admin, LinkedList<Users> list) {
        admin.modifyUsers(list);
    }
    static void searchUsersMethod(Admin admin, LinkedList<Users> list) {
        admin.searchUsers(list);
    }
}