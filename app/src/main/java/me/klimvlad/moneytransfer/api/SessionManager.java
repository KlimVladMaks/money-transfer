package me.klimvlad.moneytransfer.api;

public class SessionManager {
    private static SessionManager instance;
    private String sessionId;
    
    private SessionManager() {}
    
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public String getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public boolean isLoggedIn() {
        return sessionId != null && !sessionId.isEmpty();
    }
}
