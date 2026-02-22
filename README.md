# GraphQLProject
Learning Graphql
# Spring Boot security


🟢 1️⃣ LOGIN FLOW (Authentication Flow)

          ## 🔐 Authentication Flow

```text
Client
   │
   │  POST /auth/login
   ▼
AuthController.login()
   │
   │  calls
   ▼
AuthenticationManager.authenticate()
   │
   │  internally calls
   ▼
CustomUserDetailsService.loadUserByUsername()
   │
   │  fetch user from
   ▼
UserRepository.findByUsername()
   │
   │  returns User entity
   ▼
PasswordEncoder.matches()
   │
   │  compares raw password with BCrypt hash
   ▼
Authentication Successful
   │
   ▼
JwtService.generateAccessToken()
   │
   ▼
Return LoginResponse (accessToken)
```



    ```mermaid
flowchart TD
A[Client] --> B[POST /auth/login]
B --> C[AuthController.login()]
C --> D[AuthenticationManager.authenticate()]
D --> E[CustomUserDetailsService.loadUserByUsername()]
E --> F[UserRepository.findByUsername()]
F --> G[PasswordEncoder.matches()]
G --> H[Authentication Successful]
H --> I[JwtService.generateAccessToken()]
I --> J[Return LoginResponse]
 

# deep flow for login using spring security

```text
Controller
    ↓
authenticationManager.authenticate()
    ↓
ProviderManager.authenticate()
    ↓
DaoAuthenticationProvider.authenticate()
    ↓
retrieveUser()
    ↓
loadUserByUsername()   ← your class
    ↓ (returns UserDetails)
DaoAuthenticationProvider.authenticate()
    ↓
passwordEncoder.matches()
    ↓
createSuccessAuthentication()
    ↓
NEW UsernamePasswordAuthenticationToken (authenticated)
    ↓
Return to ProviderManager
    ↓
Return to Controller                      
          
```