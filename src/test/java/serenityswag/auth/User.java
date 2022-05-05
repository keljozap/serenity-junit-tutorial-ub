package serenityswag.auth;

public enum User {
    STANDARD_USER("standard_user", "secret_sauce", " "),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", " "),
    PROBLEM_USER("problem_user", "secret_sauce", " "),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", " ");

    private final String userName;
    private final String password;
    private final String description;

    User(String userName, String password, String description) {
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
