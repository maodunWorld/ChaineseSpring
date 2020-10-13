package base;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tongjian
 * @date 2020/10/12 19:00
 */
public class JwtTest {

    @Test
    public void createLoads() throws UnsupportedEncodingException {
        Map<String, Object> headerClaims = new HashMap();
        headerClaims.put("owner", "auth0");
        String token = JWT.create()
                .withHeader(headerClaims)
                .withClaim("userId", "test")
                .sign(Algorithm.HMAC256("screte"));
    }
}
