package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Max", "Spar", (byte) 30);
        userService.saveUser("Marina", "Fomenko", (byte) 29);
        userService.saveUser("Ivan", "Popov", (byte) 31);
        userService.saveUser("Vasya", "Ivanov", (byte) 17);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
