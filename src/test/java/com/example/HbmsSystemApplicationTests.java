package com.example;

import com.example.dao.mapper.PermissionMapper;
import com.example.model.entity.Permission;
import com.example.model.entity.User;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HbmsSystemApplicationTests {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println(494948353 < Integer.MAX_VALUE);
    }

    @Test
    void permission() {
        List<String> strings = permissionMapper.queryPermissionByUserId(1);
        System.out.println(strings);
    }

    @Test
    void permiss() {
        List<String> strings = permissionMapper.queryAllByPermissionDescriptionStrings();
        System.out.println(strings);
    }

    @Test
    void user() {
        User user = User.builder()
                .username("zhangsan")
                .password("123456")
                .fullName("zhangsan")
                .contact("13639234704")
                .address("山东省淄博市")
                .email("3112371994@qq.com")
                .gender("男")
                .build();
        boolean save = userService.save(user);
        System.out.println(save ? "插入成功" : "插入失败");
    }

}
