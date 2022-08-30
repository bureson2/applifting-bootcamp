package bootcamp.soloproject.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthorizedControlService {

    public Boolean hasAccesToEndpoint(String username){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println(jwt.getClaims());
        Map<String, Object> test = jwt.getClaims();
        String result = (String)test.get("preferred_username");
        return result.equals(username);
    }
}
