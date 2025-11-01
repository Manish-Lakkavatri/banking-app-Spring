# 🏦 Banking Application (Spring Boot REST API)

A simple **Banking Application** built using **Spring Boot**.  
It provides REST APIs to create accounts, deposit and withdraw money, view account details, and delete accounts.  
The project follows a **layered architecture** with Controllers, Services, Mappers, DTOs, and Models.

---

## ⚙️ Tech Stack
- Java 17+  
- Spring Boot 3+  
- Spring Web  
- Spring Data JPA *(optional)*  
- MapStruct / Manual Mapper *(for DTO conversion)*  
- Maven / Gradle  
- Postman *(for API testing)*  

---

## 🏗️ Project Structure

---

## 🏗️ Project Structure
```

com.example.bankingapp
├── controllers/     # REST Controllers
├── services/        # Business logic
├── mappers/         # Entity ↔ DTO conversion
├── dtos/            # Data Transfer Objects
├── models/          # Domain Models
└── repositories/    # Database access (optional)

````

**Flow:** Controller → Service → Mapper → Model → Repository

---

## 🚀 Features
- Create a new bank account  
- Deposit money into an account  
- Withdraw money from an account  
- Get account details by ID  
- Get all accounts  
- Delete an account  

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/api/v1/accounts` | Create a new account |
| GET | `/api/v1/accounts/{id}` | Get account by ID |
| PUT | `/api/v1/accounts/{id}/deposit` | Deposit funds |
| PUT | `/api/v1/accounts/{id}/withdraw` | Withdraw funds |
| GET | `/api/v1/accounts` | Get all accounts |
| DELETE | `/api/v1/accounts/{id}` | Delete account |

---

## 📘 Example Requests

### Create an Account
**POST** `/api/v1/accounts`
```json
{
  "name": "John Doe",
  "balance": 5000.0
}
````

**Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "balance": 5000.0
}
```

---

### Deposit Money

**PUT** `/api/v1/accounts/1/deposit`

```json
{
  "amount": 1000.0
}
```

**Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "balance": 6000.0
}
```

---

### Withdraw Money

**PUT** `/api/v1/accounts/1/withdraw`

```json
{
  "amount": 500.0
}
```

**Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "balance": 5500.0
}
```

---

## 🧱 Mapper Example

```java
@Component
public class AccountMapper {

    public AccountDTO toDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public Account toEntity(AccountDTO dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());
        return account;
    }
}
```

---

## ▶️ How to Run

```bash
git clone https://github.com/yourusername/banking-app.git
cd banking-app
mvn spring-boot:run
```

Then visit:
`http://localhost:8080/api/v1/accounts`

---

## 💡 Key Points

* Uses **Dependency Injection** for modular and testable code.
* Uses **DTOs and Mappers** for clean data transfer.
* Follows **RESTful principles** for endpoint design.
* Clean **Controller–Service–Mapper–Model** structure.
* Ready for **JPA and database integration**.

---

## 👨‍💻 Author

**Manish L.**
