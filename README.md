# Bakery Shop POS with Remote Banking System

> A Java SE desktop application that applies distributed computing principles to a real-world retail scenario — a bakery POS system backed by a remote banking server, communicating entirely through Java RMI with zero direct database access on the client side.

Built across three decoupled modules, the system demonstrates how **Java Remote Method Invocation (RMI)** enables a client to call methods on a server object as if it were local — abstracting the network entirely. The bakery handles sales and orders through a clean MVC interface, while all financial operations are delegated to a dedicated bank server managing three independent MySQL databases.

---

## 🏗️ Architecture Overview

```
┌──────────────────────────────────┐            ┌─────────────────────────────────────────┐
│   Prj_Bakery  (POS Interface)    │            │   Prj_Bank_Server  (RMI Server)         │
│                                  │            │                                         │
│  · Login / Dashboard             │  Java RMI  │   Remote Interface (Stub/Skeleton)      │
│  · Product Management            │ ─────────► │  ┌───────────────────────────────────┐ │
│  · Order Processing & Receipt    │ ◄───────── │  │   Remote Service Implementation   │ │
│  · Sales & Report Management     │            │  ├───────────────────────────────────┤ │
│                                  │            │  │   DAO Layer  (DatabaseUtil)        │ │
│  MVC Pattern  ·  No DB           │            │  ├──────────────┬────────┬───────────┤ │
└──────────────────────────────────┘            │  │   bank1 DB   │bank2 DB│  bank3 DB │ │
                                                │  └──────────────┴────────┴───────────┘ │
┌──────────────────────────────────┐            └─────────────────────────────────────────┘
│   Prj_Bank_Client  (RMI Client)  │
│                                  │
│  · Account operations            │
│  · Deposit handling              │
│  · Transaction requests          │
│                                  │
│  No DB  ·  Pure RMI Consumer     │
└──────────────────────────────────┘
```

---

## 🔬 How Java RMI Works — The Theory

**Java RMI (Remote Method Invocation)** is a Java API that allows an object running in one JVM to invoke methods on an object running in a different JVM — even across a network — as if it were a local call.

```
CLIENT SIDE                              SERVER SIDE
───────────────                          ───────────────────────────
BankingService bank                      BankingServiceImpl
  = Naming.lookup(                         extends UnicastRemoteObject
      "rmi://host/BankingService"            implements BankingService
    );
                                         Naming.rebind(
bank.deposit(accountId, amount);           "rmi://host/BankingService",
     │                                       new BankingServiceImpl()
     │  looks like a local call            );
     ▼
  [ Stub ]  ──── network ────►  [ Skeleton ]
  Marshals args                  Unmarshals args
  Sends request                  Invokes real method
  Waits for result               Returns result
     ◄──────────────────────────────────────
```

**Key components in this project:**

| Component | Role |
|---|---|
| **Remote Interface** | Declares the methods the client can call remotely |
| **Stub** | Client-side proxy — serialises arguments and sends the request over the network |
| **Skeleton** | Server-side receiver — deserialises arguments and delegates to the real implementation |
| **RMI Registry** | Name server — the server binds its service here; the client looks it up by name |
| **UnicastRemoteObject** | Base class the server implementation extends to become remotely accessible |

This means the **bakery client never knows where the bank is** — it simply calls `bank.deposit()` and RMI handles marshalling, network transport, and response delivery transparently.

---

## 📦 Module Breakdown

### `Prj_Bakery` — POS Interface
The front-facing desktop application for bakery staff, built with a clean **MVC pattern**. Contains absolutely no database logic — all banking operations are delegated remotely, and all UI state flows through controllers.

| Layer | Responsibility |
|---|---|
| **Controllers** | Login, dashboard, orders, receipts, products, sales, reports |
| **Views** | Swing-based desktop UI screens per workflow |
| **Models** | Local data representations passed between layers |

### `Prj_Bank_Client` — RMI Consumer
A pure RMI client — holds no database connections and performs no persistence. It looks up the remote banking service from the RMI registry and calls its methods directly. From the application's perspective, the bank server could be running on the same machine or across a network — the code is identical either way.

### `Prj_Bank_Server` — RMI Server + DAO
The single source of truth for all banking data. Registers the remote service on the RMI registry at startup and exposes it to any connected client. All database access is cleanly abstracted through a **DAO layer**, with three independent MySQL bank databases configured via a shared `DatabaseUtil`:

```
com.example.server.dao.config.DatabaseUtil
  DRIVER    → com.mysql.cj.jdbc.Driver
  BANK1_URL → jdbc:mysql://localhost:3306/prj_se_bank1
  BANK2_URL → jdbc:mysql://localhost:3306/prj_se_bank2
  BANK3_URL → jdbc:mysql://localhost:3306/prj_se_bank3
```

---

## ✨ Key Design Decisions

**Why RMI over a REST API?**
RMI operates at the object level — the client calls typed Java methods with compile-time safety. There is no JSON serialisation, no HTTP overhead, and no endpoint mapping to maintain. For a Java-to-Java system, RMI delivers tighter integration and simpler code at the cost of language portability — an acceptable trade-off in a controlled Java SE environment.

**Why keep the client DB-free?**
Separating persistence entirely to the server enforces a true client–server boundary. The bakery POS cannot corrupt banking data, cannot bypass business rules, and does not need to know anything about the database schema. This mirrors how real banking systems expose controlled APIs rather than raw database access.

**Why three separate bank databases?**
Each database simulates an independent banking institution. This demonstrates multi-tenancy at the data layer — the server routes operations to the correct bank based on context, while the DAO layer abstracts which physical database is being accessed.

---

## 🛠️ Tech Stack

| Area | Technology |
|---|---|
| Language | Java SE |
| Distributed Computing | Java RMI |
| UI Framework | Java Swing / AWT |
| UI Pattern | MVC |
| Database | MySQL (3 independent instances) |
| DB Access Pattern | DAO (Data Access Object) |
| Architecture | Multi-module distributed Client–Server |

---

## 🚀 Getting Started

**1. Import the database**
```bash
mysql -u root -p < bakery.sql
```
Creates all three bank databases: `prj_se_bank1`, `prj_se_bank2`, `prj_se_bank3`.

**2. Verify DB credentials** in `com.example.server.dao.config.DatabaseUtil` (defaults to `root / root`).

**3. Start `Prj_Bank_Server`** — binds the remote banking service to the RMI registry on port `1099`.

**4. Run `Prj_Bakery`** — launches the POS desktop interface via `MyApp.main()`.

> ⚠️ The RMI server must be running and registered before the client attempts a lookup. Starting the client first will throw a `NotBoundException`.

---

## 💡 What This Project Demonstrates

- **Distributed computing with Java RMI** — understanding of stub/skeleton architecture, RMI registry, and transparent network method invocation
- **Hard client–server boundary** — the client owns zero persistence; all data access is gated through the remote service
- **MVC on a desktop application** — clean separation of UI, logic, and data representation in a Swing environment
- **DAO pattern server-side** — persistence logic is fully encapsulated, making it independently testable and swappable
- **Multi-database routing** — a single server manages three independent bank instances through a unified configuration layer
