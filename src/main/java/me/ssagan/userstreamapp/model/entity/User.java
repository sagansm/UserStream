package me.ssagan.userstreamapp.model.entity;

public class User {
    Long id;
    String login;
    String password;
    int age;

    private User() {
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Long id) {
            User.this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setAge(int age) {
            User.this.age = age;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
