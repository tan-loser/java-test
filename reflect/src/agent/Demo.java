package agent;

public class Demo {
    public static void main(String[] args) {
        UserService userService = ProxyUtil.getProxy(new UserServiceImpl());
        System.out.println(userService.login("admin", "1234"));
        System.out.println(userService.deleteUsers());
        userService.selectUsers();
        userService.updateUsers(); // 走代理
    }
}
