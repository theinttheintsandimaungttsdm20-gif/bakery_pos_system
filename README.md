# Bakery Shop POS with Remote Banking System

A Java SE desktop application combining a **Bakery Point-of-Sale system** with a **Remote Banking Service** powered by Java RMI. The bakery staff manages orders and sales through a POS interface, while banking operations (account management, deposits, transactions) are handled remotely by a dedicated bank server — keeping the POS completely decoupled from any banking database.

---

## 🏗️ Architecture Overview

```
┌─────────────────────────────────┐              ┌──────────────────────────────────────┐
│  Prj_Bakery  (POS Interface)    │              │  Prj_Bank_Server                     │
│  · Login / Dashboard            │  Java RMI    │  ┌──────────────────────────────────┐│
│  · Product Management           │ ──────────►  │  │  Remote Service Layer            ││
│  · Order & Receipt              │ ◄──────────  │  ├──────────────────────────────────┤│
│  · Sales & Reports              │              │  │  DAO Layer  (DatabaseUtil)       ││
│  MVC pattern (no DB)            │              │  ├────────────┬──────────┬──────────┤│
└─────────────────────────────────┘              │  │  bank1 DB  │ bank2 DB │ bank3 DB ││
                                                 │  └────────────┴──────────┴──────────┘│
┌─────────────────────────────────┐              └──────────────────────────────────────┘
│  Prj_Bank_Client  (RMI Client)  │
│  · Account operations           │
│  · Deposits                     │
│  · Transaction requests         │
│  (no DB — calls server via RMI) │
└─────────────────────────────────┘
```

---

## 📦 Module Breakdown

### `Prj_Bakery` — POS Interface
The front-facing desktop UI for bakery staff, built with an **MVC pattern**. Contains no database logic — all data flows through controllers and views.

| Controller | Responsibility |
|---|---|
| `LoginController` | Staff authentication |
| `MainController` | App entry point, view orchestration |
| `OrderController` / `OrderReceiptController` | Order processing and receipt generation |
| `ProdNewController` / `ProdSearchController` | Product creation and search |
| `SalesController` / `ReportSalesController` | Sales management and reporting |
| `ReportOrdersController` | Order history and reports |
| `EmpHomeController` | Employee home dashboard |

### `Prj_Bank_Client` — Banking RMI Client
Handles all banking operations from the client side by calling the remote server over RMI. Contains **no database** — acts purely as a network consumer.

- Account management
- Deposit operations
- Transaction requests

### `Prj_Bank_Server` — Banking RMI Server
Exposes the remote banking service and owns all database logic through a **DAO layer**. Connects to three independent bank databases via a shared `DatabaseUtil` config.

```
com.example.server.dao.config.DatabaseUtil
  BANK1_URL → jdbc:mysql://localhost:3306/prj_se_bank1
  BANK2_URL → jdbc:mysql://localhost:3306/prj_se_bank2
  BANK3_URL → jdbc:mysql://localhost:3306/prj_se_bank3
```

---

## 🔑 Key Features

- **Java RMI remoting** — the bank client invokes account, deposit, and transaction methods on the server transparently over the network
- **Full MVC in the POS** — controllers, views, models, and utilities are cleanly separated in `Prj_Bakery`
- **DAO pattern on the server** — database access is fully abstracted, keeping business logic independent of persistence
- **Multi-bank support** — three separate MySQL databases simulate independent banking institutions
- **Zero DB coupling on the client** — neither the POS nor the bank client touch a database directly

---

## 🛠️ Tech Stack

| Area | Technology |
|---|---|
| Language | Java SE |
| Networking | Java RMI |
| UI Pattern | MVC (Swing/AWT) |
| Database | MySQL (3 instances) |
| Design Pattern | DAO, MVC |
| Architecture | Multi-module Client–Server |

---

## 🚀 Setup & Running

**1. Import the database**
```bash
mysql -u root -p < bakery.sql
```
This creates all three bank databases: `prj_se_bank1`, `prj_se_bank2`, `prj_se_bank3`.

**2. Update DB credentials** in `Prj_Bank_Server` → `com.example.server.dao.config.DatabaseUtil` if needed (defaults to `root / root`).

**3. Start `Prj_Bank_Server`** — registers the remote banking service on the RMI registry.

**4. Run `Prj_Bakery`** — launches the POS interface via `MyApp.main()`.

> ⚠️ The bank server must be running before starting the POS client.

---

## 💡 What I Learned

- Designing a **multi-module Java SE application** with clearly defined responsibilities per module
- Using **Java RMI** to perform remote method calls without exposing database logic to the client
- Applying the **MVC pattern** to a desktop Swing application for clean UI separation
- Implementing the **DAO pattern** server-side to keep persistence logic modular and testable
- Managing **multiple database connections** within a single server using a shared utility config
