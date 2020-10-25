
package auth;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.MyCredentials;




//@RememberMe(
//       cookieMaxAgeSeconds = REMEMBERME_VALIDITY_SECONDS,
//       isRememberMeExpression = "self.isRememberMe(httpMessageContext)"
//)

@RequestScoped
@Named

public class ShopAuthenticationMechanism implements HttpAuthenticationMechanism, Serializable {

    private static final Logger LOGGER = Logger.getLogger(ShopAuthenticationMechanism.class.getName());

    /**
     * Access to the
     * IdentityStore(AuthenticationIdentityStore,AuthorizationIdentityStore) is
     * abstracted by the IdentityStoreHandler to allow for multiple identity
     * stores to logically act as a single IdentityStore
     */
    @Inject
   private IdentityStoreHandler identityStoreHandler;
    @Inject private MyCredentials mycredentials;
   AuthenticationStatus status;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) {
        
        System.out.println("In JWT Auth Mechanism");
        LOGGER.log(Level.INFO, "Auth Request: {0}", request.getRequestURI());

       
        
        if (request.getParameter("username")!=null) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        //    Credential credential = context.getAuthParameters().getCredential();
           Credential credential = new UsernamePasswordCredential(username,new Password(password));
        
            CredentialValidationResult result = identityStoreHandler.validate(credential);
            if (result.getStatus() == CredentialValidationResult.Status.VALID) {
               System.out.println("JWTAuthenticationMechanism - CreatingCredential credential1 = new UserNamePasswordCredential token");
                
               
               mycredentials.setSubject(username);
               mycredentials.setGroups(convertSetToList(result.getCallerGroups()));
               mycredentials.setLoginStatus("Login_Success");
               mycredentials.setStausMessage("Hello " + result.getCallerGroups().toString()+" Login Success !!");
               
               
               request.getSession().setAttribute("uname", username);
               request.getSession().setAttribute("groups", convertSetToList(result.getCallerGroups()));
               request.getSession().setAttribute("statusmessage", "Hello " + result.getCallerGroups().toString()+" Login Success !!");
               request.getSession().setAttribute("status",  "Login_Success");
               
                status = context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
                return status;
            }
            else
            {
                     request.getSession().setAttribute("status",  "Login_Failed");
                      request.getSession().setAttribute("statusmessage", "User or Password is wrong. Try Again..");
              
              
            }
               
                
            }
           
            
            // if the authentication fastatusiled, we return the unauthorized status in the http response
      //      return context.responseUnauthorized();
        return context.doNothing();
        }
        
   private  <T> List<T> convertSetToList(Set<T> set) 
    { 
        // create an empty list 
        List<T> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (T t : set) 
            list.add(t); 
  
        // return the list 
        return list; 
    }    
        
}
