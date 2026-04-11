# Story 4.5: Configure Spring Security

## Epic
[Epic 4: Authentication Module](../epics/epic-04-authentication.md)

## Story
**As a** developer  
**I want to** configure Spring Security  
**So that** the application has proper authentication and authorization

## Acceptance Criteria
- [ ] `SecurityConfig` class in `auth/infrastructure/config/`
- [ ] Uses `@Configuration` and `@EnableWebSecurity`
- [ ] Configures security filter chain:
  - Stateless session management
  - CSRF disabled (for stateless JWT)
  - Public endpoints: `/api/auth/**`, `/actuator/**`
  - All other endpoints require authentication
- [ ] Adds JwtAuthenticationFilter to filter chain
- [ ] Configures PasswordEncoder bean (BCrypt)
- [ ] CORS configuration (if needed)

## Tasks
1. Create `auth/infrastructure/config/SecurityConfig.java`
2. Define `SecurityFilterChain` bean
3. Configure public vs protected endpoints
4. Add JwtAuthenticationFilter before UsernamePasswordAuthenticationFilter
5. Define `PasswordEncoder` bean
6. Test configuration with integration tests

## Estimated Effort
2 hours

## Priority
Must Have

## Notes
Spring Security 6+ uses lambda-style configuration. CSRF can be disabled for stateless JWT APIs.

Implementation skeleton:
```java
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtFilter;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```
