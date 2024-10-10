package com.jskno.mobile.lines.service;

import com.jskno.mobile.lines.client.ActiveDirectoryClient;
import com.jskno.mobile.lines.client.UserDirectory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ActiveDirectoryClient activeDirectoryClient;

    public List<UserDirectory> retrieveUsers() {
        // Invoke AD CloudService with Feign Client
        return activeDirectoryClient.getUsers();
    }

}
