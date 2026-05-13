# Bakery Shop POS with Remote Banking System

> A Java SE desktop application that applies distributed computing principles to a real-world retail scenario — a bakery POS system backed by a remote banking server, communicating entirely through Java RMI with zero direct database access on the client side.

Built across three decoupled modules, the system demonstrates how **Java Remote Method Invocation (RMI)** enables a client to call methods on a server object as if it were local — abstracting the network entirely. The bakery handles sales and orders through a clean MVC interface, while all financial operations are delegated to a dedicated bank server managing three independent MySQL databases.

---

## 🏗️ Architecture Overview

```
┌──────────────────────────────────┐            ┌─────────────────────────────────────────┐
│   Prj_Bakery  (POS Interface)    │            │   Prj_Bank_Server  (RMI Server)         │
│                                  │            │                                         │
│  · Login / Dashboard             │  Java RMI  │   AccountInf  (Remote Interface)        │
│  · Product Management            │ ─────────► │  ┌───────────────────────────────────┐ │
│  · Order Processing & Receipt    │ ◄───────── │  │   AccountInf Implementation       │ │
│  · Sales & Report Management     │            │  ├───────────────────────────────────┤ │
│                                  │            │  │   DAO Layer  (DatabaseUtil)        │ │
│  MVC Pattern  ·  No DB           │            │  ├──────────────┬────────┬───────────┤ │
└──────────────────────────────────┘            │  │   bank1 DB   │bank2 DB│  bank3 DB │ │
                                                │  └──────────────┴────────┴───────────┘ │
┌──────────────────────────────────┐            └─────────────────────────────────────────┘
│   Prj_Bank_Client  (RMI Client)  │
│                                  │
│  · Account operations            │
│  · Deposit / Withdraw            │
│  · Transaction history           │
│                                  │
│  No DB  ·  Pure RMI Consumer     │
└──────────────────────────────────┘
```

---

## 🔬 How Java RMI Works — The Theory

**Java RMI (Remote Method Invocation)** is a Java API that allows an object in one JVM to invoke methods on an object running in a completely separate JVM — even across a network — as if it were a simple local method call. The network transport, argument serialisation, and response handling are entirely invisible to the caller.

### Core Concepts

| Component | Role |
|---|---|
| **Remote Interface** | The shared contract — declares which methods the client is allowed to call remotely |
| **Stub** | Client-side proxy — serialises method arguments and dispatches the request over the network |
| **Skeleton** | Server-side receiver — deserialises incoming arguments and delegates to the real implementation |
| **UnicastRemoteObject** | Makes the server implementation accessible over TCP so clients can connect to it |
| **RMI Registry** | A name server on port `1099` — the server registers its object here; the client resolves it by name |

### The Call Flow

```
CLIENT                          NETWORK                        SERVER
──────────────────────────────────────────────────────────────────────
Calls method on remote object
      │
      ▼
  [ Stub ]  ── serialises args ──────────────►  [ Skeleton ]
             ── sends over TCP ──────────────►  Deserialises args
                                                Invokes real implementation
                                                Executes DAO → Database
             ◄─ serialised result ────────────  Returns result
      │
      ▼
Returns to caller as if local
```

### Why This Matters

The bakery client holds a reference to the **remote interface** (`AccountInf`) — it never sees or imports the server implementation. It simply calls `deposit()`, `withdraw()`, or `getBalance()` and receives a result. Whether the server is on the same machine or across a network is completely transparent. This is the fundamental power of RMI — the distribution is hidden behind a clean Java interface.

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
A pure RMI client — holds no database connections and performs no persistence. It obtains a stub reference to `AccountInf` and calls its methods directly. From the application's perspective, the bank server could be on the same machine or across a network — the code is identical either way.

### `Prj_Bank_Server` — RMI Server + DAO
The single source of truth for all banking data. Exports the `AccountInf` implementation over RMI at startup and exposes it to any connected client. All database access is cleanly abstracted through a **DAO layer**, with three independent MySQL databases configured via a shared `DatabaseUtil`:

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
RMI operates at the object level — the client calls typed Java methods with full compile-time safety. There is no JSON serialisation to write, no HTTP routing to configure, and no endpoint contracts to document separately. For a Java-to-Java system, RMI delivers tighter integration with less boilerplate — an intentional trade-off in a controlled Java SE environment.

**Why keep the client DB-free?**
Separating persistence entirely to the server enforces a true client–server boundary. The bakery POS cannot corrupt banking data, cannot bypass business rules, and does not need to know anything about the database schema. This mirrors how real banking systems expose controlled service interfaces rather than raw database access.

**Why three separate bank databases?**
Each database simulates an independent banking institution. This demonstrates multi-tenancy at the data layer — the server routes operations to the correct bank based on context, while the DAO layer abstracts which physical database is being accessed.

---

## 🛠️ Tech Stack

| Area | Technology |
|---|---|
| Language | Java SE |
| Distributed Computing | Java RMI (`java.rmi`, `UnicastRemoteObject`) |
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

**3. Start `Prj_Bank_Server`** — exports `AccountInf` over RMI and begins listening for client connections.

**4. Run `Prj_Bakery`** — launches the POS desktop interface via `MyApp.main()`.

> ⚠️ The RMI server must be running before the client starts. The client resolves the remote object at startup — if the server is unavailable, the connection will fail immediately.

---

## 💡 What This Project Demonstrates

- **Distributed computing with Java RMI** — real understanding of the stub/skeleton model, remote interface design, and transparent network method invocation
- **Interface-driven design** — the client depends only on the remote interface, never on the implementation — keeping both sides independently evolvable
- **Hard client–server boundary** — the client owns zero persistence; all data access is gated through the remote service contract
- **MVC on a desktop application** — clean separation of UI, logic, and data representation in a Swing environment
- **DAO pattern server-side** — persistence logic is fully encapsulated, independently testable, and swappable without touching the remote interface
- **Multi-database routing** — a single server manages three independent bank instances through a unified configuration layer
