package bootcamp.soloproject.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthorizedControlService {

    public Boolean hasAcces(String username){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println(jwt.getClaims());
        Map<String, Object> test = jwt.getClaims();
        String result = (String)test.get("preferred_username");
        return result.equals(username) || result.equals("admin");
    }

    public Boolean hasAcces(){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println(jwt.getClaims());
        Map<String, Object> test = jwt.getClaims();
        String result = (String)test.get("preferred_username");
        return result.equals("admin");
    }
}
