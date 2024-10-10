package com.jskno.mobile.lines.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "activeDirectory", url = "${active.directory.url}")
public interface ActiveDirectoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/active-directory/users")
    List<UserDirectory> getUsers();

}
