package io.github.happy1claire.diary.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /** Unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Unique username used for login and identification. */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /** Hashed password for authentication. */
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    /** Email address associated with the user account. */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /** Name to be displayed in the UI, can differ from username. */
    @Column(name = "display_name")
    private String displayName = "";

    /** Short biography or user description. */
    @Column(name = "bio", length = 1000)
    private String bio;

    /** URL of the user's avatar image. */
    @Column(name = "picture_url")
    private String pictureUrl;

    /** Timestamp of the user's most recent login. */
    @Column(name = "last_login_at")
    private java.time.LocalDateTime lastLoginAt;

    /** Whether the user account is active. */
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    /** Whether the user's email has been verified. */
    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    /** Role assigned to the user (e.g., USER, ADMIN). */
    @Column(name = "role", nullable = false)
    private String role = "USER";

    /** Third-party login provider (e.g., google, github). */
    @Column(name = "provider")
    private String provider;

    /** Optional authentication token for session or JWT refresh. */
    @Column(name = "auth_token")
    private String authToken;

    /** Timestamp when the user account was created. */
    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt;

    /** Timestamp when the user account was last updated. */
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    /**
     * Default constructor required by JPA.
     */
    public User() {
        // Default constructor
    }

    /**
     * Constructs a new User with the provided basic information.
     *
     * @param username     the unique username of the user
     * @param password     the hashed password of the user
     * @param email        the user's email address
     * @param displayName  the name to be displayed in the UI
     */
    public User(String username, String password, String email, String displayName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.displayName = displayName;
        this.role = "USER";
        this.isActive = true;
        this.isVerified = false;
    }

    /**
     * Constructs a new User with the provided basic information without displayName.
     *
     * @param username     the unique username of the user
     * @param password     the hashed password of the user
     * @param email        the user's email address
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.displayName = "";
        this.role = "USER";
        this.isActive = true;
        this.isVerified = false;
    }

    /**
     * Returns the unique identifier of the user.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the user ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the hashed password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password. Ensure the password is already hashed before calling this method.
     *
     * @param password the hashed password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's email address.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the display name of the user.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name of the user.
     *
     * @param displayName the name to be shown in UI
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the bio of the user.
     *
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the bio of the user.
     *
     * @param bio the biography or personal description
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Returns the avatar URL of the user.
     *
     * @return the avatar URL
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets the avatar URL of the user.
     *
     * @param pictureUrl the URL to the avatar image
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * Returns the last login time of the user.
     *
     * @return the timestamp of last login
     */
    public java.time.LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    /**
     * Sets the last login time of the user.
     *
     * @param lastLoginAt the timestamp of last login
     */
    public void setLastLoginAt(java.time.LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    /**
     * Returns whether the user is active.
     *
     * @return true if the user is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status of the user.
     *
     * @param active the active status
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Returns whether the user's email is verified.
     *
     * @return true if verified, false otherwise
     */
    public boolean isVerified() {
        return isVerified;
    }

    /**
     * Sets the email verification status of the user.
     *
     * @param verified whether the email is verified
     */
    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    /**
     * Returns the user's role.
     *
     * @return the role (e.g., USER or ADMIN)
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the user's role.
     *
     * @param role the role of the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the third-party authentication provider.
     *
     * @return the provider name
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Sets the third-party authentication provider.
     *
     * @param provider the provider name
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Returns the authentication token.
     *
     * @return the auth token
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Sets the authentication token.
     *
     * @param authToken the token used for authentication
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Returns the creation timestamp of the user.
     *
     * @return the createdAt timestamp
     */
    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp of the user.
     *
     * @param createdAt the time the user was created
     */
    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the last update timestamp of the user.
     *
     * @return the updatedAt timestamp
     */
    public java.time.LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last update timestamp of the user.
     *
     * @param updatedAt the time the user was last updated
     */
    public void setUpdatedAt(java.time.LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Checks equality based on the user's ID.
     *
     * @param o the object to compare
     * @return true if both users have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && id.equals(user.id);
    }

    /**
     * Returns the hash code based on the user's ID.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a string representation of the user, excluding sensitive information.
     *
     * @return string representation of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", isActive=" + isActive +
                ", isVerified=" + isVerified +
                ", role='" + role + '\'' +
                '}';
    }

    /**
     * Lifecycle callback to set createdAt and updatedAt before the entity is persisted.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = java.time.LocalDateTime.now();
    }

    /**
     * Lifecycle callback to update updatedAt before the entity is updated.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
