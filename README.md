# EuroConnectTelecoms 🚉📡

A **JavaFX + Kotlin + Scala** desktop application that computes and visualizes the **Minimum Spanning Tree (MST)** from a list of cities and distances using **Kruskal’s Algorithm**.

---

## 💡 Project Overview

EuroConnectTelecoms simulates the process of connecting European cities with minimum cost using advanced graph algorithms.

### 🔧 Technologies Used:
- **Kotlin** (OO + Functional paradigms)
- **Scala** (OO + Functional paradigms)
- **JavaFX** (Graphical User Interface)
- **Maven** (Project build and dependency management)
- **FXML** (UI markup)

---

## 📁 Features

✅ Load a CSV file with city-to-city distances  
✅ Visualize a fully connected graph  
✅ Select **Language** (Kotlin / Scala)  
✅ Choose **Paradigm** (Object-Oriented / Functional)  
✅ Compute and display the **Minimum Spanning Tree (MST)**  
✅ Dynamic graph rendering with cities, edges, and weights  
✅ Clean and responsive UI with JavaFX

---

## 📷 Screenshots

| Full Graph View | MST View |
|-----------------|-----------|
| ![Full Graph](Screenshots/BeforeRunningMST.png) | ![MST View](Screenshots/AfterRunningMST.png) |

---

## 📂 CSV Input Format

The app accepts `.csv` files with the following structure:

```csv
City1,City2,Distance
Paris,Berlin,450
Berlin,Rome,600
Paris,Rome,700
...
