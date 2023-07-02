package com.example;

import com.example.dao.mapper.PermissionMapper;
import com.example.model.entity.Permission;
import com.example.model.entity.User;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
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
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = User.builder()
                .username("wangwu")
                .password(cryptPasswordEncoder.encode("123456"))
                .fullName("zhangsan")
                .contact("13639234704")
                .address("山东省淄博市")
                .email("3112371994@qq.com")
                .gender("男")
                .build();
        boolean save = userService.save(user);
        System.out.println(save ? "插入成功" : "插入失败");
    }


    @Test
    void SecurityBea() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        // 进行密码匹配，参数一：明文； 参数2：密码
        boolean matches = bCryptPasswordEncoder.matches("123456", "$10$NURHQtGm64Npcf0rLlb2f.tBcp8QT0eiQtv73vfKKDjpxZYqJhv6S");
        assertTrue(matches);
    }
}
