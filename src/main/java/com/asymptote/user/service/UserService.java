package com.asymptote.user.service;

import com.asymptote.user.VO.Department;
import com.asymptote.user.VO.ResponseObjectVO;
import com.asymptote.user.entity.User;
import com.asymptote.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseObjectVO getUserWithDepartment(Long userId) {
        log.info("Inside saveUser of getUserWithDepartment");
        ResponseObjectVO vo = new ResponseObjectVO();
        User user = userRepository.findAllByUserId(userId);
        Department department =
                restTemplate
                        .getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
